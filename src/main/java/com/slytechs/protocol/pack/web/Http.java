/*
 * Apache License, Version 2.0
 * 
 * Copyright 2013-2022 Sly Technologies Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *   
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.slytechs.protocol.pack.web;

import com.slytechs.protocol.Header;
import com.slytechs.protocol.meta.Meta;
import com.slytechs.protocol.pack.web.constants.WebIdTable;

/**
 * Hypertext Transfer Protocol (HTTP).
 * 
 * @author Sly Technologies Inc
 * @author repos@slytechs.com
 */
@Meta
public final class Http extends Header {
	public static final int ID = WebIdTable.WEB_ID_HTTP;

	public Http() {
		super(ID);
	}

	/**
	 * @return
	 */
	public boolean isDechunked() {
		return false;
	}

	/**
	 * @return
	 */
	public char[] dechunkedData() {
		throw new UnsupportedOperationException("not implemented yet");
	}

	/**
	 * @return
	 */
	public boolean isDecompressed() {
		throw new UnsupportedOperationException("not implemented yet");
	}

	/**
	 * @return
	 */
	public char[] decompressedData() {
		throw new UnsupportedOperationException("not implemented yet");
	}

}
