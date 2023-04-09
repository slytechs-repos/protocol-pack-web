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

import static com.slytechs.protocol.pack.ProtocolPackTable.*;

import java.util.function.Supplier;

import com.slytechs.protocol.Header;
import com.slytechs.protocol.HeaderExtensionInfo;
import com.slytechs.protocol.HeaderInfo;
import com.slytechs.protocol.HeaderSupplier;
import com.slytechs.protocol.Other;
import com.slytechs.protocol.pack.PackId;
import com.slytechs.protocol.pack.ProtocolPackTable;
import com.slytechs.protocol.pack.web.Html;
import com.slytechs.protocol.pack.web.Http;

/**
 * Web protocol pack. Table of all protocols included in the web protocol pack.
 * 
 * @author Sly Technologies Inc
 * @author repos@slytechs.com
 *
 */
public enum WebIdTable implements HeaderInfo, PackId {

	PACK(),
	HTTP(Http::new),
	HTML(Html::new),

	;

	// @formatter:off
	public static final int WEB_ID_PACK    = 0  | PACK_ID_WEB;
	public static final int WEB_ID_HTTP    = 1  | PACK_ID_WEB;
	public static final int WEB_ID_HTML    = 2  | PACK_ID_WEB;
	// @formatter:on

	public static WebIdTable valueOf(int id) {
		int pack = PackId.decodePackId(id);
		if (pack != ProtocolPackTable.PACK_ID_CORE)
			return null;

		int ordinal = PackId.decodeIdOrdinal(id);
		return values()[ordinal];
	}

	private final int id;
	private final HeaderSupplier supplier;
	private final Supplier<HeaderExtensionInfo[]> extensionsSupplier;

	WebIdTable() {
		this.id = PackId.encodeId(ProtocolPackTable.CORE, ordinal());
		this.supplier = Other::new;
		this.extensionsSupplier = () -> HeaderExtensionInfo.EMPTY_ARRAY;
	}

	WebIdTable(HeaderSupplier supplier) {
		this.id = PackId.encodeId(ProtocolPackTable.CORE, ordinal());
		this.supplier = supplier;
		this.extensionsSupplier = () -> HeaderExtensionInfo.EMPTY_ARRAY;
	}

	WebIdTable(HeaderSupplier supplier, Supplier<HeaderExtensionInfo[]> extensionsSupplier) {
		this.id = PackId.encodeId(ProtocolPackTable.CORE, ordinal());
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
	 * @see com.slytechs.protocol.HeaderInfo#id()
	 */
	@Override
	public int id() {
		return id;
	}

	/**
	 * @param decodeId
	 * @return
	 */
	public static WebIdTable toStringId(int id) {
		return values()[PackId.decodeIdOrdinal(id)];
	}

	/**
	 * @see com.slytechs.protocol.HeaderSupplier#newHeaderInstance()
	 */
	@Override
	public Header newHeaderInstance() {
		return (supplier != null) ? supplier.newHeaderInstance() : null;
	}

}
