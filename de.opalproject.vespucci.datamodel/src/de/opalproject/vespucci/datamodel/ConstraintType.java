/**
 */
package de.opalproject.vespucci.datamodel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '
 * <em><b>Constraint Type</b></em>', and utility methods for working with them.
 * <!-- end-user-doc -->
 * 
 * @see de.opalproject.vespucci.datamodel.DatamodelPackage#getConstraintType()
 * @model
 * @generated
 */
public enum ConstraintType implements Enumerator {
	/**
	 * The '<em><b>Not Allowed</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #NOT_ALLOWED_VALUE
	 * @generated
	 * @ordered
	 */
	NOT_ALLOWED(0, "NotAllowed", "NotAllowed"),

	/**
	 * The '<em><b>Global Incoming</b></em>' literal object. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #GLOBAL_INCOMING_VALUE
	 * @generated
	 * @ordered
	 */
	GLOBAL_INCOMING(1, "GlobalIncoming", "GlobalIncoming"),

	/**
	 * The '<em><b>Local Incoming</b></em>' literal object. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #LOCAL_INCOMING_VALUE
	 * @generated
	 * @ordered
	 */
	LOCAL_INCOMING(2, "LocalIncoming", "LocalIncoming"),

	/**
	 * The '<em><b>Global Outgoing</b></em>' literal object. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #GLOBAL_OUTGOING_VALUE
	 * @generated
	 * @ordered
	 */
	GLOBAL_OUTGOING(3, "GlobalOutgoing", "GlobalOutgoing"),

	/**
	 * The '<em><b>Local Outgoing</b></em>' literal object. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #LOCAL_OUTGOING_VALUE
	 * @generated
	 * @ordered
	 */
	LOCAL_OUTGOING(4, "LocalOutgoing", "LocalOutgoing"),

	/**
	 * The '<em><b>Expected</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #EXPECTED_VALUE
	 * @generated
	 * @ordered
	 */
	EXPECTED(5, "Expected", "Expected");

	/**
	 * The '<em><b>Not Allowed</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Not Allowed</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #NOT_ALLOWED
	 * @model name="NotAllowed"
	 * @generated
	 * @ordered
	 */
	public static final int NOT_ALLOWED_VALUE = 0;

	/**
	 * The '<em><b>Global Incoming</b></em>' literal value. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of '<em><b>Global Incoming</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #GLOBAL_INCOMING
	 * @model name="GlobalIncoming"
	 * @generated
	 * @ordered
	 */
	public static final int GLOBAL_INCOMING_VALUE = 1;

	/**
	 * The '<em><b>Local Incoming</b></em>' literal value. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of '<em><b>Local Incoming</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #LOCAL_INCOMING
	 * @model name="LocalIncoming"
	 * @generated
	 * @ordered
	 */
	public static final int LOCAL_INCOMING_VALUE = 2;

	/**
	 * The '<em><b>Global Outgoing</b></em>' literal value. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of '<em><b>Global Outgoing</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #GLOBAL_OUTGOING
	 * @model name="GlobalOutgoing"
	 * @generated
	 * @ordered
	 */
	public static final int GLOBAL_OUTGOING_VALUE = 3;

	/**
	 * The '<em><b>Local Outgoing</b></em>' literal value. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of '<em><b>Local Outgoing</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #LOCAL_OUTGOING
	 * @model name="LocalOutgoing"
	 * @generated
	 * @ordered
	 */
	public static final int LOCAL_OUTGOING_VALUE = 4;

	/**
	 * The '<em><b>Expected</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Expected</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #EXPECTED
	 * @model name="Expected"
	 * @generated
	 * @ordered
	 */
	public static final int EXPECTED_VALUE = 5;

	/**
	 * An array of all the '<em><b>Constraint Type</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final ConstraintType[] VALUES_ARRAY = new ConstraintType[] {
			NOT_ALLOWED, GLOBAL_INCOMING, LOCAL_INCOMING, GLOBAL_OUTGOING,
			LOCAL_OUTGOING, EXPECTED, };

	/**
	 * A public read-only list of all the '<em><b>Constraint Type</b></em>'
	 * enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<ConstraintType> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Constraint Type</b></em>' literal with the specified
	 * literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static ConstraintType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ConstraintType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Constraint Type</b></em>' literal with the specified
	 * name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static ConstraintType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ConstraintType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Constraint Type</b></em>' literal with the specified
	 * integer value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static ConstraintType get(int value) {
		switch (value) {
		case NOT_ALLOWED_VALUE:
			return NOT_ALLOWED;
		case GLOBAL_INCOMING_VALUE:
			return GLOBAL_INCOMING;
		case LOCAL_INCOMING_VALUE:
			return LOCAL_INCOMING;
		case GLOBAL_OUTGOING_VALUE:
			return GLOBAL_OUTGOING;
		case LOCAL_OUTGOING_VALUE:
			return LOCAL_OUTGOING;
		case EXPECTED_VALUE:
			return EXPECTED;
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
	private ConstraintType(int value, String name, String literal) {
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

} // ConstraintType
