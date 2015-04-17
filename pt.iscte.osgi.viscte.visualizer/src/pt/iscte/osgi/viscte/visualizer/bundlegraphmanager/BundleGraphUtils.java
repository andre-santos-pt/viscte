package pt.iscte.osgi.viscte.visualizer.bundlegraphmanager;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.State;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceReference;

import pt.iscte.osgi.viscte.model.BundleGraph;
import pt.iscte.osgi.viscte.model.Component;
import pt.iscte.osgi.viscte.model.Connection;
import pt.iscte.osgi.viscte.model.Lifecycle;
import pt.iscte.osgi.viscte.model.ModelFactory;
import pt.iscte.osgi.viscte.model.Service;

public class BundleGraphUtils {

	private static final String OBJECT_CLASS_KEY = "objectClass";
	
	private static final String TOGGLE_COMMAND_ID = "org.eclipselabs.osgi.viscte.visualizer.commands.capture";
	private static final String TOGGLE_COMMAND_STATE_ID = "org.eclipselabs.osgi.viscte.visualizer.commands.state";
			
	private BundleGraphUtils() {
		
	}
	
	public static final boolean isBackCommandEnabled() {
		
		/** Returns if the back command must be enabled or not */

		return !isCaptureEnabled() && hasPreviousTimestamp(BundleGraphManager.getInstance().getCurrentTimestamp()); 	
	}
	
	public static final boolean isForwardCommandEnabled() {
		
		/** Returns if the forward command must be enabled or not */
		
		return !isCaptureEnabled() && hasNextTimestamp(BundleGraphManager.getInstance().getCurrentTimestamp()); 	
	}
	
	public static final State getToggleCommandState() {
		
		/** Gets toggle command state */
				
		final ICommandService service = (ICommandService) PlatformUI.getWorkbench().getService(ICommandService.class);
		final Command command = service.getCommand(TOGGLE_COMMAND_ID);
		return command.getState(TOGGLE_COMMAND_STATE_ID);
	}
	
	public static final boolean isCaptureEnabled() {
		
		/** Returns if capture mode is enabled or not */
				
		return (Boolean) getToggleCommandState().getValue();
	}
	
	public static final void restartBundleGraph(BundleGraph graph) {

		/** Restarts the bundle graph */
		
		graph.getComponents().clear();
		startObjectLifecycle(graph);
	}
	
	public static final String getFormattedStartDatetime(Component component) {
		
		/** Gets the last time stamp formatted start date time */
		
		final Lifecycle lifecycle = component.getLifecycles().get(component.getLifecycles().size() - 1);
		if (lifecycle.getStart() == 0) {
			return "-";
		} else {
			return DateFormat.getDateTimeInstance().format(lifecycle.getStart());
		}
	}
	
	public static final String getFormattedStartDatetime(Connection connection) {
		
		/** Gets the last time stamp formatted start date time */
		
		final Lifecycle lifecycle = connection.getLifecycles().get(connection.getLifecycles().size() - 1);
		if (lifecycle.getStart() == 0) {
			return "-";
		} else {
			return DateFormat.getDateTimeInstance().format(lifecycle.getStart());
		}
	}
	
	public static final String getFormattedEndDatetime(Component component) {
		
		/** Gets the last time stamp formatted end date time */
		
		final Lifecycle lifecycle = component.getLifecycles().get(component.getLifecycles().size() - 1);
		if (lifecycle.getEnd() == 0) {
			return "-";
		} else {
			return DateFormat.getDateTimeInstance().format(lifecycle.getEnd());
		}
	}
		
	public static final String getFormattedEndDatetime(Connection connection) {
		
		/** Gets the last time stamp formatted end date time */
		
		final Lifecycle lifecycle = connection.getLifecycles().get(connection.getLifecycles().size() - 1);
		if (lifecycle.getEnd() == 0) {
			return "-";
		} else {
			return DateFormat.getDateTimeInstance().format(lifecycle.getEnd());
		}
	}
	
	public static final void startObjectLifecycle(BundleGraph bundleGraph) {
		
		/** Starts a life cycle for a specified graph */
		
		final Lifecycle lifecycle = ModelFactory.eINSTANCE.createLifecycle();
		lifecycle.setStart(System.currentTimeMillis());
		bundleGraph.setLifecycle(lifecycle);
	}
	
	public static final void startObjectLifecycle(Component component) {
		
		/** Starts a life cycle for a specified component */
		
		final Long timestamp = System.currentTimeMillis();
		final Lifecycle lifecycle = ModelFactory.eINSTANCE.createLifecycle();
		lifecycle.setStart(timestamp);
		component.getLifecycles().add(lifecycle);
		
		BundleGraphManager.getInstance().setCurrentTimestamp(timestamp);
	}
	
