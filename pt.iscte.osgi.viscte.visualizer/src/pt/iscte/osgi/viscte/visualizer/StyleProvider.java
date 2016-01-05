package pt.iscte.osgi.viscte.visualizer;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.zest.core.viewers.EntityConnectionData;
import org.eclipse.zest.core.viewers.IConnectionStyleProvider;
import org.eclipse.zest.core.viewers.IEntityStyleProvider;
import org.eclipse.zest.core.viewers.IFigureProvider;
import org.eclipse.zest.core.widgets.ZestStyles;

import pt.iscte.osgi.viscte.model.Component;
import pt.iscte.osgi.viscte.model.Connection;
import pt.iscte.osgi.viscte.model.Service;
import pt.iscte.osgi.viscte.visualizer.bundle.Activator;
import pt.iscte.osgi.viscte.visualizer.bundlegraphmanager.BundleGraphUtils;

public class StyleProvider extends LabelProvider implements IEntityStyleProvider, IConnectionStyleProvider , IFigureProvider { // IEntityConnectionStyleProvider  {
	private Image componentImgNoServ;
	private Image componentImgServ;
	private Font font;
	private GC gc;
	
	private Map<IFigure, Component> componentMap;
	private Map<Label, List<Connection>> connectionMap;
	
	public static final Color BLACK_COLOR = new Color(null, 0, 0, 0);
	public static final Color LIGHTGRAY_COLOR = new Color(null, 250, 250, 250);
	public static final Color BLUE_COLOR = new Color(null, 0, 82, 163);
	public static final Color GREEN_COLOR = new Color(null, 0, 163, 0);
	public static final Color WHITE_COLOR = new Color(null, 255, 255, 255);
	
	public StyleProvider() {
		ImageDescriptor imgServ =  AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/component.png");
		componentImgServ = imgServ.createImage();
		ImageDescriptor imgNoServ =  AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/component2.png");
		componentImgNoServ = imgNoServ.createImage();
		Display display = Display.getDefault();
		font = new Font(display, "Arial", 10, SWT.NONE);
		gc = new GC(display);
		gc.setFont(font);
		
		componentMap = new WeakHashMap<IFigure, Component>();
		connectionMap = new WeakHashMap<Label, List<Connection>>();
	}

	@Override
	public String getText(Object element) {

		if (element instanceof Component) {
			return BundleGraphUtils.getSimplifiedId((Component) element);
		} 
		else if (element instanceof EntityConnectionData) {
			EntityConnectionData entityConnectionData = (EntityConnectionData) element;
			Component client = (Component) entityConnectionData.source;
			Component supplier = (Component) entityConnectionData.dest;
			String text = "";
			for (Connection conn : client.getConnections()) {
				if (conn.getService().getComponent().getId().equals(supplier.getId())) {
					if (text.isEmpty()) {
						text += BundleGraphUtils.getSimplifiedId(conn.getService());
					} else {
						text += ", " + BundleGraphUtils.getSimplifiedId(conn.getService());
					}
				}
			}
			return text;
		}
		return element.toString();
	}

	@Override
	public IFigure getTooltip(Object entity) {
		if (entity instanceof Component) {
			Component component = (Component) entity;
			String services = "";
			if (component.getServices().size() > 0) {
				for (Service service : component.getServices()) {
					services += "\n" + service.getId();
				}
			} else {
				services += "None";
			}
			return new Label(String.format("Bundle: %s\nRegistered services: %s", 
					component.getId(),
					services));
		}
		else if (entity instanceof EntityConnectionData) {
			EntityConnectionData entityConnectionData = (EntityConnectionData) entity;
			Component client = (Component) entityConnectionData.source;
			Component supplier = (Component) entityConnectionData.dest;
			String services = "";
			for (Connection conn : client.getConnections()) {
				if (conn.getService().getComponent().getId().equals(supplier.getId())) {
					services += "\n" + conn.getService().getId();
				}
			}
			Label label = new Label(String.format("Services: %s", services));
			
			List<Connection> connections = new ArrayList<Connection>();
			for (Connection conn : client.getConnections()) {
				if (conn.getService().getComponent().getId().equals(supplier.getId())) {
					connections.add(conn);
				}
			}
			connectionMap.put(label, connections);
			return label;
		}
		return new Label(entity.toString());
	}

	@Override
	public int getConnectionStyle(Object rel) {
		return ZestStyles.CONNECTIONS_DASH;
	}

	@Override
	public Color getColor(Object rel) {
		return BLACK_COLOR;
	}

	@Override
	public Color getHighlightColor(Object rel) {
		return null;
	}

	@Override
	public int getLineWidth(Object rel) {
		return 1;
	}

	@Override
	public Color getNodeHighlightColor(Object entity) {
		return GREEN_COLOR;

	}

	@Override
	public Color getBorderColor(Object entity) {
		return null;
	}

	@Override
	public Color getBorderHighlightColor(Object entity) {
		return null;
	}

	@Override
	public int getBorderWidth(Object entity) {
		return 1;
	}

	@Override
	public Color getBackgroundColour(Object entity) {
		return null;
	}

	@Override
	public Color getForegroundColour(Object entity) {

		if (entity instanceof Component)  {
			return WHITE_COLOR;
		}
		return null;
	}

	@Override
	public boolean fisheyeNode(Object entity) {
		return false;
	}

	@Override
	public IFigure getFigure(Object entity) {
		if (entity instanceof Component)  {
			Component comp = (Component) entity;
			String id = ":" + BundleGraphUtils.getSimplifiedId(comp);
			org.eclipse.swt.graphics.Point p = gc.textExtent(id);
			
			int boxWidth = Math.max(p.x + 20, 80);
			RectangleFigure box = new RectangleFigure();
			box.setSize(boxWidth, p.y + 40);
			box.setBackgroundColor(LIGHTGRAY_COLOR);
			
			Label text = new Label(id);
			text.setSize(boxWidth-5, p.y);
			text.setLocation(new Point(5, 20));
			text.setFont(font);
			box.add(text);
			
			Label icon = new Label(comp.getServices().isEmpty() ? componentImgNoServ : componentImgServ);
			icon.setLocation(new Point(boxWidth - 20, 2));
			icon.setSize(16,16);
			box.add(icon);
			box.setToolTip(getTooltip(comp));
			componentMap.put(box, comp);
			return box;
		}		
		return null;
	}

	public Component getComponent(IFigure fig) {
		return componentMap.get(fig);
	}
	
	public List<Connection> getConnections(IFigure tooltip) {
		return connectionMap.get(tooltip);
	}

//	@Override
//	public int getConnectionStyle(Object src, Object dest) {
//		return ZestStyles.CONNECTIONS_DASH_DOT;
//	}
//
//	@Override
//	public Color getColor(Object src, Object dest) {
//		return BLACK_COLOR;
//	}
//
//	@Override
//	public Color getHighlightColor(Object src, Object dest) {
//
//		return GREEN_COLOR;
//	}
//
//	@Override
//	public int getLineWidth(Object src, Object dest) {
//		return 2;
//	}

}
