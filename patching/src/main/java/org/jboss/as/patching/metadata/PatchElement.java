/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2012, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.as.patching.metadata;

import java.util.Collection;


/**
 * @author Alexey Loubyansky
 *
 */
public interface PatchElement {

    /**
     * Patch element identifier.
     *
     * @return  patch element identifier
     */
    String getId();

    /**
     * The description of the patch element.
     *
     * @return  description of the patch element
     */
    String getDescription();

    /**
     * The provider of the patch element.
     *
     * @return  provider of the patch element
     */
    PatchElementProvider getProvider();

    /**
     * Get the patch type.
     *
     * @return the type of the patch
     */
    Patch.PatchType getPatchType();

    /**
     * Get the resulting version of a CP or {@code null} for a one-off patch
     *
     * @return the resulting version
     */
    String getResultingVersion();

    /**
     * Get a list of patch-ids, this patch is incompatible with.
     *
     * @return a list of incompatible patches
     */
    Collection<String> getIncompatibleWith();

    /**
     * Get the content modifications.
     *
     * @return the modifications
     */
    Collection<ContentModification> getModifications();
}