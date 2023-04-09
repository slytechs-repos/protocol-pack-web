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

import com.slytechs.protocol.HeaderInfo;
import com.slytechs.protocol.HeaderNotFound;
import com.slytechs.protocol.pack.Pack;
import com.slytechs.protocol.pack.PackId;
import com.slytechs.protocol.pack.DeclaredPackIds;
import com.slytechs.protocol.pack.web.constants.WebPackIds;

/**
 * @author Sly Technologies Inc
 * @author repos@slytechs.com
 * @author Mark Bednarczyk
 *
 */
public final class WebPack extends Pack<WebPackIds> {

	/** Core Protocol Pack singleton definition. */
	private static final WebPack SINGLETON = new WebPack();

	public static WebPack singleton() {
		return SINGLETON;
	}

	/**
	 * Pack definitions are designed to be singltons.
	 */
	private WebPack() {
		super(DeclaredPackIds.WEB, WebPackIds.values());
	}

	/**
	 * @see com.slytechs.protocol.Pack#getHeader(int)
	 */
	@Override
	public HeaderInfo getHeader(int id) throws HeaderNotFound {
		int packId = PackId.decodePackId(id);
		int hdrOrdinal = PackId.decodeIdOrdinal(id);
		if (packId != DeclaredPackIds.PACK_ID_CORE)
			throw new HeaderNotFound("invalid pack id [%d] not applicable to [%s] pack"
					.formatted(packId, super.getPackName()));

		var headers = WebPackIds.values();

		if (hdrOrdinal > headers.length)
			throw new HeaderNotFound("header id [%d] in [%s] pack"
					.formatted(id, super.getPackName()));

		return WebPackIds.values()[hdrOrdinal];
	}

}
