package pt.iscte.osgi.viscte.visualizer;

import java.util.List;
import java.util.Scanner;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.zest.core.viewers.AbstractZoomableViewer;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;
import org.eclipse.zest.core.viewers.IZoomableWorkbenchPart;
import org.eclipse.zest.core.viewers.ZoomContributionViewItem;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.RadialLayoutAlgorithm;
import org.osgi.framework.Bundle;

import pt.iscte.osgi.viscte.model.Component;
import pt.iscte.osgi.viscte.model.Connection;
import pt.iscte.osgi.viscte.visualizer.bundlegraphmanager.BundleGraphManager;
import pt.iscte.osgi.viscte.visualizer.bundlegraphmanager.BundleGraphUtils;

public class BundleView extends ViewPart implements IZoomableWorkbenchPart {

	private static BundleView instance;

	private GraphViewer viewer;

	private Graph graph;

	public static BundleView getInstance() {
		return instance;
	}

	public void createPartControl(Composite parent) {
		instance = this;
		parent.setLayout(new GridLayout(1, true));
		addViewer(parent);
		fillToolBar();
	}

	@Override
	public AbstractZoomableViewer getZoomableViewer() {
		return viewer;
	}

	private void addViewer(final Composite parent) {
		viewer = new GraphViewer(parent, SWT.BORDER);
		graph = viewer.getGraphControl();
		viewer.setContentProvider(new NodeProvider());
		final StyleProvider provider = new StyleProvider();
		viewer.setLabelProvider(provider);
		viewer.setConnectionStyle(ZestStyles.CONNECTIONS_DIRECTED);
		viewer.setFilters(new NodeFilter[] { new NodeFilter() });
		viewer.setLayoutAlgorithm(new RadialLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
		viewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		addMouseListener(provider);
	}


	private void addMouseListener(final StyleProvider provider) {
		graph.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				IFigure fig = graph.getFigureAt(e.x, e.y);
				if (fig instanceof RectangleFigure) {
					Component component = provider.getComponent(fig);
					if(component != null) {
						ManifestVisitor v = new ManifestVisitor(component);
						try {
							ResourcesPlugin.getWorkspace().getRoot().accept(v);
						} catch (CoreException e1) {
							e1.printStackTrace();
						}
						if(!v.found)
							MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Not found", "MANIFEST.MF for bundle '" + component.getId() + "' was not found in the workspace.");
					}
				}
				else if(fig instanceof PolylineConnection) {
					List<Connection> connections = provider.getConnections(fig.getToolTip());
					for(Connection c : connections) {
						ServiceVisitor v = new ServiceVisitor(c.getServiceClass());
						try {
							ResourcesPlugin.getWorkspace().getRoot().accept(v);
						} catch (CoreException e1) {
							e1.printStackTrace();
						}
						if(!v.found)
							MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Not found", "Service class '" + c.getServiceClass() + "' was not found in the workspace.");
					}
				}
			}
		});
	}

	public void refreshView() {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				viewer.setInput(null);
				viewer.refresh();
				viewer.applyLayout();
			}
		});
	}

	private void fillToolBar() {
		ZoomContributionViewItem toolbarZoomContributionViewItem = new ZoomContributionViewItem(this);
		IActionBars bars = getViewSite().getActionBars();
		bars.getMenuManager().add(toolbarZoomContributionViewItem);
	}

	// TODO: 
	private static boolean exclude(Bundle b) {
		return false; 
	}

	private final class ServiceVisitor implements IResourceVisitor {

		private final String[] path;
		private boolean found;

		public ServiceVisitor(String className) {
			this.path = className.split("\\.");
			found = false;
		}

		@Override
		public boolean visit(IResource resource) throws CoreException {
			if(found)
				return false;

			if(resource instanceof IFolder) {
				IFolder folder = (IFolder) resource;
				if(folder.getName().equals(path[0])) {

					for(int i = 1; i < path.length - 1; i++)
						folder = folder.getFolder(path[i]);

					IFile file = folder.getFile(path[path.length-1]+".java");

					if(file.exists()) {
						IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
						page.openEditor(new FileEditorInput(file), "org.eclipse.jdt.ui.CompilationUnitEditor");
						found = true;
					}
				}
			}
			return true;
		}
	}
	

	private final class ManifestVisitor implements IResourceVisitor {
		private static final String BUNDLE_ID_HEADER = "Bundle-SymbolicName:"; 

		private final Component component;
		private boolean found;

		private ManifestVisitor(Component component) {
			this.component = component;
			found = false;
		}

		@Override
		public boolean visit(IResource resource) throws CoreException {
			if(resource instanceof IFolder && !((IFolder) resource).getName().equals("META-INF"))
				return false;

			if(resource instanceof IFile && ((IFile) resource).getName().equals("MANIFEST.MF")) {
				IFile file = (IFile) resource;
				Scanner scanner = new Scanner(file.getContents());
				while(scanner.hasNextLine()) {
					String line = scanner.nextLine().trim();
					if(
							line.startsWith(BUNDLE_ID_HEADER) && 
							line.substring(BUNDLE_ID_HEADER.length()).trim().startsWith(component.getId())) {
						IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
						page.openEditor(new FileEditorInput(file), "org.eclipse.pde.ui.manifestEditor");
						found = true;
						break;
					}
				}
				scanner.close();
			}
			return !found;
		}
	}		

	public class NodeFilter extends ViewerFilter {

		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			if(element instanceof Bundle)
				return !exclude((Bundle) element);
			else
				return true;
		}
	} 

	private class NodeProvider implements IGraphEntityContentProvider {

		@Override
		public Object[] getElements(Object inputElement) {
			return BundleGraphUtils.getActiveComponents(BundleGraphManager.getInstance().getCurrentTimestamp()).toArray();
		}

		@Override
		public Object[] getConnectedTo(Object entity) {
			if (entity instanceof Component) {
				final Component client = (Component) entity;
				return BundleGraphUtils.getConnectedTo(client, BundleGraphManager.getInstance().getCurrentTimestamp()).toArray();
			}
			return null;
		}

		@Override
		public void dispose() {

		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

		}
	}

	@Override
	public void setFocus() {
	}
}