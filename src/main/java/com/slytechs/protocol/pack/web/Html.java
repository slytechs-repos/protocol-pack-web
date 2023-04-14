/*
 * Sly Technologies Free License
 * 
 * Copyright 2023 Sly Technologies Inc.
 *
 * Licensed under the Sly Technologies Free License (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.slytechs.com/free-license-text
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.slytechs.protocol.pack.web;

import java.nio.charset.StandardCharsets;

import com.slytechs.protocol.Header;
import com.slytechs.protocol.meta.Meta;
import com.slytechs.protocol.pack.web.constants.WebIdTable;

/**
 * Hypertext Markup Language (HTML).
 *
 * @author Sly Technologies Inc
 * @author repos@slytechs.com
 */
@Meta
public final class Html extends Header {

	/** Html header ID. */
	public static final int ID = WebIdTable.WEB_ID_HTML;

	/**
	 * Instantiates a new html.
	 */
	public Html() {
		super(ID);
	}

	/**
	 * The contents of the html.
	 *
	 * @return the char[]
	 */
	public char[] text() {
		byte[] array = new byte[headerLength()];

		return new String(array, StandardCharsets.UTF_8)
				.toCharArray();
	}

}
