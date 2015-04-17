package pt.iscte.osgi.viscte.visualizer.bundlegraphmanager;

import pt.iscte.osgi.viscte.model.BundleGraph;
import pt.iscte.osgi.viscte.model.Component;
import pt.iscte.osgi.viscte.model.Connection;
import pt.iscte.osgi.viscte.model.Lifecycle;
import pt.iscte.osgi.viscte.model.ModelFactory;
import pt.iscte.osgi.viscte.model.Service;
import pt.iscte.osgi.viscte.serializable.SerializableBundle;
import pt.iscte.osgi.viscte.serializable.SerializableService;

public class BundleGraphManager {

	private static BundleGraphManager instance;
	
	private Long currentTimestamp;
	
	private BundleGraph bundleGraph;
	
	protected BundleGraphManager() {
		
	}
	
	public static BundleGraphManager getInstance() {
		if (instance == null) {
			instance = new BundleGraphManager();
		}
		return instance;
	}
	
	public Long getCurrentTimestamp() {
		return currentTimestamp;
	}

	public void setCurrentTimestamp(Long currentTimestamp) {
		this.currentTimestamp = currentTimestamp;
	}
	
	public BundleGraph getBundleGraph() {
		return bundleGraph;
	}
	
	public void start() {
		bundleGraph = ModelFactory.eINSTANCE.createBundleGraph();
	}
	
	public void stop() {
		bundleGraph = null;
	}
	
	/**
	 * @Method bundleStarted
	 * @param bundle 
	 * @description bundle was started in OSGi framework. 
	 * bundle should be added in the bundle graph (start life cycle) and all its services
	 * */
	/*
	public void bundleStarted(Bundle bundle) {		
		addComponent(bundle);
		addServices(bundle);
	}
	*/
	
	public void bundleStarted(SerializableBundle serializableBundle) {
		addComponent(serializableBundle);
		addServices(serializableBundle);
	}
	
	/**
	 * @Method bundleStopped
	 * @param bundle 
	 * @description bundle was stopped in OSGi framework. 
	 * bundle should be deleted in the bundle graph (end life cycle) and all its services
	 * */
	/*
	public void bundleStopped(Bundle bundle) {
		deleteComponent(bundle);
		deleteServices(bundle);
		deleteConnections(bundle);
	}*/
	
	public void bundleStopped(SerializableBundle serializableBundle) {
		deleteComponent(serializableBundle);
		deleteServices(serializableBundle);
		deleteConnections(serializableBundle);
	}
	
	/**
	 * @Method serviceRegistered
	 * @param serviceReference 
	 * @description service was registered in OSGi framework. 
	 * service and its respective bundle should be added in the bundle graph (end life cycle)
	 * */
	/*
	public void serviceRegistered(ServiceReference serviceReference) {
		final Component component = BundleGraphUtils.getComponent(serviceReference.getBundle().getSymbolicName());
		if (component != null) {
			addService(serviceReference);
		} else {
			addComponent(serviceReference.getBundle());
			addServices(serviceReference.getBundle());
		}
	}*/
	
	public void serviceRegistered(SerializableService serializableService) {
		final Component component = BundleGraphUtils.getComponent(serializableService.getBundle().getBundleId());
		if (component != null) {
			addService(serializableService);
		} else {
			addComponent(serializableService.getBundle());
			addServices(serializableService.getBundle());
		}
	}
	
	/**
	 * @Method serviceUnregistered
	 * @param serviceReference 
	 * @description service was unregistered from OSGi framework. 
	 * service and its respective bundle should be deleted in the bundle graph (end life cycle)
	 * */
	/*public void serviceUnregistered(ServiceReference serviceReference) {	
		deleteService(serviceReference);
		deleteConnections(serviceReference);
	}*/
	
	public void serviceUnregistered(SerializableService serializableService) {	
		deleteService(serializableService);
		deleteConnections(serializableService);
	}
	
