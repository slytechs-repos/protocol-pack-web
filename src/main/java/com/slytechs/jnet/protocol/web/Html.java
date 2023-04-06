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
package com.slytechs.jnet.protocol.web;

import com.slytechs.jnet.protocol.packet.Header;
import com.slytechs.jnet.protocol.packet.meta.Meta;
import com.slytechs.jnet.protocol.web.constants.WebHeaderInfo;

/**
 * @author Sly Technologies Inc
 * @author repos@slytechs.com
 * @author Mark Bednarczyk
 *
 */
@Meta
public class Html extends Header {
	public static final int ID = WebHeaderInfo.CORE_ID_HTML;

	public Html() {
		super(ID);
	}

	/**
	 * @return
	 */
	public char[] text() {
		throw new UnsupportedOperationException("not implemented yet");
	}

}
