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
package com.slytechs.protocol.pack.web.constants;

import static com.slytechs.protocol.pack.core.constants.PackInfo.*;

import java.util.function.Supplier;

import com.slytechs.protocol.Header;
import com.slytechs.protocol.HeaderExtensionInfo;
import com.slytechs.protocol.HeaderId;
import com.slytechs.protocol.HeaderInfo;
import com.slytechs.protocol.HeaderSupplier;
import com.slytechs.protocol.Other;
import com.slytechs.protocol.pack.core.constants.PackInfo;
import com.slytechs.protocol.pack.web.Html;
import com.slytechs.protocol.pack.web.Http;

/**
 * Core protocol pack. Table of all protocols included in the core protocol
 * pack.
 * 
 * @author Sly Technologies Inc
 * @author repos@slytechs.com
 * @author Mark Bednarczyk
 *
 */
public enum WebHeaderInfo implements HeaderInfo {

	HTTP(Http::new),
	HTML(Html::new),

	;

	// @formatter:off
	public static final int CORE_ID_HTTP    = 0  | PACK_ID_WEB;
	public static final int CORE_ID_HTML    = 1  | PACK_ID_WEB;
	// @formatter:on

	public static WebHeaderInfo valueOf(int id) {
		int pack = HeaderId.decodePackId(id);
		if (pack != PackInfo.PACK_ID_CORE)
			return null;

		int ordinal = HeaderId.decodeIdOrdinal(id);
		return values()[ordinal];
	}

	private final int id;
	private final HeaderSupplier supplier;
	private final Supplier<HeaderExtensionInfo[]> extensionsSupplier;

	WebHeaderInfo() {
		this.id = HeaderId.encodeId(PackInfo.CORE, ordinal());
		this.supplier = Other::new;
		this.extensionsSupplier = () -> HeaderExtensionInfo.EMPTY_ARRAY;
	}

	WebHeaderInfo(HeaderSupplier supplier) {
		this.id = HeaderId.encodeId(PackInfo.CORE, ordinal());
		this.supplier = supplier;
		this.extensionsSupplier = () -> HeaderExtensionInfo.EMPTY_ARRAY;
	}

	WebHeaderInfo(HeaderSupplier supplier, Supplier<HeaderExtensionInfo[]> extensionsSupplier) {
		this.id = HeaderId.encodeId(PackInfo.CORE, ordinal());
		this.supplier = supplier;
		this.extensionsSupplier = extensionsSupplier;
	}

	/**
	 * @see com.slytechs.protocol.HeaderInfo#getExtensionInfos()
	 */
	@Override
	public HeaderExtensionInfo[] getExtensionInfos() {
		return extensionsSupplier.get();
	}

	/**
	 * @see com.slytechs.protocol.HeaderInfo#getHeaderId()
	 */
	@Override
	public int getHeaderId() {
		return id;
	}

	/**
	 * @param decodeId
	 * @return
	 */
	public static WebHeaderInfo toStringId(int id) {
		return values()[HeaderId.decodeIdOrdinal(id)];
	}

	/**
	 * @see com.slytechs.protocol.HeaderSupplier#newHeaderInstance()
	 */
	@Override
	public Header newHeaderInstance() {
		return (supplier != null) ? supplier.newHeaderInstance() : null;
	}

}
