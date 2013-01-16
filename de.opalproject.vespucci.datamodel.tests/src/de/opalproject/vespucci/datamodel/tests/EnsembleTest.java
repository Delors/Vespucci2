/*
 * License (BSD Style License):
 * Copyright (c) 2012
 * Software Engineering
 * Department of Computer Science
 * Technische Universitiät Darmstadt
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * - Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * - Neither the name of the Software Engineering Group or Technische
 * Universität Darmstadt nor the names of its contributors may be used to
 * endorse or promote products derived from this software without specific
 * prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package de.opalproject.vespucci.datamodel.tests;

import java.util.ArrayList;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.junit.Assert;
import org.junit.Test;

import de.opalproject.vespucci.datamodel.Constraint;
import de.opalproject.vespucci.datamodel.DatamodelFactory;
import de.opalproject.vespucci.datamodel.DatamodelPackage;
import de.opalproject.vespucci.datamodel.Ensemble;
import de.opalproject.vespucci.datamodel.impl.EnsembleImpl;

/**
 * <!-- begin-user-doc --> A test case for the model object '
 * <em><b>Ensemble</b></em>'. <!-- end-user-doc -->
 * 
 * @generated
 */
public class EnsembleTest extends TestCase {

	/**
	 * The fixture for this Ensemble test case. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected Ensemble fixture = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EnsembleTest.class);
	}

	/**
	 * Constructs a new Ensemble test case with the given name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EnsembleTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Ensemble test case. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void setFixture(Ensemble fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Ensemble test case. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected Ensemble getFixture() {
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
		setFixture(DatamodelFactory.eINSTANCE.createEnsemble());
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
		Assert.assertTrue(getFixture() instanceof Ensemble);
	}

	@Test
	public void testDefaultName() {
		Assert.assertEquals(null, getFixture().getName());
	}

	@Test
	public void testDefaultDescription() {
		Assert.assertEquals(null, getFixture().getDescription());

	}

	@Test
	public void testDefaultQuery() {
		Assert.assertEquals(null, getFixture().getQuery());

	}

	@Test
	public void testDefaultDerived() {
		Assert.assertEquals(false, getFixture().isDerived());

	}

	@Test
	public void testDefaultParent() {
		Assert.assertEquals(null, getFixture().getParent());

	}

	@Test
	public void testDefaultChildren() {
		Assert.assertNotNull(getFixture().getChildren());
		Assert.assertEquals(0, getFixture().getChildren().size());

	}

	@Test
	public void testSetName() {
		getFixture().setName("test");
		Assert.assertEquals("test", getFixture().getName());
	}

	@Test
	public void testSetDescription() {
		getFixture().setDescription("test");
		Assert.assertEquals("test", getFixture().getDescription());
	}

	@Test
	public void testSetQuery() {
		getFixture().setQuery("test");
		Assert.assertEquals("test", getFixture().getQuery());
	}

	@Test
	public void testSetDerived() {
		getFixture().setDerived(true);
		Assert.assertEquals(true, getFixture().isDerived());
	}

	@Test
	public void testAddChildren() {
		Ensemble child = DatamodelFactory.eINSTANCE.createEnsemble();
		getFixture().getChildren().add(child);
		Assert.assertEquals(1, getFixture().getChildren().size());
		Assert.assertEquals(child, getFixture().getChildren().get(0));
	}

	@Test
	public void testParentReference() {
		Ensemble child = DatamodelFactory.eINSTANCE.createEnsemble();
		child.getChildren().add(getFixture());
		Assert.assertEquals(child, getFixture().getParent());
	}

	@Test
	public void testClearParentReference() {
		Ensemble child = DatamodelFactory.eINSTANCE.createEnsemble();
		child.getChildren().add(getFixture());
		child.getChildren().remove(getFixture());

		Assert.assertFalse(child.getChildren().contains(getFixture()));
	}

	@Test
	public void testSetParent() {
		Ensemble child = DatamodelFactory.eINSTANCE.createEnsemble();
		child.setParent(getFixture());
		Assert.assertEquals(child.getParent(), getFixture());
		Assert.assertTrue(getFixture().getChildren().contains(child));
	}

	@Test
	public void testClearParent() {
		Ensemble child = DatamodelFactory.eINSTANCE.createEnsemble();
		child.setParent(getFixture());
		child.setParent(null);

		Assert.assertEquals(child.getParent(), null);
		Assert.assertFalse(getFixture().getChildren().contains(child));
	}

	/**
	 * @Test(expected=IllegalArgumentException.class) won't work.
	 */
	@Test
	public void testRecursiveParent() {
		try {
			getFixture().setParent(getFixture());
			Assert.fail();
		} catch (Exception e) {
		}
	}

	@Test
	public void testReflectionsGet() {
		String name = "name";
		String description = "description";
		String query = "query";
		boolean derived = true;

		getFixture().setDerived(derived);
		getFixture().setName(name);
		getFixture().setDescription(description);
		getFixture().setQuery(query);

		EnsembleImpl localFixture = (EnsembleImpl) getFixture();

		Assert.assertEquals(name, localFixture.eGet(
				DatamodelPackage.ENSEMBLE__NAME, false, false));
		Assert.assertEquals(description, localFixture.eGet(
				DatamodelPackage.ENSEMBLE__DESCRIPTION, false, false));
		Assert.assertEquals(derived, localFixture.eGet(
				DatamodelPackage.ENSEMBLE__DERIVED, false, false));
		Assert.assertEquals(query, localFixture.eGet(
				DatamodelPackage.ENSEMBLE__QUERY, false, false));
		Assert.assertNotNull(localFixture.eGet(
				DatamodelPackage.ENSEMBLE__CHILDREN, false, false));
		Assert.assertNull(localFixture.eGet(DatamodelPackage.ENSEMBLE__PARENT,
				false, false));
	}

