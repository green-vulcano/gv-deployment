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

import java.util.StringTokenizer;

/**
 * @author Domenico Barra - eisenach@gmail.com
 */
public class Version {

    public static final Version MODEL_VERSION = new Version("4.0");
    public static final String SEPARATOR = ".";

    public Version(String ver) {
        split(ver); // acts as an input parameter validator
        this.ver = ver;
    }

    public String get() { return ver; }


    public static int compare(Version left, Version right) {
        return compare(left.get(), right.get());
    }

    /**
     * Compares two version numbers. Format is: digits separated by dot.
     * Examples are: 3, 3.2, 3.2.4, 5.11.3.5
     * @param left the first version number to compare
     * @param right the second version number to compare
     * @return a negative integer if <code>left > right</code>,
     *         <code>0</code> if the two versions are equal,
     *         a positive integer if <code>right > left</code>
     */
    public static int compare(String left, String right) {
        int[] lefts = split(left);
        int[] rights = split(right);
        int max = Math.min(lefts.length, rights.length);
        for (int i=0; i < max; i++) {
            int result = rights[i] - lefts[i];
            if (result != 0) return result;
        }
        return right.length() - left.length();
    }

    private static int[] split(String version) {
        StringTokenizer st = new StringTokenizer(version, SEPARATOR);
        int[] tokens = new int[st.countTokens()];
        int i = 0;
        try {
            while (st.hasMoreTokens()) {
                tokens[i++] = Integer.parseInt(st.nextToken());
            }
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Version " + version +
                    " does not conform to versioning standard.");
        }
        return tokens;
    }

    private String ver;

}
