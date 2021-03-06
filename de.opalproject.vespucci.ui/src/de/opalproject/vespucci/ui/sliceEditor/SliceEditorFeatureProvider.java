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
package de.opalproject.vespucci.ui.sliceEditor;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

import de.opalproject.vespucci.datamodel.Constraint;
import de.opalproject.vespucci.datamodel.ConstraintType;
import de.opalproject.vespucci.datamodel.Ensemble;
import de.opalproject.vespucci.ui.sliceEditor.features.AddEnsembleFeature;
import de.opalproject.vespucci.ui.sliceEditor.features.ChangeConstraintDependencyKindFeature;
import de.opalproject.vespucci.ui.sliceEditor.features.CollapseFeature;
import de.opalproject.vespucci.ui.sliceEditor.features.ChangeConstraintDependencyKindDirectFeature;
import de.opalproject.vespucci.ui.sliceEditor.features.CreateEmptyEnsembleFeature;
import de.opalproject.vespucci.ui.sliceEditor.features.DependencyKindCollapseFeature;
import de.opalproject.vespucci.ui.sliceEditor.features.LayoutEnsembleFeature;
import de.opalproject.vespucci.ui.sliceEditor.features.RemoveFeature;
import de.opalproject.vespucci.ui.sliceEditor.features.ResizeEnsembleFeature;
import de.opalproject.vespucci.ui.sliceEditor.features.UpdateConstraintFeature;
import de.opalproject.vespucci.ui.sliceEditor.features.UpdateEnsembleFeature;
import de.opalproject.vespucci.ui.sliceEditor.features.constraints.AddExpectedConstraintFeature;
import de.opalproject.vespucci.ui.sliceEditor.features.constraints.AddGlobalIncomingConstraintFeature;
import de.opalproject.vespucci.ui.sliceEditor.features.constraints.AddGlobalOutgoingConstraintFeature;
import de.opalproject.vespucci.ui.sliceEditor.features.constraints.AddLocalIncomingConstraintFeature;
import de.opalproject.vespucci.ui.sliceEditor.features.constraints.AddLocalOutgoingConstraintFeature;
import de.opalproject.vespucci.ui.sliceEditor.features.constraints.AddNotAllowedConstraintFeature;
import de.opalproject.vespucci.ui.sliceEditor.features.constraints.CreateExpectedConstraintFeature;
import de.opalproject.vespucci.ui.sliceEditor.features.constraints.CreateGlobalIncomingConstraintFeature;
import de.opalproject.vespucci.ui.sliceEditor.features.constraints.CreateGlobalOutgoingConstraintFeature;
import de.opalproject.vespucci.ui.sliceEditor.features.constraints.CreateLocalIncomingConstraintFeature;
import de.opalproject.vespucci.ui.sliceEditor.features.constraints.CreateLocalOutgoingConstraintFeature;
import de.opalproject.vespucci.ui.sliceEditor.features.constraints.CreateNotAllowedConstraintFeature;

/**
 * Every feature of the Slice Editor has to be registered here
 * 
 * 
 * @author Lars, marius
 * 
 */
public class SliceEditorFeatureProvider extends DefaultFeatureProvider {

