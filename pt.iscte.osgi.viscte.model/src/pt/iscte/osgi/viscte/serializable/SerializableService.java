package pt.iscte.osgi.viscte.serializable;

import org.osgi.framework.ServiceReference;

public class SerializableService implements java.io.Serializable {
	
	private static final long serialVersionUID = 460470089163023834L;
	private final String serviceId;
	private final SerializableBundle bundle;
	
	private String implementationClassName;

	private String message;
	
//	public SerializableService() {
//	}
//	
//	public SerializableService(String serviceId) {
//		this.serviceId = serviceId;
//	}
//	
	
	public SerializableService(String bundleId, String serviceId) {
		this.serviceId = serviceId;
		this.bundle = new SerializableBundle(bundleId);
	}
	
	public SerializableService(ServiceReference service) {
		this(service, null);
	}
	
	public SerializableService(ServiceReference service, Class<?> implementationClass) {
		this.serviceId = ((String[]) service.getProperty("objectClass"))[0];
		this.bundle = new SerializableBundle(service.getBundle());
		if(implementationClass != null)
			this.implementationClassName = implementationClass.getName();
	}
	
	public SerializableBundle getBundle() {
		return bundle;
	}
	
//	public void setBundle(SerializableBundle bundle) {
//		this.bundle = bundle;
//	}
	
	public String getServiceId() {
		return serviceId;
	}
	
//	public void setServiceId(String serviceId) {
//		this.serviceId = serviceId;
//	}
	
	public boolean hasImplementationClassName() {
		return implementationClassName != null;
	}
	
	public String getImplementationClassName() {
		return implementationClassName;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
