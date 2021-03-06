/**
 *
 * $Id$
 */
package pt.iscte.osgi.viscte.model.validation;

import org.eclipse.emf.common.util.EList;

import pt.iscte.osgi.viscte.model.Connection;
import pt.iscte.osgi.viscte.model.Lifecycle;
import pt.iscte.osgi.viscte.model.Service;

/**
 * A sample validator interface for {@link pt.iscte.osgi.viscte.model.Component}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ComponentValidator {
	boolean validate();

	boolean validateServices(EList<Service> value);
	boolean validateConnections(EList<Connection> value);
	boolean validateId(String value);
	boolean validateLifecycles(EList<Lifecycle> value);
}