	/**
	 * @Method serviceObtained
	 * @param client
	 * @param serializableService 
	 * @description service was obtained from OSGi framework. 
	 * service, client and supplier bundles should be added in the bundle graph (start life cycle)
	 * */
	/*
	public void serviceObtained(Bundle client, ServiceReference serviceReference) {
		final Component componentSupplier = BundleGraphUtils.getComponent(serviceReference.getBundle().getSymbolicName());
		if (componentSupplier == null) {
			addComponent(serviceReference.getBundle());
			addServices(serviceReference.getBundle());
		}
		final Component componentClient = BundleGraphUtils.getComponent(client.getSymbolicName());
		if (componentClient == null) {
			addComponent(client);
			addServices(client);
		}
		addConnection(client, serviceReference);
	}
	*/
	
	public void serviceObtained(SerializableBundle client, SerializableService serializableService) {
		final Component componentSupplier = BundleGraphUtils.getComponent(serializableService.getBundle().getBundleId());
		if (componentSupplier == null) {
			addComponent(serializableService.getBundle());
			addServices(serializableService.getBundle());
		}
		final Component componentClient = BundleGraphUtils.getComponent(client.getBundleId());
		if (componentClient == null) {
			addComponent(client);
			addServices(client);
		}
		addConnection(client, serializableService);
	}
	
	/**
	 * @Method serviceReleased
	 * @param client
	 * @param service 
	 * @description service was released from OSGi framework. 
	 * client and service connection should be deleted from the bundle graph (end life cycle)
	 * */
	/*
	public void serviceReleased(Bundle client, ServiceReference serviceReference) {
		deleteConnection(client, serviceReference);
	}
	*/
	
	public void serviceReleased(SerializableBundle client, SerializableService serializableService) {
		deleteConnection(client, serializableService);
	}
	
	/**
	 * @Method addComponent
	 * @param bundle
	 * @description Add component in bundle graph (start life cycle) 
	 * */
	/*
	public void addComponent(Bundle bundle) {
		Component component = BundleGraphUtils.getComponent(bundle.getSymbolicName());
		if (component != null) {
			if (component.getLifecycles().size() > 0) {
				final Lifecycle lifecycle = component.getLifecycles().get(component.getLifecycles().size() - 1);
				if (lifecycle.getEnd() != 0) {
					BundleGraphUtils.startObjectLifecycle(component);
				}
			} else {
				BundleGraphUtils.startObjectLifecycle(component);
			}
		} else {
			component = ModelFactory.eINSTANCE.createComponent();
			component.setId(bundle.getSymbolicName());
			BundleGraphUtils.startObjectLifecycle(component);
			bundleGraph.getComponents().add(component);
		}
	}*/
	
	public void addComponent(SerializableBundle serializableBundle) {
		Component component = BundleGraphUtils.getComponent(serializableBundle.getBundleId());
		if (component != null) {
			if (component.getLifecycles().size() > 0) {
				final Lifecycle lifecycle = component.getLifecycles().get(component.getLifecycles().size() - 1);
				if (lifecycle.getEnd() != 0) {
					BundleGraphUtils.startObjectLifecycle(component);
				}
			} else {
				BundleGraphUtils.startObjectLifecycle(component);
			}
		} else {
			component = ModelFactory.eINSTANCE.createComponent();
			component.setId(serializableBundle.getBundleId());
			BundleGraphUtils.startObjectLifecycle(component);
			bundleGraph.getComponents().add(component);
		}
	}
	
	/**
	 * @Method addComponent
	 * @param bundle
	 * @description Delete component in bundle graph (end life cycle) 
	 * */
	
	/*public void deleteComponent(Bundle bundle) {
		Component component = BundleGraphUtils.getComponent(bundle.getSymbolicName());
		if (component != null) {
			BundleGraphUtils.endObjectLifecycle(component);
		}
	}*/
	
	public void deleteComponent(SerializableBundle serializableBundle) {
		Component component = BundleGraphUtils.getComponent(serializableBundle.getBundleId());
		if (component != null) {
			BundleGraphUtils.endObjectLifecycle(component);
		}
	}
	
