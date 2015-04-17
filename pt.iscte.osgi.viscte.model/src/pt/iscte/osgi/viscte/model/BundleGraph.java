/**
 */
package pt.iscte.osgi.viscte.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bundle Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pt.iscte.osgi.viscte.model.BundleGraph#getComponents <em>Components</em>}</li>
 *   <li>{@link pt.iscte.osgi.viscte.model.BundleGraph#getLifecycle <em>Lifecycle</em>}</li>
 * </ul>
 * </p>
 *
 * @see pt.iscte.osgi.viscte.model.ModelPackage#getBundleGraph()
 * @model
 * @generated
 */
public interface BundleGraph extends EObject {
	/**
	 * Returns the value of the '<em><b>Components</b></em>' containment reference list.
	 * The list contents are of type {@link pt.iscte.osgi.viscte.model.Component}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Components</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components</em>' containment reference list.
	 * @see pt.iscte.osgi.viscte.model.ModelPackage#getBundleGraph_Components()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Component> getComponents();

	/**
	 * Returns the value of the '<em><b>Lifecycle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lifecycle</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lifecycle</em>' reference.
	 * @see #setLifecycle(Lifecycle)
	 * @see pt.iscte.osgi.viscte.model.ModelPackage#getBundleGraph_Lifecycle()
	 * @model required="true"
	 * @generated
	 */
	Lifecycle getLifecycle();

	/**
	 * Sets the value of the '{@link pt.iscte.osgi.viscte.model.BundleGraph#getLifecycle <em>Lifecycle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lifecycle</em>' reference.
	 * @see #getLifecycle()
	 * @generated
	 */
	void setLifecycle(Lifecycle value);

} // BundleGraph
