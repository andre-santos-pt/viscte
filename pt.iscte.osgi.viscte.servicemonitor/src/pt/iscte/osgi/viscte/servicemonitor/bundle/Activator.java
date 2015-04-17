package pt.iscte.osgi.viscte.servicemonitor.bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	
	private ServiceRegistration registration;
	
	private static Activator instance;
	
	public static Activator getInstance() {
		return instance;
	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		instance = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		registration.unregister();
	}
}