	@Test
	public void testReflectionsSet() {
		String name = "name";
		String description = "description";
		String query = "query";
		boolean derived = true;

		Ensemble parent = DatamodelFactory.eINSTANCE.createEnsemble();

		Ensemble child = DatamodelFactory.eINSTANCE.createEnsemble();
		ArrayList<Ensemble> children = new ArrayList<Ensemble>();
		children.add(child);

		Constraint constraint = DatamodelFactory.eINSTANCE.createConstraint();
		ArrayList<Constraint> constraints = new ArrayList<Constraint>();
		constraints.add(constraint);

		EnsembleImpl localFixture = (EnsembleImpl) getFixture();

		localFixture.eSet(DatamodelPackage.ENSEMBLE__NAME, name);
		localFixture.eSet(DatamodelPackage.ENSEMBLE__DESCRIPTION, description);
		localFixture.eSet(DatamodelPackage.ENSEMBLE__DERIVED, derived);
		localFixture.eSet(DatamodelPackage.ENSEMBLE__QUERY, query);
		localFixture.eSet(DatamodelPackage.ENSEMBLE__CHILDREN, children);
		localFixture.eSet(DatamodelPackage.ENSEMBLE__PARENT, parent);

		getFixture().setDerived(derived);
		getFixture().setName(name);
		getFixture().setDescription(description);
		getFixture().setQuery(query);

		Assert.assertEquals(name, getFixture().getName());
		Assert.assertEquals(description, getFixture().getDescription());
		Assert.assertEquals(derived, getFixture().isDerived());
		Assert.assertEquals(query, getFixture().getQuery());
		Assert.assertEquals(parent, getFixture().getParent());
		Assert.assertTrue(getFixture().getChildren().contains(child));

	}

	@Test
	public void testReflectionsUnSet() {

		EnsembleImpl localFixture = (EnsembleImpl) getFixture();

		localFixture.eUnset(DatamodelPackage.ENSEMBLE__NAME);
		localFixture.eUnset(DatamodelPackage.ENSEMBLE__DESCRIPTION);
		localFixture.eUnset(DatamodelPackage.ENSEMBLE__DERIVED);
		localFixture.eUnset(DatamodelPackage.ENSEMBLE__QUERY);
		localFixture.eUnset(DatamodelPackage.ENSEMBLE__CHILDREN);
		localFixture.eUnset(DatamodelPackage.ENSEMBLE__PARENT);

		Assert.assertNull(getFixture().getName());
		Assert.assertNull(getFixture().getDescription());
		Assert.assertFalse(getFixture().isDerived());
		Assert.assertNull(getFixture().getQuery());
		Assert.assertNull(getFixture().getParent());
		Assert.assertNotNull(getFixture().getChildren());
	}

	@Test
	public void testReflectionsIsSet() {
		EnsembleImpl localFixture = (EnsembleImpl) getFixture();

		Assert.assertFalse(localFixture.eIsSet(DatamodelPackage.ENSEMBLE__NAME));
		getFixture().setName("test");
		Assert.assertTrue(localFixture.eIsSet(DatamodelPackage.ENSEMBLE__NAME));

		Assert.assertFalse(localFixture
				.eIsSet(DatamodelPackage.ENSEMBLE__DERIVED));
		getFixture().setDerived(true);
		Assert.assertTrue(localFixture
				.eIsSet(DatamodelPackage.ENSEMBLE__DERIVED));

		Assert.assertFalse(localFixture
				.eIsSet(DatamodelPackage.ENSEMBLE__DESCRIPTION));
		getFixture().setDescription("description");
		Assert.assertTrue(localFixture
				.eIsSet(DatamodelPackage.ENSEMBLE__DESCRIPTION));

		Assert.assertFalse(localFixture
				.eIsSet(DatamodelPackage.ENSEMBLE__QUERY));
		getFixture().setQuery("query");
		Assert.assertTrue(localFixture.eIsSet(DatamodelPackage.ENSEMBLE__QUERY));

		Ensemble child = DatamodelFactory.eINSTANCE.createEnsemble();
		Assert.assertFalse(localFixture
				.eIsSet(DatamodelPackage.ENSEMBLE__CHILDREN));
		getFixture().getChildren();
		Assert.assertFalse(localFixture
				.eIsSet(DatamodelPackage.ENSEMBLE__CHILDREN));
		getFixture().getChildren().add(child);
		Assert.assertTrue(localFixture
				.eIsSet(DatamodelPackage.ENSEMBLE__CHILDREN));

		Ensemble parent = DatamodelFactory.eINSTANCE.createEnsemble();
		Assert.assertFalse(localFixture
				.eIsSet(DatamodelPackage.ENSEMBLE__PARENT));
		getFixture().setParent(parent);
		Assert.assertTrue(localFixture
				.eIsSet(DatamodelPackage.ENSEMBLE__PARENT));

	}
} // EnsembleTest
