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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Image;
import org.eclipse.graphiti.mm.algorithms.MultiText;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;

import de.opalproject.vespucci.datamodel.DatamodelPackage;
import de.opalproject.vespucci.datamodel.EmptyEnsemble;
import de.opalproject.vespucci.datamodel.Ensemble;
import de.opalproject.vespucci.datamodel.Slice;

/**
 * This feature allows to drag an ensemble from the Ensemble Explorer into the
 * slice editor
 * 
 * @author Lars
 * @author Marius
 * 
 */
public class AddEnsembleFeature extends AbstractAddShapeFeature {

	private static final ColorConstant EMPTY_ENSEMBLE_FOREGROUND = new ColorConstant(
			48, 48, 48);
	private static final ColorConstant EMPTY_ENSEMBLE_BACKGROUND = new ColorConstant(
			176, 176, 176);

	private static final ColorConstant ENSEMBLE_TEXT_FOREGROUND = (ColorConstant) ColorConstant.BLACK;
	private static final ColorConstant ENSEMBLE_FOREGROUND = new ColorConstant(
			98, 131, 167);
	private static final ColorConstant ENSEMBLE_BACKGROUND = new ColorConstant(
			187, 218, 247);

	private static final int DEFAULT_WIDTH = 100;
	private static final int DEFAULT_HEIGHT = 50;

	public AddEnsembleFeature(IFeatureProvider fp) {
		super(fp);
	}

	/*
	 * checks if the dragged element is an ensemble and therefore can be added
	 * to the slice editor
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.graphiti.func.IAdd#canAdd(org.eclipse.graphiti.features.context
	 * .IAddContext)
	 */
	@Override
	public boolean canAdd(IAddContext context) {
		// check if user wants to add an Ensemble
		if (context.getNewObject() instanceof Ensemble) {
			// check if user wants to add to a diagram
			if (context.getTargetContainer() instanceof Diagram) {
				// check if the pictogram element is already existing
				if ((Ensemble) context.getNewObject() instanceof EmptyEnsemble
						|| Graphiti
								.getLinkService()
								.getPictogramElements(
										(Diagram) context.getTargetContainer(),
										(Ensemble) context.getNewObject())
								.size() == 0) {
					return true;
				}
			}
		}
		return false;
	}

	/*
	 * execute the add
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.graphiti.func.IAdd#add(org.eclipse.graphiti.features.context
	 * .IAddContext)
	 */
	@Override
	public PictogramElement add(IAddContext context) {
		Ensemble addedEnsemble = (Ensemble) context.getNewObject();
		Diagram targetDiagram = (Diagram) context.getTargetContainer();

		// check whether the context has a size (e.g. from a create feature)
		// otherwise define a default size for the shape
		final int width = context.getWidth() <= 0 ? DEFAULT_WIDTH : context
				.getWidth();
		final int height = context.getHeight() <= 0 ? DEFAULT_HEIGHT : context
				.getHeight();

		// some Graphiti Services
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		ContainerShape containerShape = peCreateService.createContainerShape(
				targetDiagram, true);
		IGaService gaService = Graphiti.getGaService();

		// the graphical representation of an Ensemble is made of three parts:
		// the basic rounded rectangle shape, a shape each for the name and the
		// description, and a line separating this parts
		//
		// and emptyEnsemble only needs a basic shape
		if (addedEnsemble instanceof EmptyEnsemble) {
			createBasicEmptyEnsembleShape(addedEnsemble, context,
					containerShape, gaService, width, height);
		} else {
			createBasicEnsembleShape(addedEnsemble, context, containerShape,
					gaService, width, height);
			createSeparationLine(addedEnsemble, peCreateService,
					containerShape, gaService, width);
			createTextShapes(addedEnsemble, targetDiagram, containerShape,
					gaService, peCreateService, width, height);
		}

		// add a chopbox anchor to the shape
		peCreateService.createChopboxAnchor(containerShape);

		layoutPictogramElement(containerShape);

		// setting needed for the collapse feature
		Graphiti.getPeService().setPropertyValue(containerShape, "iscollapsed",
				"false");

		// Get business object (slice) for diagram and add ensemble to it.
		Object businessObject = getBusinessObjectForPictogramElement(getDiagram());
		if (businessObject instanceof Slice) {

			TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
					.getEditingDomain("de.opalproject.vespucci.navigator.domain.DatamodelEditingDomain");

			Slice slice = (Slice) businessObject;

			Command addCommand = AddCommand.create(domain, slice,
					DatamodelPackage.Literals.SLICE__ENSEMBLES, addedEnsemble);

			domain.getCommandStack().execute(addCommand);
		}

		return containerShape;
	}

