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

import static org.junit.Assert.*;

/**
 * @author Domenico Barra - eisenach@gmail.com
 */
public class VersionTest {

    @org.junit.Test
    public void testCompare() throws Exception {
        assertEquals(0, Version.compare(new Version("4.0.0"), new Version("4.0.0")));
        assertTrue(Version.compare(new Version("4.0.0"), new Version("4.0.1")) > 0);
        assertTrue(Version.compare(new Version("4.0.0.5"), new Version("4.0.1")) > 0);
    }

}