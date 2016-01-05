package pt.iscte.osgi.viscte.servicemonitor;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.net.Socket;
import java.util.Arrays;
import java.util.Map;
import java.util.WeakHashMap;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

import pt.iscte.osgi.viscte.serializable.SerializableMessage;

public aspect ServiceMonitor {

	private static int PORT = 6789;
	private static String LOCALHOST = "localhost";
	private static String SERVICE_OBTAINED = "ServiceObtained";
	private static String SERVICE_RELEASED = "ServiceReleased";
	private static String CONTEXT = "context";


	private Map<Object, ServiceReference> serviceRefMap;
	private Map<ServiceReference, Bundle> serviceClientMap;

	public ServiceMonitor() {
		System.out.println("Service Monitor ON");
		serviceRefMap = new WeakHashMap<Object, ServiceReference>();
		serviceClientMap = new WeakHashMap<ServiceReference, Bundle>();
	} 


	private Bundle getServiceTrackerClientBundle(ServiceTracker tracker) {
		try {
			Bundle clientBundle = null;
			Field field = tracker.getClass().getDeclaredField(CONTEXT);
			field.setAccessible(true);
			if (field.get(tracker) instanceof BundleContext) {
				clientBundle = ((BundleContext) field.get(tracker)).getBundle();
			}
			return clientBundle;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private void serviceObtained(Bundle bundle, ServiceReference service, Object serviceImpl, String message) {
		serviceRefMap.put(serviceImpl, service);
		serviceClientMap.put(service, bundle);

		SerializableMessage serializableMessage = new SerializableMessage(SERVICE_OBTAINED);
		//		serializableMessage.setEvent(SERVICE_OBTAINED);
		serializableMessage.setBundle(bundle);
		serializableMessage.setService(service, serviceImpl.getClass(), message);
		sendMessageViaSocketTCP(serializableMessage);
	}

	private void serviceReleased(Bundle bundle, ServiceReference service) {
		SerializableMessage serializableMessage = new SerializableMessage(SERVICE_RELEASED);
		//		serializableMessage.setEvent(SERVICE_RELEASED);
		serializableMessage.setBundle(bundle);
		serializableMessage.setService(service);
		sendMessageViaSocketTCP(serializableMessage);
	}

	private void sendMessageViaSocketTCP(SerializableMessage serializableMessage) {
		try {
			System.out.println("Service Monitor attempting to connect to " + LOCALHOST + " on port " + PORT);
			Socket client = new Socket(LOCALHOST, PORT);
			System.out.println("Service Monitor connected to " + client.getRemoteSocketAddress());
			ObjectOutputStream outToServer = new ObjectOutputStream(client.getOutputStream()); 
			outToServer.writeObject(serializableMessage);
			outToServer.close();
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	after(Object client, Object obj) : call(* *.*(..)) && this(client) && target(obj) && !within(ServiceMonitor) {
		if(serviceRefMap.containsKey(obj)) {
			ServiceReference ref = serviceRefMap.get(obj);
			Bundle bundle = serviceClientMap.get(ref);
			String message = Arrays.toString(thisJoinPoint.getArgs());
			serviceObtained(bundle, ref, obj, message);
		}
	}

	after(ServiceReference service, BundleContext context) returning(Object obj) : call(Object BundleContext.getService(ServiceReference)) && args(service) && target(context) {
		serviceObtained(context.getBundle(), service, obj, null);
	}

	after(ServiceReference service, BundleContext context) returning(boolean obj) : call(boolean BundleContext.ungetService(ServiceReference)) && args(service) && target(context) {	
		serviceReleased(context.getBundle(), service);
	}


	after(ServiceTracker tracker) returning(Object obj) : call(Object ServiceTracker.getService()) && target(tracker) { 
		serviceObtained(getServiceTrackerClientBundle(tracker), tracker.getServiceReference(), obj, null);
	}

	before(ServiceTracker tracker) : call(void ServiceTracker.close()) && target(tracker) {
		Bundle clientBundle = getServiceTrackerClientBundle(tracker);
		for (ServiceReference service : tracker.getServiceReferences()) {
			serviceReleased(clientBundle, service);
		}
	}

	after(ServiceReference service, ServiceTracker tracker) returning(Object obj) : call(Object ServiceTracker.getService(ServiceReference)) && args(service) && target(tracker) {
		serviceObtained(getServiceTrackerClientBundle(tracker), service, obj, null);
	}

	after(ServiceReference service, ServiceTracker tracker) : call(void ServiceTracker.remove(ServiceReference)) && args(service) && target(tracker) {
		serviceReleased(getServiceTrackerClientBundle(tracker), service);
	}

	after(ServiceReference service, ServiceTracker tracker) returning(Object obj) : call(Object ServiceTracker.addingService(ServiceReference)) && args(service) && target(tracker) {
		serviceObtained(getServiceTrackerClientBundle(tracker), service, obj, null);
	}

	after(ServiceReference service, Object object, ServiceTracker tracker) : call(void ServiceTracker.removedService(ServiceReference, Object)) && args(service, object) && target(tracker) {
		serviceReleased(getServiceTrackerClientBundle(tracker), service);
	}

}
