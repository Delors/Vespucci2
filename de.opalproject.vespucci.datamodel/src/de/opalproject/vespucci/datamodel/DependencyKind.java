/**
 */
package de.opalproject.vespucci.datamodel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '
 * <em><b>Dependency Kind</b></em>', and utility methods for working with them.
 * <!-- end-user-doc -->
 * 
 * @see de.opalproject.vespucci.datamodel.DatamodelPackage#getDependencyKind()
 * @model
 * @generated
 */
public enum DependencyKind implements Enumerator {
	/**
	 * The '<em><b>All</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #ALL_VALUE
	 * @generated
	 * @ordered
	 */
	ALL(0, "all", "all"),

	/**
	 * The '<em><b>Subtype</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #SUBTYPE_VALUE
	 * @generated
	 * @ordered
	 */
	SUBTYPE(1, "subtype", "subtype"),

	/**
	 * The '<em><b>Extend</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #EXTEND_VALUE
	 * @generated
	 * @ordered
	 */
	EXTEND(2, "extend", "extend"),

	/**
	 * The '<em><b>Implement</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #IMPLEMENT_VALUE
	 * @generated
	 * @ordered
	 */
	IMPLEMENT(3, "implement", "implement"),

	/**
	 * The '<em><b>Calls</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #CALLS_VALUE
	 * @generated
	 * @ordered
	 */
	CALLS(4, "calls", "calls"),

	/**
	 * The '<em><b>Invoke virtual</b></em>' literal object. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #INVOKE_VIRTUAL_VALUE
	 * @generated
	 * @ordered
	 */
	INVOKE_VIRTUAL(5, "invoke_virtual", "invoke_virtual"),

	/**
	 * The '<em><b>Invoke special</b></em>' literal object. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #INVOKE_SPECIAL_VALUE
	 * @generated
	 * @ordered
	 */
	INVOKE_SPECIAL(6, "invoke_special", "invoke_special"),

	/**
	 * The '<em><b>Invoke interface</b></em>' literal object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #INVOKE_INTERFACE_VALUE
	 * @generated
	 * @ordered
	 */
	INVOKE_INTERFACE(7, "invoke_interface", "invoke_interface"),

	/**
	 * The '<em><b>Invoke static</b></em>' literal object. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #INVOKE_STATIC_VALUE
	 * @generated
	 * @ordered
	 */
	INVOKE_STATIC(8, "invoke_static", "invoke_static"),

	/**
	 * The '<em><b>Access</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #ACCESS_VALUE
	 * @generated
	 * @ordered
	 */
	ACCESS(9, "access", "access"),

	/**
	 * The '<em><b>Write field</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #WRITE_FIELD_VALUE
	 * @generated
	 * @ordered
	 */
	WRITE_FIELD(10, "write_field", "write_field"),

	/**
	 * The '<em><b>Write static field</b></em>' literal object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #WRITE_STATIC_FIELD_VALUE
	 * @generated
	 * @ordered
	 */
	WRITE_STATIC_FIELD(11, "write_static_field", "write_static_field"),

	/**
	 * The '<em><b>Read field</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #READ_FIELD_VALUE
	 * @generated
	 * @ordered
	 */
	READ_FIELD(12, "read_field", "read_field"),

	/**
	 * The '<em><b>Read static field</b></em>' literal object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #READ_STATIC_FIELD_VALUE
	 * @generated
	 * @ordered
	 */
	READ_STATIC_FIELD(13, "read_static_field", "read_static_field"),

	/**
	 * The '<em><b>Signature</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #SIGNATURE_VALUE
	 * @generated
	 * @ordered
	 */
	SIGNATURE(14, "signature", "signature"),

	/**
	 * The '<em><b>Parameter</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #PARAMETER_VALUE
	 * @generated
	 * @ordered
	 */
	PARAMETER(15, "parameter", "parameter"),

	/**
	 * The '<em><b>Return type</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #RETURN_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	RETURN_TYPE(16, "return_type", "return_type"),

	/**
	 * The '<em><b>Class cast</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #CLASS_CAST_VALUE
	 * @generated
	 * @ordered
	 */
	CLASS_CAST(17, "class_cast", "class_cast"),

