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

import java.util.Optional;

import com.slytechs.protocol.HeaderInfo;
import com.slytechs.protocol.descriptor.DissectorExtension;
import com.slytechs.protocol.descriptor.DissectorExtension.DissectorExtensionFactory;
import com.slytechs.protocol.pack.Pack;
import com.slytechs.protocol.pack.PackId;
import com.slytechs.protocol.pack.ProtocolPackTable;
import com.slytechs.protocol.pack.core.constants.PacketDescriptorType;
import com.slytechs.protocol.pack.web.constants.WebIdTable;

/**
 * Protocol pack level information about the protocols in this module.
 * 
 * @author Sly Technologies Inc
 * @author repos@slytechs.com
 */
public final class WebProtocolPack extends Pack<WebIdTable> {

	/**
	 * @see com.slytechs.protocol.pack.Pack#extensionFactory()
	 */
	@Override
	protected DissectorExtensionFactory extensionFactory() {
		return this::newExtension;
	}

	private DissectorExtension newExtension(PacketDescriptorType type) {
		return switch (type) {
		case TYPE2 -> new WebType2Dissector();
		default -> null;
		};
	}

	/** WEB Protocol Pack singleton definition. */
	private static final WebProtocolPack SINGLETON = new WebProtocolPack();

	public static WebProtocolPack singleton() {
		return SINGLETON;
	}

	/**
	 * Pack definitions are designed to be singltons.
	 */
	private WebProtocolPack() {
		super(ProtocolPackTable.WEB, WebIdTable.values());
	}

	/**
	 * @see com.slytechs.protocol.Pack#findHeader(int)
	 */
	@Override
	public Optional<HeaderInfo> findHeader(int id) {
		int packId = PackId.decodePackId(id);
		int hdrOrdinal = PackId.decodeIdOrdinal(id);
		if (packId != ProtocolPackTable.PACK_ID_WEB)
			return Optional.empty();

		var headers = WebIdTable.values();

		if (hdrOrdinal > headers.length)
			return Optional.empty();

		return Optional.of(WebIdTable.values()[hdrOrdinal]);
	}

}
