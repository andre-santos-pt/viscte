/**
 */
package pt.iscte.osgi.viscte.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lifecycle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pt.iscte.osgi.viscte.model.Lifecycle#getStart <em>Start</em>}</li>
 *   <li>{@link pt.iscte.osgi.viscte.model.Lifecycle#getEnd <em>End</em>}</li>
 * </ul>
 * </p>
 *
 * @see pt.iscte.osgi.viscte.model.ModelPackage#getLifecycle()
 * @model
 * @generated
 */
public interface Lifecycle extends EObject {
	/**
	 * Returns the value of the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' attribute.
	 * @see #setStart(long)
	 * @see pt.iscte.osgi.viscte.model.ModelPackage#getLifecycle_Start()
	 * @model required="true"
	 * @generated
	 */
	long getStart();

	/**
	 * Sets the value of the '{@link pt.iscte.osgi.viscte.model.Lifecycle#getStart <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' attribute.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(long value);

	/**
	 * Returns the value of the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End</em>' attribute.
	 * @see #setEnd(long)
	 * @see pt.iscte.osgi.viscte.model.ModelPackage#getLifecycle_End()
	 * @model
	 * @generated
	 */
	long getEnd();

	/**
	 * Sets the value of the '{@link pt.iscte.osgi.viscte.model.Lifecycle#getEnd <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End</em>' attribute.
	 * @see #getEnd()
	 * @generated
	 */
	void setEnd(long value);

} // Lifecycle
