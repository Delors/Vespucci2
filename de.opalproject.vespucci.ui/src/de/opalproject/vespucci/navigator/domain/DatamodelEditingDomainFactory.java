/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: EXTLibraryEditingDomainFactory.java,v 1.5 2007/11/14 18:13:57 cdamus Exp $
 */
package de.opalproject.vespucci.navigator.domain;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.WorkspaceEditingDomainFactory;

/**
 * @author Marco Jacobasch
 */
public class DatamodelEditingDomainFactory implements
		TransactionalEditingDomain.Factory {

	public TransactionalEditingDomain createEditingDomain() {
		TransactionalEditingDomain result = WorkspaceEditingDomainFactory.INSTANCE
				.createEditingDomain();
		return result;
	}

	public TransactionalEditingDomain createEditingDomain(ResourceSet rset) {
		// not used when initializing editing domain from extension point
		return null;
	}

	public TransactionalEditingDomain getEditingDomain(ResourceSet rset) {
		// not used when initializing editing domain from extension point
		return null;
	}

}
