/**
 */
package pt.iscte.osgi.viscte.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pt.iscte.osgi.viscte.model.Connection#getService <em>Service</em>}</li>
 *   <li>{@link pt.iscte.osgi.viscte.model.Connection#getComponent <em>Component</em>}</li>
 *   <li>{@link pt.iscte.osgi.viscte.model.Connection#getLifecycles <em>Lifecycles</em>}</li>
 *   <li>{@link pt.iscte.osgi.viscte.model.Connection#getServiceClass <em>Service Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see pt.iscte.osgi.viscte.model.ModelPackage#getConnection()
 * @model
 * @generated
 */
public interface Connection extends EObject {
	/**
	 * Returns the value of the '<em><b>Service</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service</em>' reference.
	 * @see #setService(Service)
	 * @see pt.iscte.osgi.viscte.model.ModelPackage#getConnection_Service()
	 * @model required="true"
	 * @generated
	 */
	Service getService();

	/**
	 * Sets the value of the '{@link pt.iscte.osgi.viscte.model.Connection#getService <em>Service</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service</em>' reference.
	 * @see #getService()
	 * @generated
	 */
	void setService(Service value);

	/**
	 * Returns the value of the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component</em>' reference.
	 * @see #setComponent(Component)
	 * @see pt.iscte.osgi.viscte.model.ModelPackage#getConnection_Component()
	 * @model required="true"
	 * @generated
	 */
	Component getComponent();

	/**
	 * Sets the value of the '{@link pt.iscte.osgi.viscte.model.Connection#getComponent <em>Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component</em>' reference.
	 * @see #getComponent()
	 * @generated
	 */
	void setComponent(Component value);

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
	 * @see pt.iscte.osgi.viscte.model.ModelPackage#getConnection_Lifecycles()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Lifecycle> getLifecycles();

	/**
	 * Returns the value of the '<em><b>Service Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Class</em>' attribute.
	 * @see #setServiceClass(String)
	 * @see pt.iscte.osgi.viscte.model.ModelPackage#getConnection_ServiceClass()
	 * @model
	 * @generated
	 */
	String getServiceClass();

	/**
	 * Sets the value of the '{@link pt.iscte.osgi.viscte.model.Connection#getServiceClass <em>Service Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Class</em>' attribute.
	 * @see #getServiceClass()
	 * @generated
	 */
	void setServiceClass(String value);

} // Connection