	public static final void startObjectLifecycle(Service service) {
		
		/** Starts a life cycle for a specified service */
		
		final Lifecycle lifecycle = ModelFactory.eINSTANCE.createLifecycle();
		lifecycle.setStart(System.currentTimeMillis());
		service.getLifecycles().add(lifecycle);
	}
	
	public static final void startObjectLifecycle(Connection connection) {
		
		/** Starts a life cycle for a specified connection */
		
		final Long timestamp = System.currentTimeMillis();
		final Lifecycle lifecycle = ModelFactory.eINSTANCE.createLifecycle();
		lifecycle.setStart(timestamp);
		connection.getLifecycles().add(lifecycle);
		
		BundleGraphManager.getInstance().setCurrentTimestamp(timestamp);
	}
	
	public static final void endObjectLifecycle(BundleGraph bundleGraph) {
		
		/** End a life cycle for a specified bundleGraph */
		
		if (bundleGraph.getLifecycle().getEnd() == 0) {
			bundleGraph.getLifecycle().setEnd(System.currentTimeMillis());
		}
	}

	public static final void endObjectLifecycle(Component component) {
	
		/** End a life cycle for a specified component */
		
		final Long timestamp = System.currentTimeMillis();
		final Lifecycle lifecycle = component.getLifecycles().get(component.getLifecycles().size() - 1);
		if (lifecycle.getEnd() == 0) {
			lifecycle.setEnd(timestamp);
			BundleGraphManager.getInstance().setCurrentTimestamp(timestamp);
		}
	}

	public static final void endObjectLifecycle(Service service) {
	
		/** End a life cycle for a specified service */
		
		Lifecycle lifecycle = service.getLifecycles().get(service.getLifecycles().size() - 1);
		if (lifecycle.getEnd() == 0) {
			lifecycle.setEnd(System.currentTimeMillis());
		}
	}

	public static final void endObjectLifecycle(Connection connection) {
		
		/** End a life cycle for a specified connection */
		
		final Long timestamp = System.currentTimeMillis();
		Lifecycle lifecycle = connection.getLifecycles().get(connection.getLifecycles().size() - 1);
		if (lifecycle.getEnd() == 0) {
			lifecycle.setEnd(timestamp);
			BundleGraphManager.getInstance().setCurrentTimestamp(timestamp);
		}
	}
	
	public static final String getServiceId(ServiceReference serviceReference) {
		
		/** Gets a formatted service reference id */
		
		return ((String[]) serviceReference.getProperty(OBJECT_CLASS_KEY))[0];
	}
		
	public static final Component getComponent(String id) {
		
		/** Searches in the BundleGraph for a specified component */
		
		for (Component c : BundleGraphManager.getInstance().getBundleGraph().getComponents()) {
			if (c.getId().equals(id)) {
				return c;
			}
		}
		return null;
	}
	
	public static final Service getService(Component supplier, String serviceId) {
		
		/** Searches in a component for a specified service */
		
		if (supplier != null) {
			for (Service s : supplier.getServices()) {
				if (s.getId().equals(serviceId)) {
					return s;
				}
			}
		}
		return null;
	}
	
	public static final Connection getConnection(Component client, String serviceId) {
		
		/** Searches in a component for a connection to a specified service */
		
		if (client != null) {
			for (Connection c : client.getConnections()) {
				if (c.getService().getId().equals(serviceId)) {
					return c;
				}
			}
		}
		return null;
	}
	
	public static final Set<Connection> getConnections(String serviceId) {
		
		/** Searches in bundle graph for connections to a specified service */
		
		Set<Connection> connections = new HashSet<Connection>();
		for (Component c : BundleGraphManager.getInstance().getBundleGraph().getComponents()) {
			for (Connection conn : c.getConnections()) {
				if (conn.getService().getId().equals(serviceId)) {
					connections.add(conn);
				}
			}
		}
		return connections;
	}
		
	public static final void addConnections(ServiceReference serviceReference) {
		
		/** Add connections to a specified service */
		
		if (serviceReference != null) {
			if (serviceReference.getUsingBundles() != null) {
				for (Bundle b : serviceReference.getUsingBundles()) {
					Component component = getComponent(b.getSymbolicName());
					if (component != null) {
						addConnections(component, new ServiceReference[] {serviceReference});
					} else {
						/** Question: Add only component and connection or all its services and connections ? */
						component = ModelFactory.eINSTANCE.createComponent();
						component.setId(b.getSymbolicName());
						startObjectLifecycle(component);
						BundleGraphManager.getInstance().getBundleGraph().getComponents().add(component);
						addConnections(component, new ServiceReference[] {serviceReference});
						/*
						addServices(component, b.getRegisteredServices());
						addConnections(component, b.getServicesInUse());
						*/
					}
				}
			}
		}
	}
	
