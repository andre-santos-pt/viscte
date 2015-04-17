package pt.iscte.osgi.viscte.visualizer.bundle;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import pt.iscte.osgi.viscte.visualizer.bundlegraphmanager.BundleGraphManager;
import pt.iscte.osgi.viscte.visualizer.server.ThreadPooledServer;

public class Activator implements BundleActivator {

	public static final String PLUGIN_ID = "org.eclipselabs.osgi.viscte.visualizer";
	private static Activator instance;
	
	public static Activator getInstance() {
		return instance;
	}
	
	public void start(BundleContext context) throws Exception {
		instance = this;
		BundleGraphManager.getInstance().start();
		(new Thread(new ThreadPooledServer())).start();
	}
	
	public void stop(BundleContext context) throws Exception {
		BundleGraphManager.getInstance().stop();
	}
}
