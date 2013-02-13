package de.opalproject.vespucci.sliceEditor.features;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import de.opalproject.vespucci.datamodel.DatamodelPackage;
import de.opalproject.vespucci.datamodel.Ensemble;
import de.opalproject.vespucci.datamodel.Slice;

/**
 * @author Lars
 * @author Marius
 *
 */
public class CreateEmptyEnsembleFeature extends AbstractCreateFeature {

	/**
	 * 
	 */
	private static final String TITLE = "Empty Ensemble";

	/**
	 * @param fp
	 */
	public CreateEmptyEnsembleFeature(IFeatureProvider fp) {
		// set name and description of the creation feature
		super(fp, "Empty Ensemble", "Create Empty Ensemble");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.features.impl.AbstractCreateFeature#getCreateImageId()
	 */
	@Override
	public String getCreateImageId() {
		return "de.opalproject.vespucci.sliceEditor.emptyEnsemble";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.func.ICreate#canCreate(org.eclipse.graphiti.features.context.ICreateContext)
	 */
	public boolean canCreate(ICreateContext context) {
		return context.getTargetContainer() instanceof Diagram;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.func.ICreate#create(org.eclipse.graphiti.features.context.ICreateContext)
	 */
	public Object[] create(ICreateContext context) {
		EList<EObject> businessObjects = getDiagram().getLink()
				.getBusinessObjects();
		Ensemble ens = null;

		for (EObject eObject : businessObjects) {
			if (eObject instanceof Slice) {

				Slice slice = (Slice) eObject;
				ens = slice.getSliceRepository().getEmptyEnsemble();

				TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
						.getEditingDomain("de.opalproject.vespucci.navigator.domain.DatamodelEditingDomain");

				Command addCommand = AddCommand.create(domain, slice,
						DatamodelPackage.Literals.SLICE__ENSEMBLES, ens);

				// Save will be performed by graphiti
				domain.getCommandStack().execute(addCommand);

				
				// do the add
				addGraphicalRepresentation(context, ens);
			}
		}

		// return newly created business object(s)
		return new Object[] { ens };
	}
}