	/**
	 * @Method addServices
	 * @param serviceReference
	 * @description Add service in bundle graph (start life cycle)
	 * */
	/*
	public void addService(ServiceReference serviceReference) {
		Component supplier = BundleGraphUtils.getComponent(serviceReference.getBundle().getSymbolicName());
		if (supplier != null) {
			Service service = BundleGraphUtils.getService(supplier, BundleGraphUtils.getServiceId(serviceReference));
			if (service != null) {
				if (service.getLifecycles().size() > 0) {
					final Lifecycle lifecycle = service.getLifecycles().get(service.getLifecycles().size() - 1);
					if (lifecycle.getEnd() != 0) {
						BundleGraphUtils.startObjectLifecycle(service);
					}
				} else {
					BundleGraphUtils.startObjectLifecycle(service);
				}
			} else {
				service = ModelFactory.eINSTANCE.createService();
				service.setId(BundleGraphUtils.getServiceId(serviceReference));
				service.setComponent(supplier);
				BundleGraphUtils.startObjectLifecycle(service);
				supplier.getServices().add(service);
			}
		}
	}*/
	
	public void addService(SerializableService serializableService) {
		Component supplier = BundleGraphUtils.getComponent(serializableService.getBundle().getBundleId());
		if (supplier != null) {
			Service service = BundleGraphUtils.getService(supplier, serializableService.getServiceId());
			if (service != null) {
				if (service.getLifecycles().size() > 0) {
					final Lifecycle lifecycle = service.getLifecycles().get(service.getLifecycles().size() - 1);
					if (lifecycle.getEnd() != 0) {
						BundleGraphUtils.startObjectLifecycle(service);
					}
				} else {
					BundleGraphUtils.startObjectLifecycle(service);
				}
			} else {
				service = ModelFactory.eINSTANCE.createService();
				service.setId(serializableService.getServiceId());
				service.setComponent(supplier);
				BundleGraphUtils.startObjectLifecycle(service);
				supplier.getServices().add(service);
			}
		}
	}
	
	
	
	/**
	 * @Method addServices
	 * @param serviceReference
	 * @description Delete service in bundle graph (end life cycle)
	 * */
	/*
	public void deleteService(ServiceReference serviceReference) {
		final Component supplier = BundleGraphUtils.getComponent(serviceReference.getBundle().getSymbolicName());
		if (supplier != null) {
			final Service service = BundleGraphUtils.getService(supplier, BundleGraphUtils.getServiceId(serviceReference));
			if (service != null && service.getLifecycles().size() > 0) {
				final Lifecycle serviceLifecycle = service.getLifecycles().get(service.getLifecycles().size() - 1);
				if (serviceLifecycle.getEnd() == 0) {
					BundleGraphUtils.endObjectLifecycle(service);
				}
			}
		}
	}*/
	
	public void deleteService(SerializableService serializableService) {
		final Component supplier = BundleGraphUtils.getComponent(serializableService.getBundle().getBundleId());
		if (supplier != null) {
			final Service service = BundleGraphUtils.getService(supplier, serializableService.getServiceId());
			if (service != null && service.getLifecycles().size() > 0) {
				final Lifecycle serviceLifecycle = service.getLifecycles().get(service.getLifecycles().size() - 1);
				if (serviceLifecycle.getEnd() == 0) {
					BundleGraphUtils.endObjectLifecycle(service);
				}
			}
		}
	}
	
	/**
	 * @Method addServices
	 * @param bundle
	 * @description Add all registered bundle services in bundle graph (start life cycle)
	 * */
	/*
	public void addServices(Bundle bundle) {
		final Component component = BundleGraphUtils.getComponent(bundle.getSymbolicName());
		if (component != null) {
			if (bundle.getRegisteredServices() != null) {
				for (ServiceReference sref : bundle.getRegisteredServices()) { 
					addService(sref);
				}
			}
		}
	}*/
	
	public void addServices(SerializableBundle serializableBundle) {
		final Component component = BundleGraphUtils.getComponent(serializableBundle.getBundleId());
		if (component != null) {
			for (SerializableService s : serializableBundle.getServices()) { 
				addService(s);
			}
		}
	}
	
	
	