	/**
	 * The '<em><b>Create</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #CREATE_VALUE
	 * @generated
	 * @ordered
	 */
	CREATE(18, "create", "create"),

	/**
	 * The '<em><b>Field type</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #FIELD_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	FIELD_TYPE(19, "field_type", "field_type"),

	/**
	 * The '<em><b>Throws</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #THROWS_VALUE
	 * @generated
	 * @ordered
	 */
	THROWS(20, "throws", "throws");

	/**
	 * The '<em><b>All</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>All</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #ALL
	 * @model name="all"
	 * @generated
	 * @ordered
	 */
	public static final int ALL_VALUE = 0;

	/**
	 * The '<em><b>Subtype</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Subtype</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #SUBTYPE
	 * @model name="subtype"
	 * @generated
	 * @ordered
	 */
	public static final int SUBTYPE_VALUE = 1;

	/**
	 * The '<em><b>Extend</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Extend</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #EXTEND
	 * @model name="extend"
	 * @generated
	 * @ordered
	 */
	public static final int EXTEND_VALUE = 2;

	/**
	 * The '<em><b>Implement</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Implement</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #IMPLEMENT
	 * @model name="implement"
	 * @generated
	 * @ordered
	 */
	public static final int IMPLEMENT_VALUE = 3;

	/**
	 * The '<em><b>Calls</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Calls</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #CALLS
	 * @model name="calls"
	 * @generated
	 * @ordered
	 */
	public static final int CALLS_VALUE = 4;

	/**
	 * The '<em><b>Invoke virtual</b></em>' literal value. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of '<em><b>Invoke virtual</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #INVOKE_VIRTUAL
	 * @model name="invoke_virtual"
	 * @generated
	 * @ordered
	 */
	public static final int INVOKE_VIRTUAL_VALUE = 5;

	/**
	 * The '<em><b>Invoke special</b></em>' literal value. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of '<em><b>Invoke special</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #INVOKE_SPECIAL
	 * @model name="invoke_special"
	 * @generated
	 * @ordered
	 */
	public static final int INVOKE_SPECIAL_VALUE = 6;

	/**
	 * The '<em><b>Invoke interface</b></em>' literal value. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of '<em><b>Invoke interface</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #INVOKE_INTERFACE
	 * @model name="invoke_interface"
	 * @generated
	 * @ordered
	 */
	public static final int INVOKE_INTERFACE_VALUE = 7;

	/**
	 * The '<em><b>Invoke static</b></em>' literal value. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of '<em><b>Invoke static</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #INVOKE_STATIC
	 * @model name="invoke_static"
	 * @generated
	 * @ordered
	 */
	public static final int INVOKE_STATIC_VALUE = 8;

	/**
	 * The '<em><b>Access</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Access</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #ACCESS
	 * @model name="access"
	 * @generated
	 * @ordered
	 */
	public static final int ACCESS_VALUE = 9;

	/**
	 * The '<em><b>Write field</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Write field</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #WRITE_FIELD
	 * @model name="write_field"
	 * @generated
	 * @ordered
	 */
	public static final int WRITE_FIELD_VALUE = 10;

	/**
	 * The '<em><b>Write static field</b></em>' literal value. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Write static field</b></em>' literal object
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #WRITE_STATIC_FIELD
	 * @model name="write_static_field"
	 * @generated
	 * @ordered
	 */
	public static final int WRITE_STATIC_FIELD_VALUE = 11;

	/**
	 * The '<em><b>Read field</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Read field</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #READ_FIELD
	 * @model name="read_field"
	 * @generated
	 * @ordered
	 */
	public static final int READ_FIELD_VALUE = 12;

	/**
	 * The '<em><b>Read static field</b></em>' literal value. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Read static field</b></em>' literal object
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #READ_STATIC_FIELD
	 * @model name="read_static_field"
	 * @generated
	 * @ordered
	 */
	public static final int READ_STATIC_FIELD_VALUE = 13;

