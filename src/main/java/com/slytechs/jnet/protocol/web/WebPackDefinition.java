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

import java.util.Optional;

import com.slytechs.jnet.protocol.HeaderInfo;
import com.slytechs.jnet.protocol.core.constants.PacketDescriptorType;
import com.slytechs.jnet.protocol.descriptor.PacketDissectorExtension;
import com.slytechs.jnet.protocol.descriptor.PacketDissectorExtension.DissectorExtensionFactory;
import com.slytechs.jnet.protocol.pack.Pack;
import com.slytechs.jnet.protocol.pack.PackId;
import com.slytechs.jnet.protocol.pack.ProtocolPackTable;
import com.slytechs.jnet.protocol.web.constants.WebIdTable;

/**
 * Protocol pack level information about the protocols in this module.
 * 
 * @author Sly Technologies Inc
 * @author repos@slytechs.com
 */
public final class WebPackDefinition extends Pack<WebIdTable> {

	/**
	 * Extension factory.
	 *
	 * @return the dissector extension factory
	 * @see com.slytechs.jnet.protocol.pack.Pack#extensionFactory()
	 */
	@Override
	protected DissectorExtensionFactory extensionFactory() {
		return this::newExtension;
	}

	/**
	 * New extension.
	 *
	 * @param type the type
	 * @return the dissector extension
	 */
	private PacketDissectorExtension newExtension(PacketDescriptorType type) {
		return switch (type) {
		case TYPE2 -> new WebType2Dissector();
		default -> null;
		};
	}

	/** WEB Protocol Pack singleton definition. */
	private static final WebPackDefinition SINGLETON = new WebPackDefinition();

	/**
	 * Singleton.
	 *
	 * @return the web protocol pack
	 */
	public static WebPackDefinition singleton() {
		return SINGLETON;
	}

	/**
	 * Pack definitions are designed to be singltons.
	 */
	private WebPackDefinition() {
		super(ProtocolPackTable.WEB, WebIdTable.values());
	}

	/**
	 * Find header.
	 *
	 * @param id the id
	 * @return the optional
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
