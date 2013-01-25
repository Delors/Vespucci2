package de.opalproject.vespucci.sliceEditor.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.AbstractDirectEditingFeature;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

import de.opalproject.vespucci.datamodel.Constraint;

public class ConstraintKindDirectEditFeature extends
AbstractDirectEditingFeature {

public ConstraintKindDirectEditFeature(IFeatureProvider fp) {
    super(fp);
}

public int getEditingType() {
    // there are several possible editor-types supported:
    // text-field, checkbox, color-chooser, combobox, ...
    return TYPE_TEXT;
}

@Override
public boolean canDirectEdit(IDirectEditingContext context) {
    PictogramElement pe = context.getPictogramElement();
    if(pe instanceof ConnectionDecorator){
    	ConnectionDecorator cd = (ConnectionDecorator) pe;
    	if(cd.getGraphicsAlgorithm() instanceof Text && getBusinessObjectForPictogramElement(cd.getConnection()) instanceof Constraint){
    		return true;
    	}
    }

    // direct editing not supported in all other cases
    return false;
}

public String getInitialValue(IDirectEditingContext context) {
    // return the current dependencyKind of the Constraint
    PictogramElement pe = context.getPictogramElement();
    Constraint constraint = (Constraint) getBusinessObjectForPictogramElement(pe);
    return constraint.getDependencyKind();
}

@Override
public String checkValueValid(String value, IDirectEditingContext context) {
    if (value.length() < 1)
        return "Please enter any text as dependency kind.";
    if (value.contains(" "))
        return "Spaces are not allowed in dependency kind.";
    if (value.contains("\n"))
        return "Line breakes are not allowed in dependency kind.";

    // null means, that the value is valid
    return null;
}

public void setValue(String value, IDirectEditingContext context) {
    // set the new name for the EClass
    PictogramElement pe = context.getPictogramElement();
    Constraint constraint = (Constraint) getBusinessObjectForPictogramElement(pe);
    constraint.setDependencyKind(value);

    // Explicitly update the shape to display the new value in the diagram
    // Note, that this might not be necessary in future versions of Graphiti
    // (currently in discussion)

    // we know, that pe is the Shape of the Text, so its container is the
    // main shape of the EClass
    updatePictogramElement(((Shape) pe).getContainer());
}
}
