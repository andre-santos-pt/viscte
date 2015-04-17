/**
 */
package pt.iscte.osgi.viscte.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see pt.iscte.osgi.viscte.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///model.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "pt.iscte.osgi.viscte";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = pt.iscte.osgi.viscte.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link pt.iscte.osgi.viscte.model.impl.BundleGraphImpl <em>Bundle Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pt.iscte.osgi.viscte.model.impl.BundleGraphImpl
	 * @see pt.iscte.osgi.viscte.model.impl.ModelPackageImpl#getBundleGraph()
	 * @generated
	 */
	int BUNDLE_GRAPH = 0;

	/**
	 * The feature id for the '<em><b>Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_GRAPH__COMPONENTS = 0;

	/**
	 * The feature id for the '<em><b>Lifecycle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_GRAPH__LIFECYCLE = 1;

	/**
	 * The number of structural features of the '<em>Bundle Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_GRAPH_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Bundle Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_GRAPH_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link pt.iscte.osgi.viscte.model.impl.ComponentImpl <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pt.iscte.osgi.viscte.model.impl.ComponentImpl
	 * @see pt.iscte.osgi.viscte.model.impl.ModelPackageImpl#getComponent()
	 * @generated
	 */
	int COMPONENT = 1;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__SERVICES = 0;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__CONNECTIONS = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__ID = 2;

	/**
	 * The feature id for the '<em><b>Lifecycles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__LIFECYCLES = 3;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link pt.iscte.osgi.viscte.model.impl.ServiceImpl <em>Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pt.iscte.osgi.viscte.model.impl.ServiceImpl
	 * @see pt.iscte.osgi.viscte.model.impl.ModelPackageImpl#getService()
	 * @generated
	 */
	int SERVICE = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__ID = 0;

	/**
	 * The feature id for the '<em><b>Lifecycles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__LIFECYCLES = 1;

	/**
	 * The feature id for the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__COMPONENT = 2;

	/**
	 * The number of structural features of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link pt.iscte.osgi.viscte.model.impl.ConnectionImpl <em>Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pt.iscte.osgi.viscte.model.impl.ConnectionImpl
	 * @see pt.iscte.osgi.viscte.model.impl.ModelPackageImpl#getConnection()
	 * @generated
	 */
	int CONNECTION = 3;

	/**
	 * The feature id for the '<em><b>Service</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__SERVICE = 0;

	/**
	 * The feature id for the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__COMPONENT = 1;

	/**
	 * The feature id for the '<em><b>Lifecycles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__LIFECYCLES = 2;

	/**
	 * The feature id for the '<em><b>Service Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__SERVICE_CLASS = 3;

	/**
	 * The number of structural features of the '<em>Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link pt.iscte.osgi.viscte.model.impl.LifecycleImpl <em>Lifecycle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pt.iscte.osgi.viscte.model.impl.LifecycleImpl
	 * @see pt.iscte.osgi.viscte.model.impl.ModelPackageImpl#getLifecycle()
	 * @generated
	 */
	int LIFECYCLE = 4;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFECYCLE__START = 0;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFECYCLE__END = 1;

	/**
	 * The number of structural features of the '<em>Lifecycle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFECYCLE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Lifecycle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFECYCLE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link pt.iscte.osgi.viscte.model.BundleGraph <em>Bundle Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bundle Graph</em>'.
	 * @see pt.iscte.osgi.viscte.model.BundleGraph
	 * @generated
	 */
	EClass getBundleGraph();

	/**
	 * Returns the meta object for the containment reference list '{@link pt.iscte.osgi.viscte.model.BundleGraph#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Components</em>'.
	 * @see pt.iscte.osgi.viscte.model.BundleGraph#getComponents()
	 * @see #getBundleGraph()
	 * @generated
	 */
	EReference getBundleGraph_Components();

	/**
	 * Returns the meta object for the reference '{@link pt.iscte.osgi.viscte.model.BundleGraph#getLifecycle <em>Lifecycle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Lifecycle</em>'.
	 * @see pt.iscte.osgi.viscte.model.BundleGraph#getLifecycle()
	 * @see #getBundleGraph()
	 * @generated
	 */
	EReference getBundleGraph_Lifecycle();

	/**
	 * Returns the meta object for class '{@link pt.iscte.osgi.viscte.model.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see pt.iscte.osgi.viscte.model.Component
	 * @generated
	 */
	EClass getComponent();

	/**
	 * Returns the meta object for the containment reference list '{@link pt.iscte.osgi.viscte.model.Component#getServices <em>Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Services</em>'.
	 * @see pt.iscte.osgi.viscte.model.Component#getServices()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Services();

	/**
	 * Returns the meta object for the containment reference list '{@link pt.iscte.osgi.viscte.model.Component#getConnections <em>Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connections</em>'.
	 * @see pt.iscte.osgi.viscte.model.Component#getConnections()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Connections();

	/**
	 * Returns the meta object for the attribute '{@link pt.iscte.osgi.viscte.model.Component#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see pt.iscte.osgi.viscte.model.Component#getId()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_Id();

	/**
	 * Returns the meta object for the containment reference list '{@link pt.iscte.osgi.viscte.model.Component#getLifecycles <em>Lifecycles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lifecycles</em>'.
	 * @see pt.iscte.osgi.viscte.model.Component#getLifecycles()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Lifecycles();

	/**
	 * Returns the meta object for class '{@link pt.iscte.osgi.viscte.model.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service</em>'.
	 * @see pt.iscte.osgi.viscte.model.Service
	 * @generated
	 */
	EClass getService();

	/**
	 * Returns the meta object for the attribute '{@link pt.iscte.osgi.viscte.model.Service#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see pt.iscte.osgi.viscte.model.Service#getId()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Id();

	/**
	 * Returns the meta object for the containment reference list '{@link pt.iscte.osgi.viscte.model.Service#getLifecycles <em>Lifecycles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lifecycles</em>'.
	 * @see pt.iscte.osgi.viscte.model.Service#getLifecycles()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_Lifecycles();

	/**
	 * Returns the meta object for the reference '{@link pt.iscte.osgi.viscte.model.Service#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Component</em>'.
	 * @see pt.iscte.osgi.viscte.model.Service#getComponent()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_Component();

	/**
	 * Returns the meta object for class '{@link pt.iscte.osgi.viscte.model.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection</em>'.
	 * @see pt.iscte.osgi.viscte.model.Connection
	 * @generated
	 */
	EClass getConnection();

	/**
	 * Returns the meta object for the reference '{@link pt.iscte.osgi.viscte.model.Connection#getService <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Service</em>'.
	 * @see pt.iscte.osgi.viscte.model.Connection#getService()
	 * @see #getConnection()
	 * @generated
	 */
	EReference getConnection_Service();

	/**
	 * Returns the meta object for the reference '{@link pt.iscte.osgi.viscte.model.Connection#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Component</em>'.
	 * @see pt.iscte.osgi.viscte.model.Connection#getComponent()
	 * @see #getConnection()
	 * @generated
	 */
	EReference getConnection_Component();

	/**
	 * Returns the meta object for the containment reference list '{@link pt.iscte.osgi.viscte.model.Connection#getLifecycles <em>Lifecycles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lifecycles</em>'.
	 * @see pt.iscte.osgi.viscte.model.Connection#getLifecycles()
	 * @see #getConnection()
	 * @generated
	 */
	EReference getConnection_Lifecycles();

	/**
	 * Returns the meta object for the attribute '{@link pt.iscte.osgi.viscte.model.Connection#getServiceClass <em>Service Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Class</em>'.
	 * @see pt.iscte.osgi.viscte.model.Connection#getServiceClass()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_ServiceClass();

	/**
	 * Returns the meta object for class '{@link pt.iscte.osgi.viscte.model.Lifecycle <em>Lifecycle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lifecycle</em>'.
	 * @see pt.iscte.osgi.viscte.model.Lifecycle
	 * @generated
	 */
	EClass getLifecycle();

	/**
	 * Returns the meta object for the attribute '{@link pt.iscte.osgi.viscte.model.Lifecycle#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start</em>'.
	 * @see pt.iscte.osgi.viscte.model.Lifecycle#getStart()
	 * @see #getLifecycle()
	 * @generated
	 */
	EAttribute getLifecycle_Start();

	/**
	 * Returns the meta object for the attribute '{@link pt.iscte.osgi.viscte.model.Lifecycle#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End</em>'.
	 * @see pt.iscte.osgi.viscte.model.Lifecycle#getEnd()
	 * @see #getLifecycle()
	 * @generated
	 */
	EAttribute getLifecycle_End();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link pt.iscte.osgi.viscte.model.impl.BundleGraphImpl <em>Bundle Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pt.iscte.osgi.viscte.model.impl.BundleGraphImpl
		 * @see pt.iscte.osgi.viscte.model.impl.ModelPackageImpl#getBundleGraph()
		 * @generated
		 */
		EClass BUNDLE_GRAPH = eINSTANCE.getBundleGraph();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUNDLE_GRAPH__COMPONENTS = eINSTANCE.getBundleGraph_Components();

		/**
		 * The meta object literal for the '<em><b>Lifecycle</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUNDLE_GRAPH__LIFECYCLE = eINSTANCE.getBundleGraph_Lifecycle();

		/**
		 * The meta object literal for the '{@link pt.iscte.osgi.viscte.model.impl.ComponentImpl <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pt.iscte.osgi.viscte.model.impl.ComponentImpl
		 * @see pt.iscte.osgi.viscte.model.impl.ModelPackageImpl#getComponent()
		 * @generated
		 */
		EClass COMPONENT = eINSTANCE.getComponent();

		/**
		 * The meta object literal for the '<em><b>Services</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__SERVICES = eINSTANCE.getComponent_Services();

		/**
		 * The meta object literal for the '<em><b>Connections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__CONNECTIONS = eINSTANCE.getComponent_Connections();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__ID = eINSTANCE.getComponent_Id();

		/**
		 * The meta object literal for the '<em><b>Lifecycles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__LIFECYCLES = eINSTANCE.getComponent_Lifecycles();

		/**
		 * The meta object literal for the '{@link pt.iscte.osgi.viscte.model.impl.ServiceImpl <em>Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pt.iscte.osgi.viscte.model.impl.ServiceImpl
		 * @see pt.iscte.osgi.viscte.model.impl.ModelPackageImpl#getService()
		 * @generated
		 */
		EClass SERVICE = eINSTANCE.getService();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__ID = eINSTANCE.getService_Id();

		/**
		 * The meta object literal for the '<em><b>Lifecycles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__LIFECYCLES = eINSTANCE.getService_Lifecycles();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__COMPONENT = eINSTANCE.getService_Component();

		/**
		 * The meta object literal for the '{@link pt.iscte.osgi.viscte.model.impl.ConnectionImpl <em>Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pt.iscte.osgi.viscte.model.impl.ConnectionImpl
		 * @see pt.iscte.osgi.viscte.model.impl.ModelPackageImpl#getConnection()
		 * @generated
		 */
		EClass CONNECTION = eINSTANCE.getConnection();

		/**
		 * The meta object literal for the '<em><b>Service</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION__SERVICE = eINSTANCE.getConnection_Service();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION__COMPONENT = eINSTANCE.getConnection_Component();

		/**
		 * The meta object literal for the '<em><b>Lifecycles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION__LIFECYCLES = eINSTANCE.getConnection_Lifecycles();

		/**
		 * The meta object literal for the '<em><b>Service Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__SERVICE_CLASS = eINSTANCE.getConnection_ServiceClass();

		/**
		 * The meta object literal for the '{@link pt.iscte.osgi.viscte.model.impl.LifecycleImpl <em>Lifecycle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pt.iscte.osgi.viscte.model.impl.LifecycleImpl
		 * @see pt.iscte.osgi.viscte.model.impl.ModelPackageImpl#getLifecycle()
		 * @generated
		 */
		EClass LIFECYCLE = eINSTANCE.getLifecycle();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIFECYCLE__START = eINSTANCE.getLifecycle_Start();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIFECYCLE__END = eINSTANCE.getLifecycle_End();

	}

} //ModelPackage
