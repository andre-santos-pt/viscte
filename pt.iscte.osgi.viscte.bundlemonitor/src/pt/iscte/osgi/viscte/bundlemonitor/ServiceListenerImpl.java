package pt.iscte.osgi.viscte.bundlemonitor;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

import pt.iscte.osgi.viscte.serializable.SerializableMessage;

public class ServiceListenerImpl implements ServiceListener {
	
	private static int PORT = 6789;
	private static String LOCALHOST = "localhost";
	private static String SERVICE_REGISTERED = "ServiceRegistered";
	private static String SERVICE_UNREGISTERED = "ServiceUnregistered";

	private void sendMessageViaSocketTCP(SerializableMessage serializableMessage) {
		try {
			System.out.println("Bundle Monitor attempting to connect to " + LOCALHOST + " on port " + PORT);
			 Socket client = new Socket(LOCALHOST, PORT);
			 System.out.println("Bundle Monitor connected to " + client.getRemoteSocketAddress());
			 ObjectOutputStream outToServer = new ObjectOutputStream(client.getOutputStream());
			 outToServer.writeObject(serializableMessage);
			 client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void serviceRegistered(ServiceReference service) {
		SerializableMessage serializableMessage = new SerializableMessage(SERVICE_REGISTERED);
//		serializableMessage.setEvent(SERVICE_REGISTERED);
		serializableMessage.setService(service);
		sendMessageViaSocketTCP(serializableMessage);
	}
	
	private void serviceUnregistered(ServiceReference service) {
		SerializableMessage serializableMessage = new SerializableMessage(SERVICE_UNREGISTERED);
//		serializableMessage.setEvent(SERVICE_UNREGISTERED);
		serializableMessage.setService(service);
		sendMessageViaSocketTCP(serializableMessage);
	}
	
	@Override
	public void serviceChanged(ServiceEvent event) {
		switch (event.getType()) {
			case ServiceEvent.REGISTERED:
				serviceRegistered(event.getServiceReference());
				break;
			case ServiceEvent.UNREGISTERING:
				serviceUnregistered(event.getServiceReference());
				break;
		}
	}

}
