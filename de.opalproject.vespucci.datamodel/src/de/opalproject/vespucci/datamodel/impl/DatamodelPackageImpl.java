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
package de.opalproject.vespucci.datamodel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import de.opalproject.vespucci.datamodel.DatamodelFactory;
import de.opalproject.vespucci.datamodel.DatamodelPackage;
import de.opalproject.vespucci.datamodel.util.DatamodelValidator;
import java.io.IOException;
import java.net.URL;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class DatamodelPackageImpl extends EPackageImpl implements
		DatamodelPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected String packageFilename = "datamodel.ecore";

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ensembleEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sliceRepositoryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sliceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ensembleRepositoryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass treeNodeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass emptyEnsembleEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass concreteEnsembleEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum constraintTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType eEnsembleEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory
	 * method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.opalproject.vespucci.datamodel.DatamodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DatamodelPackageImpl() {
		super(eNS_URI, DatamodelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model,
	 * and for any others upon which it depends.
	 * 
	 * <p>
	 * This method is used to initialize {@link DatamodelPackage#eINSTANCE} when
	 * that field is accessed. Clients should not invoke it directly. Instead,
	 * they should simply access that field to obtain the package. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DatamodelPackage init() {
		if (isInited)
			return (DatamodelPackage) EPackage.Registry.INSTANCE
					.getEPackage(DatamodelPackage.eNS_URI);

		// Obtain or create and register package
		DatamodelPackageImpl theDatamodelPackage = (DatamodelPackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof DatamodelPackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI) : new DatamodelPackageImpl());

		isInited = true;

		// Load packages
		theDatamodelPackage.loadPackage();

		// Fix loaded packages
		theDatamodelPackage.fixPackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put(theDatamodelPackage,
				new EValidator.Descriptor() {
					public EValidator getEValidator() {
						return DatamodelValidator.INSTANCE;
					}
				});

		// Mark meta-data to indicate it can't be changed
		theDatamodelPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DatamodelPackage.eNS_URI,
				theDatamodelPackage);
		return theDatamodelPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnsemble() {
		if (ensembleEClass == null) {
			ensembleEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(DatamodelPackage.eNS_URI).getEClassifiers()
					.get(0);
		}
		return ensembleEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnsemble_Name() {
		return (EAttribute) getEnsemble().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnsemble_Derived() {
		return (EAttribute) getEnsemble().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnsemble_Description() {
		return (EAttribute) getEnsemble().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnsemble_Query() {
		return (EAttribute) getEnsemble().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstraint() {
		if (constraintEClass == null) {
			constraintEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(DatamodelPackage.eNS_URI).getEClassifiers()
					.get(1);
		}
		return constraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstraint_ConstraintType() {
		return (EAttribute) getConstraint().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstraint_DependencyKind() {
		return (EAttribute) getConstraint().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraint_Source() {
		return (EReference) getConstraint().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraint_Target() {
		return (EReference) getConstraint().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSliceRepository() {
		if (sliceRepositoryEClass == null) {
			sliceRepositoryEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(DatamodelPackage.eNS_URI).getEClassifiers()
					.get(3);
		}
		return sliceRepositoryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSliceRepository_Slices() {
		return (EReference) getSliceRepository().getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSliceRepository_EmptyEnsemble() {
		return (EReference) getSliceRepository().getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSlice() {
		if (sliceEClass == null) {
			sliceEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(DatamodelPackage.eNS_URI).getEClassifiers()
					.get(4);
		}
		return sliceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSlice_Constraints() {
		return (EReference) getSlice().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSlice_Ensembles() {
		return (EReference) getSlice().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSlice_SliceRepository() {
		return (EReference) getSlice().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSlice_Name() {
		return (EAttribute) getSlice().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSlice_Diagram() {
		return (EAttribute) getSlice().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnsembleRepository() {
		if (ensembleRepositoryEClass == null) {
			ensembleRepositoryEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(DatamodelPackage.eNS_URI).getEClassifiers()
					.get(5);
		}
		return ensembleRepositoryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTreeNode() {
		if (treeNodeEClass == null) {
			treeNodeEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(DatamodelPackage.eNS_URI).getEClassifiers()
					.get(6);
		}
		return treeNodeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTreeNode_Parent() {
		return (EReference) getTreeNode().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTreeNode_Children() {
		return (EReference) getTreeNode().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEmptyEnsemble() {
		if (emptyEnsembleEClass == null) {
			emptyEnsembleEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(DatamodelPackage.eNS_URI).getEClassifiers()
					.get(7);
		}
		return emptyEnsembleEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConcreteEnsemble() {
		if (concreteEnsembleEClass == null) {
			concreteEnsembleEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(DatamodelPackage.eNS_URI).getEClassifiers()
					.get(8);
		}
		return concreteEnsembleEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getConstraintType() {
		if (constraintTypeEEnum == null) {
			constraintTypeEEnum = (EEnum) EPackage.Registry.INSTANCE
					.getEPackage(DatamodelPackage.eNS_URI).getEClassifiers()
					.get(2);
		}
		return constraintTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEEnsemble() {
		if (eEnsembleEDataType == null) {
			eEnsembleEDataType = (EDataType) EPackage.Registry.INSTANCE
					.getEPackage(DatamodelPackage.eNS_URI).getEClassifiers()
					.get(9);
		}
		return eEnsembleEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DatamodelFactory getDatamodelFactory() {
		return (DatamodelFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isLoaded = false;

	/**
	 * Laods the package and any sub-packages from their serialized form. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void loadPackage() {
		if (isLoaded)
			return;
		isLoaded = true;

		URL url = getClass().getResource(packageFilename);
		if (url == null) {
			throw new RuntimeException("Missing serialized package: "
					+ packageFilename);
		}
		URI uri = URI.createURI(url.toString());
		Resource resource = new EcoreResourceFactoryImpl().createResource(uri);
		try {
			resource.load(null);
		} catch (IOException exception) {
			throw new WrappedException(exception);
		}
		initializeFromLoadedEPackage(this, (EPackage) resource.getContents()
				.get(0));
		createResource(eNS_URI);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isFixed = false;

	/**
	 * Fixes up the loaded package, to make it appear as if it had been programmatically built.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void fixPackageContents() {
		if (isFixed)
			return;
		isFixed = true;
		fixEClassifiers();
	}

	/**
	 * Sets the instance class on the given classifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void fixInstanceClass(EClassifier eClassifier) {
		if (eClassifier.getInstanceClassName() == null) {
			eClassifier
					.setInstanceClassName("de.opalproject.vespucci.datamodel."
							+ eClassifier.getName());
			setGeneratedClassName(eClassifier);
		}
	}

} // DatamodelPackageImpl
