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

import java.lang.reflect.Method;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.junit.Assert;
import org.junit.Test;

import de.opalproject.vespucci.datamodel.util.DatamodelResourceImpl;

/**
 * <!-- begin-user-doc --> A test case for the model object '
 * <em><b>DatamodelResourceImpl</b></em>'. <!-- end-user-doc -->
 * 
 * @generated
 */
public class DatamodelResourceTest extends TestCase {

	/**
	 * The fixture for this DatamodelResourceImpl test case. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DatamodelResourceImpl fixture = null;

	/**
	 * Constructs a new DatamodelResourceImpl test case with the given name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DatamodelResourceTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this DatamodelResourceImpl test case. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void setFixture(DatamodelResourceImpl fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this DatamodelResourceImpl test case. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DatamodelResourceImpl getFixture() {
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
		setFixture(new DatamodelResourceImpl(URI.createFileURI("test.xmi")));
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

	/**
	 * Test if uuid is enabled.
	 * 
	 * Could be reseted through deleting model code and regenerate it. In this
	 * case it defaults to false.
	 * 
	 * Using reflections to call a protected method
	 */
	@Test
	public void testIsUuidEnabled() {
		Class<?> c = getFixture().getClass();
		Method method;
		try {
			method = c.getDeclaredMethod("useUUIDs");
			method.setAccessible(true);
			Assert.assertTrue((boolean) method.invoke(getFixture()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
} // TreeNodeTest
