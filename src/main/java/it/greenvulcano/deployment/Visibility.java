/*
 * Copyright (c) 2016, GreenVulcano Open Source Project. All rights reserved.
 *
 * This file is part of the GreenVulcano Integration Platform.
 *
 * This is free software: you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 *
 * This software is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this software. If not, see <http://www.gnu.org/licenses/>.
 */

package it.greenvulcano.deployment;

/**
 * Class to represent the visibility of resources within a
 * GreenVulcano deployment unit.
 * @author Domenico Barra - eisenach@gmail.com
 */
public enum Visibility {
    /**
     * Resources having this visibility level are not meant to
     * be visible outside of the deployment unit, so other
     * deployment units will not be able to access them.
     */
    PRIVATE,

    /**
     * Resources having this visibility level are not meant to
     * be exposed to the public (i.e. service consumers), but can
     * be referenced from other deployment units and used within
     * other services published on the same platform.
     */
    PROTECTED,

    /**
     * Resources having this visibility level can be used by anyone,
     * including external service consumers. I.e.: services exposed
     * by the bus for external access via any protocol (REST, TCP, ...)
     * must be <code>PUBLIC</code>.
     */
    PUBLIC;
}
