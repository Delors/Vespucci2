/**
 */
package de.opalproject.vespucci.datamodel.util;

import de.opalproject.vespucci.datamodel.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.edit.ui.util.EditUIMarkerHelper;

/**
 * <!-- begin-user-doc --> The <b>Validator</b> for the model. <!-- end-user-doc
 * -->
 * 
 * @see de.opalproject.vespucci.datamodel.DatamodelPackage
 * @generated
 */
public class DatamodelValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final DatamodelValidator INSTANCE = new DatamodelValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.opalproject.vespucci.datamodel";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public DatamodelValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
		return DatamodelPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
		case DatamodelPackage.ENSEMBLE:
			return validateEnsemble((Ensemble) value, diagnostics, context);
		case DatamodelPackage.CONSTRAINT:
			return validateConstraint((Constraint) value, diagnostics, context);
		case DatamodelPackage.SLICE_REPOSITORY:
			return validateSliceRepository((SliceRepository) value,
					diagnostics, context);
		case DatamodelPackage.SLICE:
			return validateSlice((Slice) value, diagnostics, context);
		case DatamodelPackage.ENSEMBLE_REPOSITORY:
			return validateEnsembleRepository((EnsembleRepository) value,
					diagnostics, context);
		case DatamodelPackage.TREE_NODE:
			return validateTreeNode((TreeNode) value, diagnostics, context);
		case DatamodelPackage.EMPTY_ENSEMBLE:
			return validateEmptyEnsemble((EmptyEnsemble) value, diagnostics,
					context);
		case DatamodelPackage.CONCRETE_ENSEMBLE:
			return validateConcreteEnsemble((ConcreteEnsemble) value,
					diagnostics, context);
		case DatamodelPackage.CONSTRAINT_TYPE:
			return validateConstraintType((ConstraintType) value, diagnostics,
					context);
		case DatamodelPackage.EENSEMBLE:
			return validateEEnsemble(value, diagnostics, context);
		default:
			return true;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnsemble(Ensemble ensemble,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(ensemble, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConstraint(Constraint constraint,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(constraint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSliceRepository(SliceRepository sliceRepository,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(sliceRepository, diagnostics,
				context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSlice(Slice slice, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(slice, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(slice, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(slice, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(slice, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(slice,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(slice, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(slice, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(slice, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(slice, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateSlice_NonChildParent(slice, diagnostics, context);
		return result;
	}

	/**
	 * Validates the NonChildParent constraint of '<em>Slice</em>'. <!--
	 * begin-user-doc -->
	 *
	 * Checks whether there are child and parent within a slice model.
	 *  
	 *<!-- end-user-doc -->
	 * 
	 */
	/**
	 * @param slice
	 * @param diagnostics
	 * @param context
	 * @return true if valids
	 * @throws CoreException
	 */
	public boolean validateSlice_NonChildParent(Slice slice,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and
		// message
		if (checkParentOccurrence(slice.getEnsembles())) {
			if (diagnostics != null) {
				diagnostics.add(createDiagnostic(Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE, 0,
						"_UI_GenericConstraint_diagnostic", new Object[] {
								"NonChildParent",
								getObjectLabel(slice, context) },
						new Object[] { slice }, context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Detects already existing parent instances of the ensemble to be added.
	 * 
	 * @return true if infringement occure.
	 */
	private boolean checkParentOccurrence(List<Ensemble> ensembleList) {
		for (Ensemble ens : ensembleList) {
			while (!(ens.getParent() instanceof EnsembleRepository)
					&& ens.getParent() instanceof Ensemble) {
				ens = (Ensemble) ens.getParent();
				if (ensembleList.contains(ens)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnsembleRepository(
			EnsembleRepository ensembleRepository, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(ensembleRepository, diagnostics,
				context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTreeNode(TreeNode treeNode,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(treeNode, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEmptyEnsemble(EmptyEnsemble emptyEnsemble,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(emptyEnsemble, diagnostics,
				context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConcreteEnsemble(ConcreteEnsemble concreteEnsemble,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(concreteEnsemble, diagnostics,
				context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConstraintType(ConstraintType constraintType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEEnsemble(Object eEnsemble,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

	/**
	 * @param eObject
	 * @return
	 */
	public static boolean validateObject(EObject eObject) {
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
		EditUIMarkerHelper h = new EditUIMarkerHelper();
		if (diagnostic.getSeverity() == Diagnostic.ERROR
				|| diagnostic.getSeverity() == Diagnostic.WARNING) {
			System.err.println(diagnostic.getMessage());
			for (Iterator i = diagnostic.getChildren().iterator(); i.hasNext();) {
				Diagnostic childDiagnostic = (Diagnostic) i.next();
				switch (childDiagnostic.getSeverity()) {
				case Diagnostic.ERROR:
				case Diagnostic.WARNING:
					// TODO experimental marker management added to validation
					// TODO add own markertype
					// TODO fix marker display
					System.out.println("Marker creation triggered");
					try {
						h.createMarkers(childDiagnostic);
					} catch (CoreException e) {
						e.printStackTrace();
					}
					System.out.println("Has markers? : "
							+ h.hasMarkers(eObject));
					System.err.println("\t" + childDiagnostic.getMessage());
				}
			}
			return false;
		}
		// marker deletion if not needed anymore.
		if (h.hasMarkers(eObject)) {
			System.out.println("Marker deletion triggerd");
			h.deleteMarkers(eObject);
		}
		return true;
	}
} // DatamodelValidator
