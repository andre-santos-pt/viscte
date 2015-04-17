package pt.iscte.osgi.viscte.serializable;

import java.util.HashSet;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceReference;

public class SerializableBundle implements java.io.Serializable {

	private static final long serialVersionUID = -2458149450181811842L;
	private String bundleId;
	private Set<SerializableService> services;

//	public SerializableBundle() {
//	}

	public SerializableBundle(String bundleId) {
		this.bundleId = bundleId;
		services = new HashSet<SerializableService>();
	}

	public SerializableBundle(Bundle bundle) {
		this(bundle.getSymbolicName());
		
		ServiceReference[] services = bundle.getRegisteredServices();
		if(services != null)
			for (ServiceReference s : services) {
				this.services.add(new SerializableService(bundle.getSymbolicName(), ((String[]) s.getProperty("objectClass"))[0]));
			}	
	}

	public String getBundleId() {
		return bundleId;
	}

	public void setBundleId(String bundleId) {
		this.bundleId = bundleId;
	}

	public Set<SerializableService> getServices() {
		return services;
	}

//	public void setServices(Set<SerializableService> services) {
//		this.services = services;
//	}
}