	/**
	 * @Method deleteServices
	 * @param bundle
	 * @description Delete all bundle services in bundle graph (end life cycle)
	 * */
	/*
	public void deleteServices(Bundle bundle) {
		Component component = BundleGraphUtils.getComponent(bundle.getSymbolicName());
		if (component != null) {
			if (bundle.getRegisteredServices() != null) {
				for (ServiceReference sref : bundle.getRegisteredServices()) { 
					deleteService(sref);
				}
			}
		}
	}*/
	
	public void deleteServices(SerializableBundle serializableBundle) {
		Component component = BundleGraphUtils.getComponent(serializableBundle.getBundleId());
		if (component != null) {
			for (SerializableService s : serializableBundle.getServices()) { 
				deleteService(s);
			}
		}
	}

	/**
	 * @Method addConnection
	 * @param client
	 * @param serviceReference
	 * @description Add a connection between a supplier and client bundle in bundle graph (start life cycle) 
	 * */
	/*
	public void addConnection(Bundle client, ServiceReference serviceReference) {
		final Component componentClient = BundleGraphUtils.getComponent(client.getSymbolicName());
		if (componentClient != null) {
			Connection connection = BundleGraphUtils.getConnection(componentClient, BundleGraphUtils.getServiceId(serviceReference));
			if (connection != null) {
				if (connection.getLifecycles().size() > 0) {
					final Lifecycle lifecycle = connection.getLifecycles().get(connection.getLifecycles().size() - 1);
					if (lifecycle.getEnd() != 0) {
						BundleGraphUtils.startObjectLifecycle(connection);
					}
				} else {
					BundleGraphUtils.startObjectLifecycle(connection);
				}
			} else {
				Component componentSupplier = BundleGraphUtils.getComponent(serviceReference.getBundle().getSymbolicName());
				if (componentSupplier != null) {
					Service service = BundleGraphUtils.getService(componentSupplier, BundleGraphUtils.getServiceId(serviceReference));
					if (service != null) {
						connection = ModelFactory.eINSTANCE.createConnection();
						connection.setService(service);
						connection.setComponent(componentClient);
						BundleGraphUtils.startObjectLifecycle(connection);
						componentClient.getConnections().add(connection);
					}
				}
			}
		}	
	}*/
	
	public void addConnection(SerializableBundle client, SerializableService serializableService) {
		final Component componentClient = BundleGraphUtils.getComponent(client.getBundleId());
		if (componentClient != null) {
			Connection connection = BundleGraphUtils.getConnection(componentClient, serializableService.getServiceId());
			if (connection != null) {
				if (connection.getLifecycles().size() > 0) {
					final Lifecycle lifecycle = connection.getLifecycles().get(connection.getLifecycles().size() - 1);
					if (lifecycle.getEnd() != 0) {
						BundleGraphUtils.startObjectLifecycle(connection);
					}
				} else {
					BundleGraphUtils.startObjectLifecycle(connection);
				}
			} else {
				Component componentSupplier = BundleGraphUtils.getComponent(serializableService.getBundle().getBundleId());
				if (componentSupplier != null) {
					Service service = BundleGraphUtils.getService(componentSupplier, serializableService.getServiceId());
					if (service != null) {
						connection = ModelFactory.eINSTANCE.createConnection();
						connection.setService(service);
						connection.setComponent(componentClient);
						connection.setServiceClass(serializableService.getImplementationClassName()); // TODO !!
						BundleGraphUtils.startObjectLifecycle(connection);
						componentClient.getConnections().add(connection);
					}
				}
			}
		}	
	}
	
