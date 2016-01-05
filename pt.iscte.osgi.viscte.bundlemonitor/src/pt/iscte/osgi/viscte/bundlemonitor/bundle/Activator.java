package pt.iscte.osgi.viscte.bundlemonitor.bundle;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import pt.iscte.osgi.viscte.bundlemonitor.BundleListenerImpl;
import pt.iscte.osgi.viscte.bundlemonitor.ServiceListenerImpl;

public class Activator implements BundleActivator {

	private static Activator instance;
	
//	private ServiceRegistration registration;
	
	private BundleListenerImpl bundleListener;
	
	private ServiceListenerImpl serviceListener;
	
	public static Activator getInstance() {
		return instance;
	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("BUNDLE MONITOR");
		instance = this;
		bundleListener = new BundleListenerImpl();
		serviceListener = new ServiceListenerImpl();
		context.addBundleListener(bundleListener);
		context.addServiceListener(serviceListener);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
//		registration.unregister();
		context.removeBundleListener(bundleListener);
		context.removeServiceListener(serviceListener);
		bundleListener = null;
		serviceListener = null;
	}
}
