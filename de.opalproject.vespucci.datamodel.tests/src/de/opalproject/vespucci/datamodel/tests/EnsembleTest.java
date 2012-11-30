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

import org.junit.Assert;
import org.junit.Test;

import de.opalproject.vespucci.datamodel.DatamodelFactory;
import de.opalproject.vespucci.datamodel.Ensemble;

import junit.framework.TestCase;

import junit.textui.TestRunner;

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
		Assert.assertNotNull(fixture);
	}

	@Test
	public void testIfEnsemble() {
		Assert.assertTrue(fixture instanceof Ensemble);
	}

	@Test
	public void testDefaultName() {
		Assert.assertEquals(null, fixture.getName());

	}

	@Test
	public void testDefaultDescription() {
		Assert.assertEquals(null, fixture.getDescription());

	}

	@Test
	public void testDefaultQuery() {
		Assert.assertEquals(null, fixture.getQuery());

	}

	@Test
	public void testDefaultDerived() {
		Assert.assertEquals(false, fixture.isDerived());

	}

	@Test
	public void testDefaultParent() {
		Assert.assertEquals(null, fixture.getParent());

	}

	@Test
	public void testDefaultChildren() {
		Assert.assertNotNull(fixture.getChildren());
		Assert.assertEquals(0, fixture.getChildren().size());

	}

	@Test
	public void testSetName() {
		fixture.setName("test");
		Assert.assertEquals("test", fixture.getName());
	}

	@Test
	public void testSetDescription() {
		fixture.setDescription("test");
		Assert.assertEquals("test", fixture.getDescription());
	}

	@Test
	public void testSetQuery() {
		fixture.setQuery("test");
		Assert.assertEquals("test", fixture.getQuery());
	}

	@Test
	public void testSetDerived() {
		fixture.setDerived(true);
		Assert.assertEquals(true, fixture.isDerived());
	}

	@Test
	public void testAddChildren() {
		Ensemble child = DatamodelFactory.eINSTANCE.createEnsemble();
		fixture.getChildren().add(child);
		Assert.assertEquals(1, fixture.getChildren().size());
		Assert.assertEquals(child, fixture.getChildren().get(0));
	}

	@Test
	public void testParentReference() {
		Ensemble child = DatamodelFactory.eINSTANCE.createEnsemble();
		child.getChildren().add(fixture);
		Assert.assertEquals(child, fixture.getParent());
	}

} // EnsembleTest
