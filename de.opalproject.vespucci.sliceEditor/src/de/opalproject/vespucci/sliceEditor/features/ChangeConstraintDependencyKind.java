package de.opalproject.vespucci.sliceEditor.features;

import org.eclipse.graphiti.examples.common.ExampleUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import de.opalproject.vespucci.datamodel.Constraint;

public class ChangeConstraintDependencyKind extends AbstractCustomFeature {

	private boolean hasDoneChanges = false;

	public ChangeConstraintDependencyKind(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public String getName() {
		return "Change Dependency Kind";
	}

	@Override
	public String getDescription() {
		return "Change the dependency kind of a constraint";
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		// allow rename if exactly one pictogram element
		// representing a Constraint is selected
		boolean ret = false;
		PictogramElement[] pes = context.getPictogramElements();
		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(pes[0]);
			if (bo instanceof Constraint) {
				ret = true;
			}
		}
		if (pes != null && pes.length == 1) {
			if(pes[0] instanceof ConnectionDecorator){
				if(((ConnectionDecorator) pes[0]).getGraphicsAlgorithm() instanceof Text)
				return true;
			}
		}
		return ret;
	}

	@Override
	public void execute(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		
		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(pes[0]);
			if (bo instanceof Constraint) {
				Connection connection = (Connection) pes[0];
				Constraint constraint = (Constraint) bo;
				String currentKind = constraint.getDependencyKind();
				// ask user for a new dependency kind
				String newKind = ExampleUtil.askString(getName(),
						getDescription(), currentKind);
				// TODO add check to see whether the newly entered is a valid
				// one
				if (newKind != null && !newKind.equals(currentKind)) {
					this.hasDoneChanges = true;
					constraint.setDependencyKind(newKind);
					// hand changes to the connection decorator - label
					for (ConnectionDecorator condec : connection
							.getConnectionDecorators()) {
						if (condec.getGraphicsAlgorithm() instanceof Text) {
							Text text = (Text) condec.getGraphicsAlgorithm();
							text.setValue(newKind);
						}
					}
				}
			}
			if (pes[0] instanceof ConnectionDecorator) {
				ConnectionDecorator cd = (ConnectionDecorator) pes[0];
				Connection connection = cd.getConnection();
				if(getBusinessObjectForPictogramElement(connection) instanceof Constraint){
					Constraint constraint = (Constraint) getBusinessObjectForPictogramElement(connection);
					String currentKind = constraint.getDependencyKind();
					// ask user for a new dependency kind
					String newKind = ExampleUtil.askString(getName(),
							getDescription(), currentKind);
					if (newKind != null && !newKind.equals(currentKind)) {
						this.hasDoneChanges = true;
						constraint.setDependencyKind(newKind);
						if (cd.getGraphicsAlgorithm() instanceof Text) {
							Text text = (Text) cd.getGraphicsAlgorithm();
							text.setValue(newKind);
						}
					}
				}
			}
		}
	}

	@Override
	public boolean hasDoneChanges() {
		return this.hasDoneChanges;
	}
}