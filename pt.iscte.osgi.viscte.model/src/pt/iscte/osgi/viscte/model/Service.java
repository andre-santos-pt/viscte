/**
 */
package pt.iscte.osgi.viscte.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pt.iscte.osgi.viscte.model.Service#getId <em>Id</em>}</li>
 *   <li>{@link pt.iscte.osgi.viscte.model.Service#getLifecycles <em>Lifecycles</em>}</li>
 *   <li>{@link pt.iscte.osgi.viscte.model.Service#getComponent <em>Component</em>}</li>
 * </ul>
 * </p>
 *
 * @see pt.iscte.osgi.viscte.model.ModelPackage#getService()
 * @model
 * @generated
 */
public interface Service extends EObject {
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
	 * @see pt.iscte.osgi.viscte.model.ModelPackage#getService_Id()
	 * @model required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link pt.iscte.osgi.viscte.model.Service#getId <em>Id</em>}' attribute.
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
	 * @see pt.iscte.osgi.viscte.model.ModelPackage#getService_Lifecycles()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Lifecycle> getLifecycles();

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
	 * @see pt.iscte.osgi.viscte.model.ModelPackage#getService_Component()
	 * @model required="true"
	 * @generated
	 */
	Component getComponent();

	/**
	 * Sets the value of the '{@link pt.iscte.osgi.viscte.model.Service#getComponent <em>Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component</em>' reference.
	 * @see #getComponent()
	 * @generated
	 */
	void setComponent(Component value);

} // Service
