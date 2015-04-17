/**
 *
 * $Id$
 */
package pt.iscte.osgi.viscte.model.validation;

import org.eclipse.emf.common.util.EList;

import pt.iscte.osgi.viscte.model.Component;
import pt.iscte.osgi.viscte.model.Lifecycle;

/**
 * A sample validator interface for {@link pt.iscte.osgi.viscte.model.Service}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ServiceValidator {
	boolean validate();

	boolean validateId(String value);
	boolean validateLifecycles(EList<Lifecycle> value);
	boolean validateComponent(Component value);
}