	/**
	 * The '<em><b>Signature</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Signature</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #SIGNATURE
	 * @model name="signature"
	 * @generated
	 * @ordered
	 */
	public static final int SIGNATURE_VALUE = 14;

	/**
	 * The '<em><b>Parameter</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Parameter</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #PARAMETER
	 * @model name="parameter"
	 * @generated
	 * @ordered
	 */
	public static final int PARAMETER_VALUE = 15;

	/**
	 * The '<em><b>Return type</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Return type</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #RETURN_TYPE
	 * @model name="return_type"
	 * @generated
	 * @ordered
	 */
	public static final int RETURN_TYPE_VALUE = 16;

	/**
	 * The '<em><b>Class cast</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Class cast</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #CLASS_CAST
	 * @model name="class_cast"
	 * @generated
	 * @ordered
	 */
	public static final int CLASS_CAST_VALUE = 17;

	/**
	 * The '<em><b>Create</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Create</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #CREATE
	 * @model name="create"
	 * @generated
	 * @ordered
	 */
	public static final int CREATE_VALUE = 18;

	/**
	 * The '<em><b>Field type</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Field type</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #FIELD_TYPE
	 * @model name="field_type"
	 * @generated
	 * @ordered
	 */
	public static final int FIELD_TYPE_VALUE = 19;

	/**
	 * The '<em><b>Throws</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Throws</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #THROWS
	 * @model name="throws"
	 * @generated
	 * @ordered
	 */
	public static final int THROWS_VALUE = 20;

	/**
	 * An array of all the '<em><b>Dependency Kind</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final DependencyKind[] VALUES_ARRAY = new DependencyKind[] {
			ALL, SUBTYPE, EXTEND, IMPLEMENT, CALLS, INVOKE_VIRTUAL,
			INVOKE_SPECIAL, INVOKE_INTERFACE, INVOKE_STATIC, ACCESS,
			WRITE_FIELD, WRITE_STATIC_FIELD, READ_FIELD, READ_STATIC_FIELD,
			SIGNATURE, PARAMETER, RETURN_TYPE, CLASS_CAST, CREATE, FIELD_TYPE,
			THROWS, };

	/**
	 * A public read-only list of all the '<em><b>Dependency Kind</b></em>'
	 * enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<DependencyKind> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Dependency Kind</b></em>' literal with the specified
	 * literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static DependencyKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DependencyKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Dependency Kind</b></em>' literal with the specified
	 * name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static DependencyKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DependencyKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Dependency Kind</b></em>' literal with the specified
	 * integer value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static DependencyKind get(int value) {
		switch (value) {
		case ALL_VALUE:
			return ALL;
		case SUBTYPE_VALUE:
			return SUBTYPE;
		case EXTEND_VALUE:
			return EXTEND;
		case IMPLEMENT_VALUE:
			return IMPLEMENT;
		case CALLS_VALUE:
			return CALLS;
		case INVOKE_VIRTUAL_VALUE:
			return INVOKE_VIRTUAL;
		case INVOKE_SPECIAL_VALUE:
			return INVOKE_SPECIAL;
		case INVOKE_INTERFACE_VALUE:
			return INVOKE_INTERFACE;
		case INVOKE_STATIC_VALUE:
			return INVOKE_STATIC;
		case ACCESS_VALUE:
			return ACCESS;
		case WRITE_FIELD_VALUE:
			return WRITE_FIELD;
		case WRITE_STATIC_FIELD_VALUE:
			return WRITE_STATIC_FIELD;
		case READ_FIELD_VALUE:
			return READ_FIELD;
		case READ_STATIC_FIELD_VALUE:
			return READ_STATIC_FIELD;
		case SIGNATURE_VALUE:
			return SIGNATURE;
		case PARAMETER_VALUE:
			return PARAMETER;
		case RETURN_TYPE_VALUE:
			return RETURN_TYPE;
		case CLASS_CAST_VALUE:
			return CLASS_CAST;
		case CREATE_VALUE:
			return CREATE;
		case FIELD_TYPE_VALUE:
			return FIELD_TYPE;
		case THROWS_VALUE:
			return THROWS;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	private DependencyKind(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string
	 * representation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} // DependencyKind
