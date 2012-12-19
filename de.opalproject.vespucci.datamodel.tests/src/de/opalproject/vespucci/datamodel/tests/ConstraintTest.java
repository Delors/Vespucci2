/**
 */
package de.opalproject.vespucci.datamodel.tests;

import org.junit.Assert;
import org.junit.Test;

import de.opalproject.vespucci.datamodel.Constraint;
import de.opalproject.vespucci.datamodel.ConstraintType;
import de.opalproject.vespucci.datamodel.DatamodelFactory;
import de.opalproject.vespucci.datamodel.DatamodelPackage;
import de.opalproject.vespucci.datamodel.DependencyKind;
import de.opalproject.vespucci.datamodel.impl.ConstraintImpl;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object '
 * <em><b>Constraint</b></em>'. <!-- end-user-doc -->
 * 
 * @generated
 */
public class ConstraintTest extends TestCase {

	/**
	 * The fixture for this Constraint test case. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected Constraint fixture = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ConstraintTest.class);
	}

	/**
	 * Constructs a new Constraint test case with the given name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ConstraintTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Constraint test case. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void setFixture(Constraint fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Constraint test case. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected Constraint getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(DatamodelFactory.eINSTANCE.createConstraint());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	@Test
	public void testExistance() {
		Assert.assertNotNull(getFixture());
	}

	@Test
	public void testIfEnsemble() {
		Assert.assertTrue(getFixture() instanceof Constraint);
	}

	@Test
	public void testDefaultDependencyKind() {
		Assert.assertEquals(DependencyKind.ALL, getFixture()
				.getDependencyKind());
	}

	@Test
	public void testSetDependencyKind() {
		getFixture().setDependencyKind(DependencyKind.CALLS);
		Assert.assertEquals(DependencyKind.CALLS, getFixture()
				.getDependencyKind());
	}

	@Test
	public void testResetDependencyKind() {
		getFixture().setDependencyKind(DependencyKind.CALLS);
		Assert.assertEquals(DependencyKind.CALLS, getFixture()
				.getDependencyKind());
		getFixture().setDependencyKind(null);
		Assert.assertEquals(DependencyKind.ALL, getFixture()
				.getDependencyKind());
	}

	@Test
	public void testDefaultConstraintType() {
		Assert.assertEquals(ConstraintType.NOT_ALLOWED, getFixture()
				.getConstraintType());
	}

	@Test
	public void testSetConstraintType() {
		getFixture().setConstraintType(ConstraintType.EXPECTED);
		Assert.assertEquals(ConstraintType.EXPECTED, getFixture()
				.getConstraintType());
	}

	@Test
	public void testResetConstraintType() {
		getFixture().setConstraintType(ConstraintType.EXPECTED);
		Assert.assertEquals(ConstraintType.EXPECTED, getFixture()
				.getConstraintType());
		getFixture().setConstraintType(null);
		Assert.assertEquals(ConstraintType.NOT_ALLOWED, getFixture()
				.getConstraintType());
	}

	@Test
	public void testToString() {
		Assert.assertNotNull(getFixture().toString());
	}

	@Test
	public void testReflectionsGet() {
		ConstraintImpl localFixture = (ConstraintImpl) getFixture();

		Assert.assertEquals(DependencyKind.ALL, localFixture.eGet(
				DatamodelPackage.CONSTRAINT__DEPENDENCY_KIND, false, false));
		Assert.assertEquals(ConstraintType.NOT_ALLOWED, localFixture.eGet(
				DatamodelPackage.CONSTRAINT__CONSTRAINT_TYPE, false, false));
	}

	@Test
	public void testReflectionsSet() {
		ConstraintImpl localFixture = (ConstraintImpl) getFixture();

		localFixture.eSet(DatamodelPackage.CONSTRAINT__DEPENDENCY_KIND,
				DependencyKind.CALLS);
		Assert.assertEquals(DependencyKind.CALLS, getFixture()
				.getDependencyKind());

		localFixture.eSet(DatamodelPackage.CONSTRAINT__CONSTRAINT_TYPE,
				ConstraintType.GLOBAL_INCOMING);
		Assert.assertEquals(ConstraintType.GLOBAL_INCOMING, getFixture()
				.getConstraintType());
	}

	@Test
	public void testReflectionsUnSet() {
		ConstraintImpl localFixture = (ConstraintImpl) getFixture();

		localFixture.eSet(DatamodelPackage.CONSTRAINT__DEPENDENCY_KIND,
				DependencyKind.CALLS);
		Assert.assertEquals(DependencyKind.CALLS, getFixture()
				.getDependencyKind());

		localFixture.eUnset(DatamodelPackage.CONSTRAINT__DEPENDENCY_KIND);
		Assert.assertEquals(DependencyKind.ALL, getFixture()
				.getDependencyKind());

		localFixture.eSet(DatamodelPackage.CONSTRAINT__CONSTRAINT_TYPE,
				ConstraintType.GLOBAL_INCOMING);
		Assert.assertEquals(ConstraintType.GLOBAL_INCOMING, getFixture()
				.getConstraintType());
		localFixture.eUnset(DatamodelPackage.CONSTRAINT__CONSTRAINT_TYPE);
		Assert.assertEquals(ConstraintType.NOT_ALLOWED, getFixture()
				.getConstraintType());
	}

	@Test
	public void testReflectionsIsSet() {
		ConstraintImpl localFixture = (ConstraintImpl) getFixture();

		Assert.assertFalse(localFixture
				.eIsSet(DatamodelPackage.CONSTRAINT__DEPENDENCY_KIND));
		getFixture().setDependencyKind(DependencyKind.ACCESS);
		Assert.assertTrue(localFixture
				.eIsSet(DatamodelPackage.CONSTRAINT__DEPENDENCY_KIND));

		Assert.assertFalse(localFixture
				.eIsSet(DatamodelPackage.CONSTRAINT__CONSTRAINT_TYPE));
		getFixture().setConstraintType(ConstraintType.EXPECTED);
		Assert.assertTrue(localFixture
				.eIsSet(DatamodelPackage.CONSTRAINT__CONSTRAINT_TYPE));
	}

} // ConstraintTest
