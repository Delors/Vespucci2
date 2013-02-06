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
package de.opalproject.vespucci.datamodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Tree Node</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.opalproject.vespucci.datamodel.TreeNode#getParent <em>Parent</em>}</li>
 *   <li>{@link de.opalproject.vespucci.datamodel.TreeNode#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.opalproject.vespucci.datamodel.DatamodelPackage#getTreeNode()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface TreeNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.opalproject.vespucci.datamodel.TreeNode#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(TreeNode)
	 * @see de.opalproject.vespucci.datamodel.DatamodelPackage#getTreeNode_Parent()
	 * @see de.opalproject.vespucci.datamodel.TreeNode#getChildren
	 * @model opposite="children" transient="false"
	 * @generated
	 */
	TreeNode getParent();

	/**
	 * Sets the value of the '{@link de.opalproject.vespucci.datamodel.TreeNode#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(TreeNode value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link de.opalproject.vespucci.datamodel.TreeNode}.
	 * It is bidirectional and its opposite is '{@link de.opalproject.vespucci.datamodel.TreeNode#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see de.opalproject.vespucci.datamodel.DatamodelPackage#getTreeNode_Children()
	 * @see de.opalproject.vespucci.datamodel.TreeNode#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<TreeNode> getChildren();

} // TreeNode
