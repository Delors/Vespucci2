package de.opalproject.vespucci.sliceEditor.features;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.impl.DefaultRemoveFeature;
import org.eclipse.graphiti.mm.pictograms.Connection;

import de.opalproject.vespucci.datamodel.DatamodelPackage;
import de.opalproject.vespucci.datamodel.Slice;

public class RemoveFeature extends DefaultRemoveFeature {

	public RemoveFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void remove(IRemoveContext context) {
		// TODO Auto-generated method stub

		Object buisnessObject = getBusinessObjectForPictogramElement(getDiagram());
		if (buisnessObject instanceof Slice) {

			TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
					.getEditingDomain("de.opalproject.vespucci.navigator.domain.DatamodelEditingDomain");

			Slice slice = (Slice) buisnessObject;
			Command removeCommand;

			if (context.getPictogramElement() instanceof Connection) {
				removeCommand = RemoveCommand.create(domain, slice,
						DatamodelPackage.Literals.SLICE__CONSTRAINTS,
						getBusinessObjectForPictogramElement(context
								.getPictogramElement()));
			} else {
				removeCommand = RemoveCommand.create(domain, slice,
						DatamodelPackage.Literals.SLICE__ENSEMBLES,
						getBusinessObjectForPictogramElement(context
								.getPictogramElement()));
			}

			domain.getCommandStack().execute(removeCommand);
			super.remove(context);
		}
	}

}