	public static final void addConnections(Component client, ServiceReference[] serviceReferences) {
		
		/** Add component connections to specified services */
		
		if (serviceReferences != null) {
			for (ServiceReference sref : serviceReferences) {
				Connection connection = getConnection(client, getServiceId(sref));
				if (connection != null) {
					if (connection.getLifecycles().size() > 0) {
						final Lifecycle lifecycle = connection.getLifecycles().get(connection.getLifecycles().size() - 1);
						if (lifecycle.getEnd() != 0) {
							startObjectLifecycle(connection);
						}
					} else {
						startObjectLifecycle(connection);
					}
				} else {
					Component supplier = getComponent(sref.getBundle().getSymbolicName());
					if (supplier != null) {
						Service service = getService(supplier, getServiceId(sref));
						if (service != null) {
							connection = ModelFactory.eINSTANCE.createConnection();
							connection.setService(service);
							connection.setComponent(client);
							startObjectLifecycle(connection);
							client.getConnections().add(connection);
						}
					}
				}
			}
		}
	}
	
	public static final String getSimplifiedId(Component component) {
		
		/** Gets the simplified id from a specified component */
		
		return component.getId().substring(component.getId().lastIndexOf('.') + 1);
	}
	
	public static final String getSimplifiedId(Service service) {
		
		/** Gets the simplified id from a specified service */
		
		return service.getId().substring(service.getId().lastIndexOf('.') + 1);
	}
	
	public static final List<Component> getActiveComponents(final Long timestamp) {
		
		/** Gets the components */
		
		final List<Component> activeComponents = new ArrayList<>();
		final BundleGraph graph = BundleGraphManager.getInstance().getBundleGraph();
		for (Component component : graph.getComponents()) {
			final List<Lifecycle> lifecycles = component.getLifecycles();
			ListIterator<Lifecycle> listIter = lifecycles.listIterator(lifecycles.size());
			while (listIter.hasPrevious()) {
			    final Lifecycle lifecycle = listIter.previous();
			    if (lifecycle.getEnd() != 0 && 
			    		lifecycle.getEnd() <= timestamp) {
			    	break;
			    } else if (lifecycle.getStart() != 0 &&
			    		lifecycle.getStart() <= timestamp) {
			    	activeComponents.add(component);
			    }
			}
		}
		return activeComponents; 
	}
	

	public static final List<Component> getConnectedTo(final Component client, final Long timestamp) {
		
		/** Gets the components connected to given component */
		
		final List<Component> suppliers = new ArrayList<>();
		final List<Component> activeComponents = getActiveComponents(timestamp);
		for (Connection connection : client.getConnections()) {
			final Component supplier = connection.getService().getComponent();
			if (activeComponents.contains(supplier)) {
				final List<Lifecycle> lifecycles = connection.getLifecycles();
				final ListIterator<Lifecycle> listIter = lifecycles.listIterator(lifecycles.size());
				while (listIter.hasPrevious()) {
				    Lifecycle lifecycle = listIter.previous();
				    if (lifecycle.getEnd() != 0 && 
				    		lifecycle.getEnd() <= timestamp) {
				    	break;
				    } else if (lifecycle.getStart() != 0 &&
				    		lifecycle.getStart() <= timestamp) {
				    	suppliers.add(supplier);
				    }
				}
			}
		}
		return suppliers;
	}
		
	public static final boolean hasPreviousTimestamp(final Long timestamp) {
		return getPreviousTimestamp(timestamp) != Long.MIN_VALUE; 
	}
	
	public static final Long getPreviousComponentTimestamp(final Long timestamp) {
		
		/** Gets the previous component time stamp */
		
		Long previousTimestamp = Long.MIN_VALUE;
		final BundleGraph graph = BundleGraphManager.getInstance().getBundleGraph();
		for (Component component : graph.getComponents()) {
			final List<Lifecycle> lifecycles = component.getLifecycles();
			ListIterator<Lifecycle> listIter = lifecycles.listIterator(lifecycles.size());
			while (listIter.hasPrevious()) {
			    Lifecycle lifecycle = listIter.previous();
			    if (lifecycle.getEnd() != 0 && 
			    		lifecycle.getEnd() < timestamp &&
			    		lifecycle.getEnd() > previousTimestamp) {
			    	previousTimestamp = lifecycle.getEnd();
			    	break;
			    } else if (lifecycle.getStart() != 0 &&
			    		lifecycle.getStart() < timestamp &&
			    		lifecycle.getStart() > previousTimestamp) {
			    	previousTimestamp = lifecycle.getStart();
			    	break;
			    }
			}
		}
		return previousTimestamp;
	}
	
