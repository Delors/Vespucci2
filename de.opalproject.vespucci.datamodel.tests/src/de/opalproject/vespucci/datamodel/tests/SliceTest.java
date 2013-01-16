/**
 */
package de.opalproject.vespucci.datamodel.tests;

import org.junit.Assert;
import org.junit.Test;

import de.opalproject.vespucci.datamodel.Constraint;
import de.opalproject.vespucci.datamodel.DatamodelFactory;
import de.opalproject.vespucci.datamodel.Slice;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object '
 * <em><b>Slice</b></em>'. <!-- end-user-doc -->
 * 
 * @generated
 */
public class SliceTest extends TestCase {

	/**
	 * The fixture for this Slice test case. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected Slice fixture = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SliceTest.class);
	}

	/**
	 * Constructs a new Slice test case with the given name. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SliceTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Slice test case. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected void setFixture(Slice fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Slice test case. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected Slice getFixture() {
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
		setFixture(DatamodelFactory.eINSTANCE.createSlice());
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
	public void testIfSlice() {
		Assert.assertTrue(getFixture() instanceof Slice);
	}

	@Test
	public void testDefaults() {
		Assert.assertEquals(null, getFixture().getName());
	}

	@Test
	public void testSetterAndGetter() {
		getFixture().setName("Test");
		Assert.assertEquals("Test", getFixture().getName());
	}

} // SliceTest
