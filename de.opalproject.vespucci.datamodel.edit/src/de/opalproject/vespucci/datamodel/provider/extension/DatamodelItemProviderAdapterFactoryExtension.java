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
package de.opalproject.vespucci.datamodel.provider.extension;

import org.eclipse.emf.common.notify.Adapter;

import de.opalproject.vespucci.datamodel.provider.DatamodelItemProviderAdapterFactory;

/**
 * Custom extension of the {@link DatamodelItemProviderAdapterFactory} of the
 * generated emf.edit code
 * 
 * Used to not touch the generated code, instead subclass it an override the
 * needed methods
 * 
 * @author Marco Jacobasch
 * 
 */
public class DatamodelItemProviderAdapterFactoryExtension extends
		DatamodelItemProviderAdapterFactory {

	/**
	 * Override the ConcreteEnsembleItemProvider with our custom extension
	 */
	@Override
	public Adapter createConcreteEnsembleAdapter() {
		if (concreteEnsembleItemProvider == null) {
			concreteEnsembleItemProvider = new ConcreteEnsembleItemProviderExtension(
					this);
		}

		return concreteEnsembleItemProvider;
	}

	/**
	 * Override the SliceItemProvider with our custom extension
	 */
	@Override
	public Adapter createSliceAdapter() {
		if (sliceItemProvider == null) {
			sliceItemProvider = new SliceItemProviderExtension(this);
		}

		return sliceItemProvider;
	}
}
