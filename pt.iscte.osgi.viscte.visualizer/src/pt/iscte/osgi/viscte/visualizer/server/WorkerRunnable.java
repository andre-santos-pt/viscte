package pt.iscte.osgi.viscte.visualizer.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import pt.iscte.osgi.viscte.serializable.SerializableMessage;
import pt.iscte.osgi.viscte.visualizer.BundleView;
import pt.iscte.osgi.viscte.visualizer.bundlegraphmanager.BundleGraphManager;
import pt.iscte.osgi.viscte.visualizer.bundlegraphmanager.BundleGraphUtils;

public class WorkerRunnable implements Runnable{

	private final static String BUNDLE_STARTED = "BundleStarted";
	private final static String BUNDLE_STOPPED = "BundleStopped";
	private final static String SERVICE_REGISTERED = "ServiceRegistered";
	private final static String SERVICE_UNREGISTERED = "ServiceUnregistered";
	private final static String SERVICE_OBTAINED = "ServiceObtained";
	private final static String SERVICE_RELEASED = "ServiceReleased";
	protected Socket clientSocket = null;
	protected String serverText   = null;

	public WorkerRunnable(Socket clientSocket, String serverText) {
		this.clientSocket = clientSocket;
		this.serverText   = serverText;
	}

	public void run() {
		try {
			ObjectInputStream objectInputSteam = new ObjectInputStream(clientSocket.getInputStream());
			SerializableMessage serializableMessage = (SerializableMessage) objectInputSteam.readObject();
			if (BundleGraphUtils.isCaptureEnabled()) {
				treatMessageReceived(serializableMessage);
				BundleView.getInstance().refreshView();
			}
			objectInputSteam.close();
		} catch (IOException | ClassNotFoundException e) {
			//report exception somewhere.
			e.printStackTrace();
		}
	}

	private void treatMessageReceived(SerializableMessage serializableMessage) {
		System.out.println("Message Received has event type: " + serializableMessage.getEvent());
		synchronized (BundleGraphManager.getInstance()) {
			switch (serializableMessage.getEvent()) {
			case BUNDLE_STARTED:
				BundleGraphManager.getInstance().bundleStarted(serializableMessage.getBundle());
				break;
			case BUNDLE_STOPPED:
				BundleGraphManager.getInstance().bundleStopped(serializableMessage.getBundle());
				break;
			case SERVICE_REGISTERED:
				BundleGraphManager.getInstance().serviceRegistered(serializableMessage.getService());
				break;
			case SERVICE_UNREGISTERED:
				BundleGraphManager.getInstance().serviceUnregistered(serializableMessage.getService());
				break;
			case SERVICE_OBTAINED:
				BundleGraphManager.getInstance().serviceObtained(serializableMessage.getBundle(), serializableMessage.getService());
				break;
			case SERVICE_RELEASED:
				BundleGraphManager.getInstance().serviceReleased(serializableMessage.getBundle(), serializableMessage.getService());
				break;
			}
		}
	}
}
