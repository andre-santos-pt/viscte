package pt.iscte.osgi.viscte.serializable;

import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceReference;

public class SerializableMessage implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private final String event;
	private SerializableBundle bundle;
	private SerializableService service;
	
	public SerializableMessage(String event) {
		this.event = event;
	}
	
	public String getEvent() {
		return event;
	}
	
//	public void setEvent(String event) {
//		this.event = event;
//	}

	public SerializableBundle getBundle() {
		return bundle;
	}

	public void setBundle(SerializableBundle bundle) {
		this.bundle = bundle;
	}
	
	public void setBundle(Bundle bundle) {
		this.bundle = new SerializableBundle(bundle);
	}

	public SerializableService getService() {
		return service;
	}

	public void setService(SerializableService service) {
		this.service = service;
	}
	
	public void setService(ServiceReference service) {
		this.service = new SerializableService(service);
	}
	
	public void setService(ServiceReference service, Class<?> serviceClass, String message) {
		this.service = new SerializableService(service, serviceClass);
		this.service.setMessage(message);
	}
	
	
}
