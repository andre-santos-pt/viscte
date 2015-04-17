/**
 */
package pt.iscte.osgi.viscte.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pt.iscte.osgi.viscte.model.Component#getServices <em>Services</em>}</li>
 *   <li>{@link pt.iscte.osgi.viscte.model.Component#getConnections <em>Connections</em>}</li>
 *   <li>{@link pt.iscte.osgi.viscte.model.Component#getId <em>Id</em>}</li>
 *   <li>{@link pt.iscte.osgi.viscte.model.Component#getLifecycles <em>Lifecycles</em>}</li>
 * </ul>
 * </p>
 *
 * @see pt.iscte.osgi.viscte.model.ModelPackage#getComponent()
 * @model
 * @generated
 */
public interface Component extends EObject {
	/**
	 * Returns the value of the '<em><b>Services</b></em>' containment reference list.
	 * The list contents are of type {@link pt.iscte.osgi.viscte.model.Service}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Services</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Services</em>' containment reference list.
	 * @see pt.iscte.osgi.viscte.model.ModelPackage#getComponent_Services()
	 * @model containment="true"
	 * @generated
	 */
	EList<Service> getServices();

	/**
	 * Returns the value of the '<em><b>Connections</b></em>' containment reference list.
	 * The list contents are of type {@link pt.iscte.osgi.viscte.model.Connection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connections</em>' containment reference list.
	 * @see pt.iscte.osgi.viscte.model.ModelPackage#getComponent_Connections()
	 * @model containment="true"
	 * @generated
	 */
	EList<Connection> getConnections();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see pt.iscte.osgi.viscte.model.ModelPackage#getComponent_Id()
	 * @model required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link pt.iscte.osgi.viscte.model.Component#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Lifecycles</b></em>' containment reference list.
	 * The list contents are of type {@link pt.iscte.osgi.viscte.model.Lifecycle}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lifecycles</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lifecycles</em>' containment reference list.
	 * @see pt.iscte.osgi.viscte.model.ModelPackage#getComponent_Lifecycles()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Lifecycle> getLifecycles();

} // Component
