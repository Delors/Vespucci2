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
package de.opalproject.vespucci.sliceEditor.features.constraints;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;

import de.opalproject.vespucci.datamodel.Constraint;
import de.opalproject.vespucci.datamodel.ConstraintType;
import de.opalproject.vespucci.datamodel.DatamodelFactory;
import de.opalproject.vespucci.datamodel.Ensemble;
import de.opalproject.vespucci.datamodel.Slice;

/**
 * This feature allows to create new constraint link
 * 
 * @author Lars
 * @author Marius
 * 
 */
public abstract class CreateConstraintFeature extends
		AbstractCreateConnectionFeature {
	private ConstraintType constraintType;

	/*
	 * constructor
	 */
	public CreateConstraintFeature(IFeatureProvider fp, String title,
			String description, ConstraintType constraintType) {
		// provide name and description for the UI, e.g. the palette
		super(fp, title, description);
		this.constraintType = constraintType;
	}

	@Override
	public abstract String getCreateImageId();

	/*
	 * checks if both anchors belong to an Ensemble and those Ensembles are not
	 * identical
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.graphiti.func.ICreateConnection#canCreate(org.eclipse.graphiti
	 * .features.context.ICreateConnectionContext)
	 */
	@Override
	public boolean canCreate(ICreateConnectionContext context) {

		Ensemble source = getEnsemble(context.getSourceAnchor());
		Ensemble target = getEnsemble(context.getTargetAnchor());
		if (source != null && target != null && source.equals(target)) {
			if (isAnchorSensibleSource(source)
					&& isAnchorSensibleTarget(target)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * checks if start anchor belongs to an Ensemble
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.graphiti.func.ICreateConnection#canStartConnection(org.eclipse
	 * .graphiti.features.context.ICreateConnectionContext)
	 */
	@Override
	public boolean canStartConnection(ICreateConnectionContext context) {
		if (getEnsemble(context.getSourceAnchor()) != null) {
			return isAnchorSensibleSource(getEnsemble(context.getSourceAnchor()));
		}
		return false;
	}

	/**
	 * checks whether the given ensemble would be a good source anchor for this
	 * constraint
	 * 
	 * mostly checks for compatibility with the empty ensemble
	 * 
	 * @param ensemble
	 * @return
	 */
	protected abstract boolean isAnchorSensibleSource(Ensemble ensemble);

	/**
	 * checks whether the given ensemble would be a good target anchor for this
	 * constraint
	 * 
	 * mostly checks for compatibility with the empty ensemble
	 * 
	 * @param ensemble
	 * @return
	 */
	protected abstract boolean isAnchorSensibleTarget(Ensemble ensemble);

	/*
	 * create the connection
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.graphiti.func.ICreateConnection#create(org.eclipse.graphiti
	 * .features.context.ICreateConnectionContext)
	 */
	@Override
	public Connection create(ICreateConnectionContext context) {
		Connection newConnection = null;

		// get ensembles which should be connected
		Ensemble source = getEnsemble(context.getSourceAnchor());
		Ensemble target = getEnsemble(context.getTargetAnchor());

		if (source != null && target != null) {
			// create new business object
			Constraint constraint = createConstraint(source, target);
			// add connection for business object
			AddConnectionContext addContext = new AddConnectionContext(
					context.getSourceAnchor(), context.getTargetAnchor());
			addContext.setNewObject(constraint);
			newConnection = (Connection) getFeatureProvider().addIfPossible(
					addContext);
		}

		return newConnection;
	}

	/**
	 * Returns the Ensemble belonging to the anchor, or null if not available.
	 */
	private Ensemble getEnsemble(Anchor anchor) {
		if (anchor != null) {
			Object object = getBusinessObjectForPictogramElement(anchor
					.getParent());
			if (object instanceof Ensemble) {
				return (Ensemble) object;
			}
		}
		return null;
	}

	/**
	 * Creates a constraint between two ensembles.
	 */
	private Constraint createConstraint(final Ensemble source,
			final Ensemble target) {
		// create Constraint
		DatamodelFactory factory = DatamodelFactory.eINSTANCE;
		final Constraint constraint = factory.createConstraint();
		constraint.setConstraintType(constraintType);
		constraint.setSource(source);
		constraint.setTarget(target);

		final Object businessObject = getBusinessObjectForPictogramElement(getDiagram());
		if (businessObject instanceof Slice) {

			TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
					.getEditingDomain("de.opalproject.vespucci.navigator.domain.DatamodelEditingDomain");

			Command addCommand = new RecordingCommand(domain) {

				@Override
				protected void doExecute() {
					Slice slice = (Slice) businessObject;
					slice.getConstraints().add(constraint);
					source.getConstraints().add(constraint);
					target.getConstraints().add(constraint);
				}
			};

			domain.getCommandStack().execute(addCommand);
		}

		return constraint;
	}
}
