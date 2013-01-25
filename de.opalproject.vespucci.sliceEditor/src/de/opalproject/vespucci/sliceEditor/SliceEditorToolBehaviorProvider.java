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

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDoubleClickContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.platform.IPlatformImageConstants;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IDecorator;
import org.eclipse.graphiti.tb.ImageDecorator;

import de.opalproject.vespucci.datamodel.Ensemble;
import de.opalproject.vespucci.sliceEditor.features.ChangeConstraintDependencyKind;

public class SliceEditorToolBehaviorProvider extends
		DefaultToolBehaviorProvider {

	public SliceEditorToolBehaviorProvider(IDiagramTypeProvider dtp) {
		super(dtp);
	}

	@Override
	public IDecorator[] getDecorators(PictogramElement pe) {
		IFeatureProvider featureProvider = getFeatureProvider();
		Object bo = featureProvider.getBusinessObjectForPictogramElement(pe);

		// check if we're dealing with an instance of Ensemble
		if (bo instanceof Ensemble) {
			Ensemble ensemble = (Ensemble) bo;
			Diagram dia = featureProvider.getDiagramTypeProvider().getDiagram();
			// retrieve possible infringements
			List<Ensemble> childrenOccurrence = checkChildrenOccurrence(dia,
					ensemble);
			List<Ensemble> parentOccurrence = checkParentOccurrence(dia,
					ensemble);
			// mark ensemble if invalid (child already existing in current slice)
			if (childrenOccurrence.size() > 0) {
				IDecorator imageRenderingDecorator = new ImageDecorator(
						IPlatformImageConstants.IMG_ECLIPSE_ERROR_TSK);
				imageRenderingDecorator.setMessage("Slice invalid - "
						+ ensemble.getName() + " is parent of "
						+ childrenOccurrence.get(0).getName());
				generateMarker("child existing", pe, ensemble, childrenOccurrence.get(0), dia);
				return new IDecorator[] { imageRenderingDecorator };
			}
			// mark ensemble if invalid (parent already existing in current slice)
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
	
	@Override
	public ICustomFeature getDoubleClickFeature(IDoubleClickContext context) {
	    ICustomFeature customFeature =
	        new ChangeConstraintDependencyKind(getFeatureProvider());
	    // canExecute() tests especially if the context contains a EClass
	    if (customFeature.canExecute(context)) {
	        return customFeature;
	    }
	 
	    return super.getDoubleClickFeature(context);
	 }

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
		List<Ensemble> workingQueue = ens.getChildren();
		List<Ensemble> childrenList = new ArrayList<Ensemble>();

		// Looking at this ugly loop a method like getAllChildren() might be
		// prettier.
		childrenList.addAll(workingQueue);
		do {
			List<Ensemble> newChildren = new ArrayList<Ensemble>();
			for (Ensemble child : workingQueue) {
				newChildren.addAll(child.getChildren());
			}
			childrenList.addAll(newChildren);
			workingQueue = newChildren;
		} while (workingQueue.size() > 0);

		List<Ensemble> infringingEnsembles = new ArrayList<Ensemble>();

		// check against the list of children whether theyre already in the
		// slice model
		for (Ensemble enmble : childrenList) {
			if (Graphiti.getLinkService().getPictogramElements(dia, enmble)
					.size() > 0) {
				infringingEnsembles.add(enmble);
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
		List<Ensemble> listOfParents = new ArrayList<Ensemble>();
		Ensemble workingEnsemble = ens;
		@SuppressWarnings("unused")
		Ensemble parent;

		// check whether the ensemble is already a toplevel element
		if (ens.getParent() == null) {
			return listOfParents;
		}

		// retrieve possible parents
		do {
			parent = workingEnsemble.getParent();
			listOfParents.add(ens.getParent());
			workingEnsemble = workingEnsemble.getParent();
		} while (!(workingEnsemble.getParent() == null));
		listOfParents.add(workingEnsemble);

		List<Ensemble> infringingEnsembles = new ArrayList<Ensemble>();
		// check against the list of parents whether theyre already in the
		// slice model
		for (Ensemble ensemble : listOfParents) {
			if (Graphiti.getLinkService().getPictogramElements(dia, ensemble)
					.size() > 0) {
				infringingEnsembles.add(ensemble);
				System.out.println("Parent added");
			}
		}
		return infringingEnsembles;
	}
	
	/**
	 * Generate a problem marker when an invalid slice is detected.
	 * 
	 * @param str - String containing the type of infringement
	 * @param picel - Pictogramelement
	 * @param ensA - Ensemble to be added
	 * @param ensB - An already existing conflicting ensembleinstance
	 */
	private void generateMarker(String str, PictogramElement picel, Ensemble ensA,
			Ensemble ensB, Diagram dia) {
		EObject bo = (EObject) getFeatureProvider().getBusinessObjectForPictogramElement(picel);

		try {
			// retrieve URI
			URI uri = EcoreUtil.getURI(bo);
			uri = uri.trimFragment();
			// remove "platform:..." from uri
			if (uri.isPlatform()) {
				uri = URI.createURI(uri.toPlatformString(true));
			}
			IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace()
					.getRoot();

			// try to get project from whole uri resource
			IResource resource = workspaceRoot.findMember(uri.toString());

			// create marker
			IMarker marker = resource.createMarker(IMarker.PROBLEM);
			marker.setAttribute(
					IMarker.MESSAGE,
					str+ "-Slice is invalid "
							+ ensB.toString() + " is a descendant of  "
							+ ensA.toString());
			marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}