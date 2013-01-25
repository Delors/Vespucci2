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
package de.opalproject.vespucci.sliceEditor.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.AbstractDirectEditingFeature;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
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
		if (pe instanceof ConnectionDecorator) {
			ConnectionDecorator cd = (ConnectionDecorator) pe;
			if (cd.getGraphicsAlgorithm() instanceof Text) {
				if (getBusinessObjectForPictogramElement(cd.getConnection()) instanceof Constraint) {
					return true;
				}
			}
		}

		// direct editing not supported in all other cases
		return false;
	}

	public String getInitialValue(IDirectEditingContext context) {
		// return the current dependencyKind of the Constraint
		ConnectionDecorator cd = (ConnectionDecorator) context
				.getPictogramElement();
		Connection connection = cd.getConnection();
		Constraint constraint = (Constraint) getBusinessObjectForPictogramElement(connection);
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

		@SuppressWarnings("unused")
		PictogramElement pe = context.getPictogramElement();
		ConnectionDecorator cd = (ConnectionDecorator) context
				.getPictogramElement();
		Connection connection = cd.getConnection();
		Constraint constraint = (Constraint) getBusinessObjectForPictogramElement(connection);
		constraint.setDependencyKind(value);

		// Explicitly update the shape to display the new value in the diagram
		// Note, that this might not be necessary in future versions of Graphiti
		// (currently in discussion)

		if (cd.getGraphicsAlgorithm() instanceof Text) {
			Text text = (Text) cd.getGraphicsAlgorithm();
			text.setValue(value);
		}
	}
}