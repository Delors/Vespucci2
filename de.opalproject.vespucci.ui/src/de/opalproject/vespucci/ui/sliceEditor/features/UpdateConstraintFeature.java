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
package de.opalproject.vespucci.ui.sliceEditor.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;

import de.opalproject.vespucci.datamodel.Constraint;

/**
 * This feature updates constraint-kind labels if changes have been made.
 * 
 * @author Marius
 * 
 */
public class UpdateConstraintFeature extends AbstractUpdateFeature {

	/**
	 * Standard constructor to create the UpdateConstraintFeature.
	 * 
	 * @param fp - The Feature Provider.
	 */
	public UpdateConstraintFeature(IFeatureProvider fp) {
		super(fp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.graphiti.func.IUpdate#canUpdate(org.eclipse.graphiti.features
	 * .context.IUpdateContext)
	 */
	@Override
	public boolean canUpdate(IUpdateContext context) {
		return (context.getPictogramElement() instanceof ConnectionDecorator && context.getPictogramElement().getGraphicsAlgorithm() instanceof Text);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.graphiti.func.IUpdate#updateNeeded(org.eclipse.graphiti.features
	 * .context.IUpdateContext)
	 */
	@Override
	public IReason updateNeeded(IUpdateContext context) {
		String constraintKind = null;
		Text text = null;
		Connection connection = null;
		// retrieve connection Decorator
		ConnectionDecorator cd = (ConnectionDecorator) context
				.getPictogramElement();
		// find and retrieve text label
			connection = cd.getConnection();
			text = (Text) cd.getGraphicsAlgorithm();
		
		// Retrieve current value from pictogramElement
		constraintKind = text.getValue();

		// retrieve currentValue from businessModel
		String businessValue = null;
		Object bo = getBusinessObjectForPictogramElement(connection);
		if (bo instanceof Constraint) {
			Constraint constraint = (Constraint) bo;
			businessValue = constraint.getDependencyKind();
		}

		// update needed, if constraintKind label is out of date
		boolean updateConstraintKindNeeded = ((constraintKind == null && businessValue != null) || (constraintKind != null && !constraintKind
				.equals(businessValue)));
		if (updateConstraintKindNeeded) {
			return Reason
					.createTrueReason("ConstraintKind label is out of date");
		} else {
			return Reason.createFalseReason();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.graphiti.func.IUpdate#update(org.eclipse.graphiti.features
	 * .context.IUpdateContext)
	 */
	@Override
	public boolean update(IUpdateContext context) {
		ConnectionDecorator cd = null;
		// retrieve connectiondecorator affected
		
		cd = (ConnectionDecorator) context.getPictogramElement();
			
		Connection connection = cd.getConnection();

		// retrieve currentValue from businessModel
		String businessValue = null;
		Object bo = getBusinessObjectForPictogramElement(connection);
		if (bo instanceof Constraint) {
			Constraint constraint = (Constraint) bo;
			businessValue = constraint.getDependencyKind();
		}

		// Set constraintKind pictogram model
		// case cd is the actual constraint-kind label
		if (cd.getGraphicsAlgorithm() instanceof Text) {
			Text text = (Text) cd.getGraphicsAlgorithm();
			// set the new value retrieved from the businessobject
			text.setValue(businessValue);
			// check if it had been toggled invisible and thus if doesnt display
			// "ALL" anymore needs to be visible again
			if (!cd.isVisible() && !(text.equals("ALL"))) {
				cd.setVisible(true);
			}
			return true;
		}

		return false;
	}
}
