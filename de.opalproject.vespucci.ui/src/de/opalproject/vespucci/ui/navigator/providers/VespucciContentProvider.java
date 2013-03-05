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
package de.opalproject.vespucci.ui.navigator.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;

import de.opalproject.vespucci.datamodel.EnsembleRepository;
import de.opalproject.vespucci.datamodel.SliceRepository;

/**
 * Provides the datamodel content for the navigator
 * 
 * @author Marco Jacobasch
 * 
 */
public class VespucciContentProvider extends
		TransactionalAdapterFactoryContentProvider implements
		ITreeContentProvider {

	private static TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("de.opalproject.vespucci.navigator.domain.DatamodelEditingDomain");

	private static ResourceSet resourceSet = domain.getResourceSet();

	public VespucciContentProvider() {
		super(domain, ProjectAdapterFactoryProvider.getAdapterFactory());
	}

	@Override
	public boolean hasChildren(Object object) {
		if (object instanceof IFile) {
			return true;
		}
		return super.hasChildren(object);
	}

	@Override
	public Object[] getChildren(Object object) {
		if (object instanceof IFile) {
			String path = ((IFile) object).getFullPath().toString();
			URI uri = URI.createPlatformResourceURI(path, true);
			return stripDiagrams(super.getChildren(resourceSet.getResource(uri,
					true)));
		}
		return super.getChildren(object);
	}

	@Override
	public Object getParent(Object object) {
		if (object instanceof IFile) {
			return ((IResource) object).getParent();
		}
		return super.getParent(object);
	}

	@Override
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	/**
	 * Used to strips Diagrams from emf resources.
	 * 
	 * Remove every object which are not an instance of
	 * {@link EnsembleRepository} or {@link SliceRepository}.
	 * 
	 * TODO find a better way to hide the graphiti diagrams
	 * 
	 * @param objects
	 * @return
	 */
	private Object[] stripDiagrams(Object[] objects) {
		List<Object> r = new ArrayList<Object>();

		for (int i = 0; i < objects.length; i++) {
			if (objects[i] instanceof SliceRepository
					|| objects[i] instanceof EnsembleRepository) {
				r.add(objects[i]);
			}
		}

		return r.toArray();
	}

}