	public static final Long getPreviousConnectionTimestamp(final Long timestamp) {
		
		/** Gets the previous component time stamp */
		
		Long previousTimestamp = Long.MIN_VALUE;
		final BundleGraph graph = BundleGraphManager.getInstance().getBundleGraph();
		for (Component component : graph.getComponents()) {
			for (Connection connection : component.getConnections()) {
				final List<Lifecycle> lifecycles = connection.getLifecycles();
				ListIterator<Lifecycle> listIter = lifecycles.listIterator(lifecycles.size());
				while (listIter.hasPrevious()) {
				    Lifecycle lifecycle = listIter.previous();
				    if (lifecycle.getEnd() != 0 && 
				    		lifecycle.getEnd() < timestamp &&
				    		lifecycle.getEnd() > previousTimestamp) {
				    	previousTimestamp = lifecycle.getEnd();
				    	break;
				    } else if (lifecycle.getStart() != 0 &&
				    		lifecycle.getStart() < timestamp &&
				    		lifecycle.getStart() > previousTimestamp) {
				    	previousTimestamp = lifecycle.getStart();
				    	break;
				    }
				}
			}
		}
		return previousTimestamp;
	}
		
	public static final Long getPreviousTimestamp(final Long timestamp) {
		
		/** Gets the previous time stamp value */
		
		Long previousTimestamp = Long.MIN_VALUE;
		final Long previousComponentTimestamp = getPreviousComponentTimestamp(timestamp);
		final Long previousConnectionTimestamp = getPreviousConnectionTimestamp(timestamp);
		if (previousComponentTimestamp > previousConnectionTimestamp)  {
			previousTimestamp = previousComponentTimestamp;
		} else {
			previousTimestamp = previousConnectionTimestamp;
		}
		return previousTimestamp;
	}
		
	public static final boolean hasNextTimestamp(final Long timestamp) {
		return getNextTimestamp(timestamp) != Long.MAX_VALUE; 
	}
	
	public static final Long getNextComponentTimestamp(final Long timestamp) {
		
		/** Gets the next component time stamp */
				
		Long nextTimestamp = Long.MAX_VALUE;
		final BundleGraph graph = BundleGraphManager.getInstance().getBundleGraph();
		for (Component component : graph.getComponents()) {
			final List<Lifecycle> lifecycles = component.getLifecycles();
			ListIterator<Lifecycle> listIter = lifecycles.listIterator();
			while (listIter.hasNext()) {
			    Lifecycle lifecycle = listIter.next();
			    if (lifecycle.getStart() != 0 &&
			    		lifecycle.getStart() > timestamp &&
			    		lifecycle.getStart() < nextTimestamp) {
			    	nextTimestamp = lifecycle.getStart();
			    	break;
			    } else if (lifecycle.getEnd() != 0 && 
			    		lifecycle.getEnd() > timestamp &&
			    		lifecycle.getEnd() < nextTimestamp) {
			    	nextTimestamp = lifecycle.getEnd();
			    	break;
			    }
			}
		}
		return nextTimestamp;
		
	}
	
	public static final Long getNextConnectionTimestamp(final Long timestamp) {
		
		/** Gets the next connection time stamp */
				
		Long nextTimestamp = Long.MAX_VALUE;
		final BundleGraph graph = BundleGraphManager.getInstance().getBundleGraph();
		for (Component component : graph.getComponents()) {
			for (Connection connection : component.getConnections()) {
				final List<Lifecycle> lifecycles = connection.getLifecycles();
				ListIterator<Lifecycle> listIter = lifecycles.listIterator();
				while (listIter.hasNext()) {
				    Lifecycle lifecycle = listIter.next();
				    if (lifecycle.getStart() != 0 &&
				    		lifecycle.getStart() > timestamp &&
				    		lifecycle.getStart() < nextTimestamp) {
				    	nextTimestamp = lifecycle.getStart();
				    	break;
				    } else if (lifecycle.getEnd() != 0 && 
				    		lifecycle.getEnd() > timestamp &&
				    		lifecycle.getEnd() < nextTimestamp) {
				    	nextTimestamp = lifecycle.getEnd();
				    	break;
				    }
				}
			}
		}
		return nextTimestamp;
	}
	
	public static final Long getNextTimestamp(final Long timestamp) {
		
		/** Gets the next time stamp value */
		
		Long nextTimestamp = Long.MAX_VALUE;
		final Long nextComponentTimestamp = getNextComponentTimestamp(timestamp);
		final Long nextConnectionTimestamp = getNextConnectionTimestamp(timestamp);
		if (nextComponentTimestamp < nextConnectionTimestamp)  {
			nextTimestamp = nextComponentTimestamp;
		} else {
			nextTimestamp = nextConnectionTimestamp;
		}
		return nextTimestamp;
	}
}
