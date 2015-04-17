/**
 */
package pt.iscte.osgi.viscte.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import pt.iscte.osgi.viscte.model.BundleGraph;
import pt.iscte.osgi.viscte.model.Component;
import pt.iscte.osgi.viscte.model.Lifecycle;
import pt.iscte.osgi.viscte.model.ModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bundle Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link pt.iscte.osgi.viscte.model.impl.BundleGraphImpl#getComponents <em>Components</em>}</li>
 *   <li>{@link pt.iscte.osgi.viscte.model.impl.BundleGraphImpl#getLifecycle <em>Lifecycle</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BundleGraphImpl extends MinimalEObjectImpl.Container implements BundleGraph {
	/**
	 * The cached value of the '{@link #getComponents() <em>Components</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponents()
	 * @generated
	 * @ordered
	 */
	protected EList<Component> components;

	/**
	 * The cached value of the '{@link #getLifecycle() <em>Lifecycle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLifecycle()
	 * @generated
	 * @ordered
	 */
	protected Lifecycle lifecycle;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BundleGraphImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.BUNDLE_GRAPH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Component> getComponents() {
		if (components == null) {
			components = new EObjectContainmentEList<Component>(Component.class, this, ModelPackage.BUNDLE_GRAPH__COMPONENTS);
		}
		return components;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Lifecycle getLifecycle() {
		if (lifecycle != null && lifecycle.eIsProxy()) {
			InternalEObject oldLifecycle = (InternalEObject)lifecycle;
			lifecycle = (Lifecycle)eResolveProxy(oldLifecycle);
			if (lifecycle != oldLifecycle) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.BUNDLE_GRAPH__LIFECYCLE, oldLifecycle, lifecycle));
			}
		}
		return lifecycle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Lifecycle basicGetLifecycle() {
		return lifecycle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLifecycle(Lifecycle newLifecycle) {
		Lifecycle oldLifecycle = lifecycle;
		lifecycle = newLifecycle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.BUNDLE_GRAPH__LIFECYCLE, oldLifecycle, lifecycle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.BUNDLE_GRAPH__COMPONENTS:
				return ((InternalEList<?>)getComponents()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.BUNDLE_GRAPH__COMPONENTS:
				return getComponents();
			case ModelPackage.BUNDLE_GRAPH__LIFECYCLE:
				if (resolve) return getLifecycle();
				return basicGetLifecycle();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.BUNDLE_GRAPH__COMPONENTS:
				getComponents().clear();
				getComponents().addAll((Collection<? extends Component>)newValue);
				return;
			case ModelPackage.BUNDLE_GRAPH__LIFECYCLE:
				setLifecycle((Lifecycle)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.BUNDLE_GRAPH__COMPONENTS:
				getComponents().clear();
				return;
			case ModelPackage.BUNDLE_GRAPH__LIFECYCLE:
				setLifecycle((Lifecycle)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.BUNDLE_GRAPH__COMPONENTS:
				return components != null && !components.isEmpty();
			case ModelPackage.BUNDLE_GRAPH__LIFECYCLE:
				return lifecycle != null;
		}
		return super.eIsSet(featureID);
	}

} //BundleGraphImpl