	private void createBasicEmptyEnsembleShape(Ensemble addedEnsemble,
			IAddContext context, ContainerShape containerShape,
			IGaService gaService, int width, int height) {
		RoundedRectangle roundedRectangle;
		// create and set graphics algorithm
		roundedRectangle = gaService.createRoundedRectangle(containerShape, 5,
				5);

		roundedRectangle.setForeground(manageColor(EMPTY_ENSEMBLE_FOREGROUND));
		roundedRectangle.setBackground(manageColor(EMPTY_ENSEMBLE_BACKGROUND));
		roundedRectangle.setLineWidth(2);
		gaService.setLocationAndSize(roundedRectangle, context.getX(),
				context.getY(), width, height);

		// create link and wire it
		link(containerShape, addedEnsemble);
	}

	private void createBasicEnsembleShape(Ensemble addedEnsemble,
			IAddContext context, ContainerShape containerShape,
			IGaService gaService, int width, int height) {
		RoundedRectangle roundedRectangle;
		// create and set graphics algorithm
		roundedRectangle = gaService.createRoundedRectangle(containerShape, 5,
				5);

		roundedRectangle.setForeground(manageColor(ENSEMBLE_FOREGROUND));
		roundedRectangle.setBackground(manageColor(ENSEMBLE_BACKGROUND));
		roundedRectangle.setLineWidth(2);
		gaService.setLocationAndSize(roundedRectangle, context.getX(),
				context.getY(), width, height);

		// create link and wire it
		link(containerShape, addedEnsemble);
	}

	private void createSeparationLine(Ensemble addedEnsemble,
			IPeCreateService peCreateService, ContainerShape containerShape,
			IGaService gaService, int width) {

		// create shape for line
		Shape lineShape = peCreateService.createShape(containerShape, false);

		// create and set graphics algorithm
		Polyline polyline = gaService.createPolyline(lineShape, new int[] { 0,
				20, width, 20 });
		polyline.setForeground(manageColor(ENSEMBLE_FOREGROUND));
		polyline.setLineWidth(2);
	}

	private void createTextShapes(Ensemble addedEnsemble,
			Diagram targetDiagram, ContainerShape containerShape,
			IGaService gaService, IPeCreateService peCreateService, int width,
			int height) {
		// create shape for name
		Shape nameShape = peCreateService.createShape(containerShape, false);

		// sets the name of the ensemble
		Text name = gaService.createText(nameShape, addedEnsemble.getName());
		name.setForeground(manageColor(ENSEMBLE_TEXT_FOREGROUND));
		name.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT);

		// vertical alignment has as default value "center"
		name.setFont(gaService.manageFont(targetDiagram, "Arial", 10, false,
				true));
		// width is dependent on the intial x coordinate
		gaService.setLocationAndSize(name, 23, 2, (width - 23), 20);

		// create shape for the description
		Shape descriptionShape = peCreateService.createShape(containerShape,
				false);

		// sets the description of the ensemble

		MultiText description = gaService.createMultiText(descriptionShape,
				addedEnsemble.getDescription());

		description.setLineWidth(width);
		description.setVerticalAlignment(Orientation.ALIGNMENT_TOP);
		description.setFont(gaService.manageDefaultFont(getDiagram(), false,
				true));
		gaService.setLocationAndSize(description, 2, 20, width, height);
		// create link and wire it
		link(nameShape, addedEnsemble);
		link(descriptionShape, addedEnsemble);

		// create shape for icon
		Shape iconShape = peCreateService.createShape(containerShape, false);
		Image icon = gaService.createImage(iconShape,
				"de.opalproject.vespucci.sliceEditor.ensembleIcon");
		gaService.setLocationAndSize(icon, 4, 3, 16, 16);
	}

}
