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
package de.opalproject.vespucci.sliceEditor;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.platform.IPlatformImageConstants;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.tb.ContextEntryHelper;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IContextButtonEntry;
import org.eclipse.graphiti.tb.IContextButtonPadData;
import org.eclipse.graphiti.tb.IDecorator;
import org.eclipse.graphiti.tb.ImageDecorator;
import de.opalproject.vespucci.datamodel.Ensemble;
import de.opalproject.vespucci.datamodel.EnsembleRepository;
import de.opalproject.vespucci.datamodel.Slice;
import de.opalproject.vespucci.datamodel.util.DatamodelValidator;
import de.opalproject.vespucci.sliceEditor.features.CollapseFeature;

/**
 * @author marius
 * 
 */
public class SliceEditorToolBehaviorProvider extends
		DefaultToolBehaviorProvider {

	/**
	 * @param dtp
	 */
	public SliceEditorToolBehaviorProvider(IDiagramTypeProvider dtp) {
		super(dtp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.graphiti.tb.DefaultToolBehaviorProvider#getDecorators(org
	 * .eclipse.graphiti.mm.pictograms.PictogramElement)
	 */
	@Override
	public IDecorator[] getDecorators(PictogramElement pe) {
		IFeatureProvider featureProvider = getFeatureProvider();
		Object bo = featureProvider.getBusinessObjectForPictogramElement(pe);

		// check if we're dealing with an instance of Ensemble
		if (bo instanceof Ensemble) {
			Ensemble ensemble = (Ensemble) bo;
			Diagram dia = featureProvider.getDiagramTypeProvider().getDiagram();
			Slice slice = null;
			
			// validator call, retrieve slice
			for (EObject eObject : dia.getLink().getBusinessObjects()) {
				if (eObject instanceof Slice) {
					slice = (Slice) eObject;
					break;
				}
			}

			// check validator
			DatamodelValidator.validateObject(slice);
			
			
			// retrieve possible graphical infringements
			List<Ensemble> childrenOccurrence = checkChildrenOccurrence(dia,
					ensemble);
			List<Ensemble> parentOccurrence = checkParentOccurrence(dia,
					ensemble);
			// mark ensemble if invalid (child already existing in current
			// slice)
			if (childrenOccurrence.size() > 0) {
				IDecorator imageRenderingDecorator = new ImageDecorator(
						IPlatformImageConstants.IMG_ECLIPSE_ERROR_TSK);
				imageRenderingDecorator.setMessage("Slice invalid - "
						+ ensemble.getName() + " is parent of "
						+ childrenOccurrence.get(0).getName());
				return new IDecorator[] { imageRenderingDecorator };
			}
			// mark ensemble if invalid (parent already existing in current
			// slice)
			if (parentOccurrence.size() > 0) {
				IDecorator imageRenderingDecorator = new ImageDecorator(
						IPlatformImageConstants.IMG_ECLIPSE_ERROR_TSK);
				imageRenderingDecorator.setMessage("Slice invalid - "
						+ ensemble.getName() + " is derived from "
						+ parentOccurrence.get(0).getName());
				return new IDecorator[] { imageRenderingDecorator };
			}
		}

		return super.getDecorators(pe);
	}

	// @Override
	// public ICustomFeature getDoubleClickFeature(IDoubleClickContext context)
	// {
	// ICustomFeature customFeature =
	// new ChangeConstraintDependencyKind(getFeatureProvider());
	// // canExecute() tests especially if the context contains a EClass
	// if (customFeature.canExecute(context)) {
	// return customFeature;
	// }
	//
	// return super.getDoubleClickFeature(context);
	// }

	/**
	 * Detects if there are instances of children of the ensemble to be added.
	 * 
	 * @param dia
	 *            - the target Diagram
	 * @param ens
	 *            - the ensemble to be added
	 * @return List of infringing ensembles(instances of children)
	 */
	private List<Ensemble> checkChildrenOccurrence(Diagram dia, Ensemble ens) {
		List<Ensemble> infringingEnsembles = new ArrayList<Ensemble>();
		TreeIterator<EObject> it = ens.eAllContents();

		while (it.hasNext()) {
			EObject next = it.next();
			if (next instanceof Ensemble
					&& Graphiti.getLinkService()
							.getPictogramElements(dia, next).size() > 0) {
				infringingEnsembles.add((Ensemble) next);
			}
		}

		return infringingEnsembles;
	}

	/**
	 * Detects already existing parent instances of the ensemble to be added.
	 * 
	 * @param dia
	 *            - the target Diagram
	 * @param ens
	 *            - the ensemble to be added
	 * @return List of infringing ensembles(instances of parents)
	 */
	private List<Ensemble> checkParentOccurrence(Diagram dia, Ensemble ens) {
		List<Ensemble> infringingEnsembles = new ArrayList<Ensemble>();

		while (!(ens.getParent() instanceof EnsembleRepository)
				&& ens.getParent() instanceof Ensemble) {
			ens = (Ensemble) ens.getParent();
			if (Graphiti.getLinkService().getPictogramElements(dia, ens).size() > 0) {
				infringingEnsembles.add(ens);
			}
		}

		return infringingEnsembles;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.tb.DefaultToolBehaviorProvider#getContextButtonPad(org.eclipse.graphiti.features.context.IPictogramElementContext)
	 */
	@Override
	public IContextButtonPadData getContextButtonPad(
			IPictogramElementContext context) {
		IContextButtonPadData data = super.getContextButtonPad(context);
		PictogramElement pe = context.getPictogramElement();

		// set the generic context buttons
		setGenericContextButtons(data, pe, CONTEXT_BUTTON_REMOVE);

		// set the collapse button
		CustomContext cc = new CustomContext(new PictogramElement[] { pe });
		ICustomFeature[] cf = getFeatureProvider().getCustomFeatures(cc);
		for (int i = 0; i < cf.length; i++) {
			ICustomFeature iCustomFeature = cf[i];
			if (iCustomFeature instanceof CollapseFeature) {
				IContextButtonEntry collapseButton = ContextEntryHelper
						.createCollapseContextButton(true, iCustomFeature, cc);
				data.setCollapseContextButton(collapseButton);
				break;
			}
		}

		return data;
	}

}