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

import java.io.Serializable;

/**
 * @author Domenico Barra - eisenach@gmail.com
 */
public abstract class BaseDescriptor implements Serializable {

    private String name;
    private Payload payload = null;
    private Visibility visibility = defaultVisibility();

    public BaseDescriptor(String name) {
        this.name = name;
    }


    public String getName() { return name; }

    public final boolean hasPayload() {
        return payload != null;
    }

    public final void setPayload(Payload payload) {
        this.payload = payload;
    }

    public Payload getPayload() {
        return payload;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    /**
     * This method should be overridden by subclasses in order to return
     * a reasonable default visibility qualifier. As of now, general
     * default visibility is {@link Visibility#PUBLIC}.
     * @return the default visibility qualifier for the current descriptor type
     */
    public Visibility defaultVisibility() {
        return Visibility.PUBLIC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseDescriptor that = (BaseDescriptor) o;
        if (!name.equals(that.name)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
