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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Domenico Barra - eisenach@gmail.com
 */
public class Payload {

    byte[] payload;

    public Payload(byte[] payload) {
        set(payload);
    }

    public Payload(InputStream payload) throws IOException {
        set(payload);
    }

    public void set(byte[] payload) {
        this.payload = payload;
    }

    public void set(InputStream is) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream(is.available());
        byte[] buffer = new byte[1024];
        int c;
        while ((c = is.read(buffer)) != -1) {
            os.write(buffer, 0, c);
        }
    }

    public byte[] get() { return payload; }

}
