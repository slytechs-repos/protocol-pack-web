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
package com.slytechs.jnet.protocol.web;

import com.slytechs.jnet.protocol.Header;
import com.slytechs.jnet.protocol.meta.Meta;
import com.slytechs.jnet.protocol.web.constants.WebIdTable;

/**
 * Hypertext Transfer Protocol (HTTP).
 * 
 * @author Sly Technologies Inc
 * @author repos@slytechs.com
 */
@Meta
public final class Http extends Header {
	
	/** The Constant ID. */
	public static final int ID = WebIdTable.WEB_ID_HTTP;

	/**
	 * Instantiates a new http.
	 */
	public Http() {
		super(ID);
	}

	/**
	 * Checks if is dechunked.
	 *
	 * @return true, if is dechunked
	 */
	public boolean isDechunked() {
		return false;
	}

	/**
	 * Dechunked data.
	 *
	 * @return the char[]
	 */
	public char[] dechunkedData() {
		throw new UnsupportedOperationException("not implemented yet");
	}

	/**
	 * Checks if is decompressed.
	 *
	 * @return true, if is decompressed
	 */
	public boolean isDecompressed() {
		return false;
	}

	/**
	 * Decompressed data.
	 *
	 * @return the char[]
	 */
	public char[] decompressedData() {
		throw new UnsupportedOperationException("not implemented yet");
	}

}
