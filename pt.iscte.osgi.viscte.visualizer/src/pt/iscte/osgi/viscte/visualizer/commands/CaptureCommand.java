package pt.iscte.osgi.viscte.visualizer.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import pt.iscte.osgi.viscte.visualizer.BundleView;
import pt.iscte.osgi.viscte.visualizer.bundlegraphmanager.BundleGraphManager;
import pt.iscte.osgi.viscte.visualizer.bundlegraphmanager.BundleGraphUtils;

public class CaptureCommand extends AbstractHandler {
			
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {		
		
		BundleGraphUtils.getToggleCommandState().setValue(!(Boolean) BundleGraphUtils.getToggleCommandState().getValue());
		
		if (BundleGraphUtils.isCaptureEnabled()) {
			BundleGraphUtils.startObjectLifecycle(BundleGraphManager.getInstance().getBundleGraph());
			BundleGraphManager.getInstance().getBundleGraph().getComponents().clear();
			BundleView.getInstance().refreshView();
		} else {
			BundleGraphUtils.endObjectLifecycle(BundleGraphManager.getInstance().getBundleGraph());
		}
		
		return null;
	}
	

	
	
}