	public SliceEditorFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
	}

	/**
	 * The DeleteFeature is implemented by default. Since we don't want a
	 * DeleteFeature we just return null here
	 */
	@Override
	public IDeleteFeature getDeleteFeature(IDeleteContext context) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.graphiti.ui.features.DefaultFeatureProvider#getRemoveFeature
	 * (org.eclipse.graphiti.features.context.IRemoveContext)
	 */
	@Override
	public IRemoveFeature getRemoveFeature(IRemoveContext context) {
		return new RemoveFeature(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.graphiti.features.impl.AbstractFeatureProvider#getAddFeature
	 * (org.eclipse.graphiti.features.context.IAddContext)
	 */
	@Override
	public IAddFeature getAddFeature(IAddContext context) {
		// checks if the object to add is an Ensemble?
		if (context.getNewObject() instanceof Ensemble) {
			return new AddEnsembleFeature(this);
			// checks if the object to add is a Constraint
		} else if (context.getNewObject() instanceof Constraint) {

			Constraint constraint = (Constraint) context.getNewObject();

			// checks what type of Constraint has to be added
			switch (constraint.getConstraintType().getValue()) {
			case ConstraintType.EXPECTED_VALUE:
				return new AddExpectedConstraintFeature(this);
			case ConstraintType.GLOBAL_INCOMING_VALUE:
				return new AddGlobalIncomingConstraintFeature(this);
			case ConstraintType.GLOBAL_OUTGOING_VALUE:
				return new AddGlobalOutgoingConstraintFeature(this);
			case ConstraintType.LOCAL_INCOMING_VALUE:
				return new AddLocalIncomingConstraintFeature(this);
			case ConstraintType.LOCAL_OUTGOING_VALUE:
				return new AddLocalOutgoingConstraintFeature(this);
			case ConstraintType.NOT_ALLOWED_VALUE:
				return new AddNotAllowedConstraintFeature(this);
			default:
				return new AddNotAllowedConstraintFeature(this);
			}

		}

		return super.getAddFeature(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.graphiti.features.impl.AbstractFeatureProvider#getCreateFeatures
	 * ()
	 */
	@Override
	public ICreateFeature[] getCreateFeatures() {
		return new ICreateFeature[] { new CreateEmptyEnsembleFeature(this) };
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.graphiti.features.impl.AbstractFeatureProvider#getLayoutFeature
	 * (org.eclipse.graphiti.features.context.ILayoutContext)
	 */
	@Override
	public ILayoutFeature getLayoutFeature(ILayoutContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pictogramElement);
		// checks if the object requesting the LayoutFeature is an Ensemble
		if (bo instanceof Ensemble) {
			return new LayoutEnsembleFeature(this);
		}
		return super.getLayoutFeature(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.graphiti.features.impl.AbstractFeatureProvider#
	 * getCreateConnectionFeatures()
	 */
	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures() {
		return new ICreateConnectionFeature[] {
				new CreateLocalIncomingConstraintFeature(this),
				new CreateLocalOutgoingConstraintFeature(this),
				new CreateGlobalIncomingConstraintFeature(this),
				new CreateGlobalOutgoingConstraintFeature(this),
				new CreateExpectedConstraintFeature(this),
				new CreateNotAllowedConstraintFeature(this) };
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.graphiti.ui.features.DefaultFeatureProvider#getUpdateFeature
	 * (org.eclipse.graphiti.features.context.IUpdateContext)
	 */
	@Override
	public IUpdateFeature getUpdateFeature(IUpdateContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();
		// checks if the pictorgramElement is an Ensemble
		if (pictogramElement instanceof ContainerShape) {
			Object bo = getBusinessObjectForPictogramElement(pictogramElement);
			if (bo instanceof Ensemble) {
				return new UpdateEnsembleFeature(this);
			}
		}
		// checks if the pictorgramElement is a ConnectionDecorator
		if (pictogramElement instanceof ConnectionDecorator) {
			Object bo = getBusinessObjectForPictogramElement(((ConnectionDecorator) pictogramElement)
					.getConnection());
			// if the pictorgramElement is a ConnectionDecorator the linked
			// BusinessOBject needs to be a Constraint
			if (bo instanceof Constraint
					&& ((ConnectionDecorator) pictogramElement)
							.getGraphicsAlgorithm() instanceof Text) {
				return new UpdateConstraintFeature(this);
			}
		}
		return super.getUpdateFeature(context);
	}

	/**
	 * CustomFeatures are Features that don't override a defaultFeature.
	 * Implemented CustomFeatures: CollapseFeature, DependencyKindCollapsFeature
	 */
	@Override
	public ICustomFeature[] getCustomFeatures(ICustomContext context) {
		return new ICustomFeature[] { new ChangeConstraintDependencyKindFeature(this),
				new CollapseFeature(this),
				new DependencyKindCollapseFeature(this) };
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.graphiti.features.impl.AbstractFeatureProvider#
	 * getDirectEditingFeature
	 * (org.eclipse.graphiti.features.context.IDirectEditingContext)
	 */
	@Override
	public IDirectEditingFeature getDirectEditingFeature(
			IDirectEditingContext context) {
		PictogramElement pe = context.getPictogramElement();
		if (pe instanceof ConnectionDecorator) {
			return new ChangeConstraintDependencyKindDirectFeature(this);
		}
		return super.getDirectEditingFeature(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.graphiti.ui.features.DefaultFeatureProvider#getResizeShapeFeature
	 * (org.eclipse.graphiti.features.context.IResizeShapeContext)
	 */
	@Override
	public IResizeShapeFeature getResizeShapeFeature(IResizeShapeContext context) {
		Shape shape = context.getShape();
		Object bo = getBusinessObjectForPictogramElement(shape);
		if (bo instanceof Ensemble) {
			return new ResizeEnsembleFeature(this);
		}
		return super.getResizeShapeFeature(context);
	}
}
