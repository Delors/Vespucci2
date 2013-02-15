/*
 * License (BSD Style License):
 * Copyright (c) 2012
 * Software Engineering
 * Department of Computer Science
 * Technische Universität Darmstadt
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

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.junit.Assert;
import org.junit.Test;

import de.opalproject.vespucci.datamodel.Constraint;
import de.opalproject.vespucci.datamodel.ConstraintType;
import de.opalproject.vespucci.datamodel.DatamodelFactory;
import de.opalproject.vespucci.datamodel.DatamodelPackage;
import de.opalproject.vespucci.datamodel.impl.ConstraintImpl;

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
		Assert.assertEquals("ALL", getFixture().getDependencyKind());
	}

	@Test
	public void testSetDependencyKind() {
		getFixture().setDependencyKind("ALL");
		Assert.assertEquals("ALL", getFixture().getDependencyKind());
	}

	@Test
	public void testResetDependencyKind() {
		getFixture().setDependencyKind("ALL");
		Assert.assertEquals("ALL", getFixture().getDependencyKind());
		getFixture().setDependencyKind(null);
		Assert.assertEquals(null, getFixture().getDependencyKind());
	}

	@Test
	public void testDefaultConstraintType() {
		Assert.assertEquals(ConstraintType.UNDEFINED, getFixture()
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
		Assert.assertEquals(ConstraintType.UNDEFINED, getFixture()
				.getConstraintType());
	}

	@Test
	public void testToString() {
		Assert.assertNotNull(getFixture().toString());
	}

	@Test
	public void testReflectionsGet() {
		ConstraintImpl localFixture = (ConstraintImpl) getFixture();

		Assert.assertEquals("ALL", localFixture.eGet(
				DatamodelPackage.CONSTRAINT__DEPENDENCY_KIND, false, false));
		Assert.assertEquals(ConstraintType.UNDEFINED, localFixture.eGet(
				DatamodelPackage.CONSTRAINT__CONSTRAINT_TYPE, false, false));
	}

	@Test
	public void testReflectionsSet() {
		ConstraintImpl localFixture = (ConstraintImpl) getFixture();

		localFixture.eSet(DatamodelPackage.CONSTRAINT__DEPENDENCY_KIND, "ALL");
		Assert.assertEquals("ALL", getFixture().getDependencyKind());

		localFixture.eSet(DatamodelPackage.CONSTRAINT__CONSTRAINT_TYPE,
				ConstraintType.GLOBAL_INCOMING);
		Assert.assertEquals(ConstraintType.GLOBAL_INCOMING, getFixture()
				.getConstraintType());
	}

	@Test
	public void testReflectionsUnSet() {
		ConstraintImpl localFixture = (ConstraintImpl) getFixture();

		localFixture.eSet(DatamodelPackage.CONSTRAINT__DEPENDENCY_KIND, "ALL");
		Assert.assertEquals("ALL", getFixture().getDependencyKind());

		localFixture.eUnset(DatamodelPackage.CONSTRAINT__DEPENDENCY_KIND);
		Assert.assertEquals("ALL", getFixture().getDependencyKind());

		localFixture.eSet(DatamodelPackage.CONSTRAINT__CONSTRAINT_TYPE,
				ConstraintType.GLOBAL_INCOMING);
		Assert.assertEquals(ConstraintType.GLOBAL_INCOMING, getFixture()
				.getConstraintType());
		localFixture.eUnset(DatamodelPackage.CONSTRAINT__CONSTRAINT_TYPE);
		Assert.assertEquals(ConstraintType.UNDEFINED, getFixture()
				.getConstraintType());
	}

	@Test
	public void testReflectionsIsSet() {
		ConstraintImpl localFixture = (ConstraintImpl) getFixture();

		Assert.assertFalse(localFixture
				.eIsSet(DatamodelPackage.CONSTRAINT__DEPENDENCY_KIND));
		getFixture().setDependencyKind("CALL");
		Assert.assertTrue(localFixture
				.eIsSet(DatamodelPackage.CONSTRAINT__DEPENDENCY_KIND));

		Assert.assertFalse(localFixture
				.eIsSet(DatamodelPackage.CONSTRAINT__CONSTRAINT_TYPE));
		getFixture().setConstraintType(ConstraintType.EXPECTED);
		Assert.assertTrue(localFixture
				.eIsSet(DatamodelPackage.CONSTRAINT__CONSTRAINT_TYPE));
	}

} // ConstraintTest
