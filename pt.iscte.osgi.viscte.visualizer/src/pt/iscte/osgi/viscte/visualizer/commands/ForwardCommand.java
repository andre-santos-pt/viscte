package pt.iscte.osgi.viscte.visualizer.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import pt.iscte.osgi.viscte.visualizer.BundleView;
import pt.iscte.osgi.viscte.visualizer.bundlegraphmanager.BundleGraphManager;
import pt.iscte.osgi.viscte.visualizer.bundlegraphmanager.BundleGraphUtils;

public class ForwardCommand extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		final Long currentTimestamp = BundleGraphManager.getInstance().getCurrentTimestamp();
		final Long nextTimestamp = BundleGraphUtils.getNextTimestamp(currentTimestamp);
		BundleGraphManager.getInstance().setCurrentTimestamp(nextTimestamp);
		
		BundleView.getInstance().refreshView();	
		
		return null;
	}
}