	/**
	 * @Method addConnection
	 * @param client
	 * @param serviceReference
	 * @description Delete a connection between a supplier and client bundle in bundle graph (end life cycle) 
	 * */
	/*
	public void deleteConnection(Bundle client, ServiceReference serviceReference) {
		final Component componentClient = BundleGraphUtils.getComponent(client.getSymbolicName());
		if (componentClient != null) {
			Connection connection = BundleGraphUtils.getConnection(componentClient, BundleGraphUtils.getServiceId(serviceReference));
			if (connection != null) {
				if (connection.getLifecycles().size() > 0) {
					final Lifecycle lifecycle = connection.getLifecycles().get(connection.getLifecycles().size() - 1);
					if (lifecycle.getEnd() == 0) {
						BundleGraphUtils.endObjectLifecycle(connection);
					}
				} 
			}
		}
	}*/
	
	public void deleteConnection(SerializableBundle client, SerializableService serializableService) {
		final Component componentClient = BundleGraphUtils.getComponent(client.getBundleId());
		if (componentClient != null) {
			Connection connection = BundleGraphUtils.getConnection(componentClient, serializableService.getServiceId());
			if (connection != null) {
				if (connection.getLifecycles().size() > 0) {
					final Lifecycle lifecycle = connection.getLifecycles().get(connection.getLifecycles().size() - 1);
					if (lifecycle.getEnd() == 0) {
						BundleGraphUtils.endObjectLifecycle(connection);
					}
				} 
			}
		}
	}
	
	/**
	 * @Method deleteConnections
	 * @param bundle
	 * @description Delete bundle connections in bundle graph (end life cycle)
	 * */
	/*
	public void deleteConnections(Bundle bundle) {
		final Component component = BundleGraphUtils.getComponent(bundle.getSymbolicName());
		if (component != null) {
			for (Connection conn : component.getConnections()) {
				if (conn.getLifecycles().size() > 0) {
					final Lifecycle lifecycle = conn.getLifecycles().get(conn.getLifecycles().size() - 1);
					if (lifecycle.getEnd() == 0) {
						BundleGraphUtils.endObjectLifecycle(conn);
					}
				} 
			}
		}
	}
	*/
	
	public void deleteConnections(SerializableBundle serializableBundle) {
		final Component component = BundleGraphUtils.getComponent(serializableBundle.getBundleId());
		if (component != null) {
			for (Connection conn : component.getConnections()) {
				if (conn.getLifecycles().size() > 0) {
					final Lifecycle lifecycle = conn.getLifecycles().get(conn.getLifecycles().size() - 1);
					if (lifecycle.getEnd() == 0) {
						BundleGraphUtils.endObjectLifecycle(conn);
					}
				} 
			}
		}
	}
	
	/**
	 * @Method deleteConnections
	 * @param serviceReference
	 * @description Delete service connections in bundle graph (end life cycle)
	 * */
	/*
	public void deleteConnections(ServiceReference serviceReference) {
		final Component supplier = BundleGraphUtils.getComponent(serviceReference.getBundle().getSymbolicName());
		final Service service = BundleGraphUtils.getService(supplier, BundleGraphUtils.getServiceId(serviceReference));
		if (service != null) {
			for (Connection conn : BundleGraphUtils.getConnections(BundleGraphUtils.getServiceId(serviceReference))) {
				if (conn.getLifecycles().size() > 0) {
					final Lifecycle lifecycle = conn.getLifecycles().get(conn.getLifecycles().size() - 1);
					if (lifecycle.getEnd() == 0) {
						BundleGraphUtils.endObjectLifecycle(conn);
					}
				} 
			}
		}
	}
	*/
	
	public void deleteConnections(SerializableService serializableService) {
		final Component supplier = BundleGraphUtils.getComponent(serializableService.getBundle().getBundleId());
		final Service service = BundleGraphUtils.getService(supplier, serializableService.getServiceId());
		if (service != null) {
			for (Connection conn : BundleGraphUtils.getConnections(serializableService.getServiceId())) {
				if (conn.getLifecycles().size() > 0) {
					final Lifecycle lifecycle = conn.getLifecycles().get(conn.getLifecycles().size() - 1);
					if (lifecycle.getEnd() == 0) {
						BundleGraphUtils.endObjectLifecycle(conn);
					}
				} 
			}
		}
	}
	
}
