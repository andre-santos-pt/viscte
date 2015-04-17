package pt.iscte.osgi.viscte.bundlemonitor;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.BundleListener;

import pt.iscte.osgi.viscte.serializable.SerializableMessage;

public class BundleListenerImpl implements BundleListener {

	private static int PORT = 6789;
	private static String LOCALHOST = "localhost";
	private static String BUNDLE_STARTED = "BundleStarted";
	private static String BUNDLE_STOPPED = "BundleStopped";
	
	private void sendMessageViaSocketTCP(SerializableMessage serializableMessage) {
		try {
			System.out.println("Bundle Monitor attempting to connect to " + LOCALHOST + " on port " + PORT);
			 Socket client = new Socket(LOCALHOST, PORT);
			 System.out.println("Bundle Monitor connected to " + client.getRemoteSocketAddress());
			 ObjectOutputStream outToServer = new ObjectOutputStream(client.getOutputStream()); 
			 outToServer.writeObject(serializableMessage);
			 outToServer.close();
			 client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void bundleStarted(Bundle bundle) {
		SerializableMessage serializableMessage = new SerializableMessage(BUNDLE_STARTED);
//		serializableMessage.setEvent(BUNDLE_STARTED);
		serializableMessage.setBundle(bundle);
		sendMessageViaSocketTCP(serializableMessage);
	}
	
	private void bundleStopped(Bundle bundle) {
		SerializableMessage serializableMessage = new SerializableMessage(BUNDLE_STOPPED);
//		serializableMessage.setEvent(BUNDLE_STOPPED);
		serializableMessage.setBundle(bundle);
		sendMessageViaSocketTCP(serializableMessage);
	}
	@Override
	public void bundleChanged(BundleEvent event) {
		switch(event.getType()) {
			case BundleEvent.STARTED: 
				bundleStarted(event.getBundle());
				break;
			case BundleEvent.STOPPED:
				bundleStopped(event.getBundle());
				break;	
		}
	}
}
