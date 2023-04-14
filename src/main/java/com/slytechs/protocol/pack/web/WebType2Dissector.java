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

import java.nio.ByteBuffer;

import com.slytechs.protocol.descriptor.DissectorExtension;
import com.slytechs.protocol.descriptor.PacketDissector.RecordRecorder;

/**
 * Web protocol pack, descriptor type 2 dissector.
 * 
 * @author Sly Technologies Inc
 * @author repos@slytechs.com
 *
 */
class WebType2Dissector implements DissectorExtension {

	/** The recorder. */
	private RecordRecorder recorder;

	/**
	 * Instantiates a new web type 2 dissector.
	 */
	public WebType2Dissector() {
	}

	/**
	 * Dissect ports.
	 *
	 * @param buffer   the buffer
	 * @param offset   the offset
	 * @param encapsId the encaps id
	 * @param src      the src
	 * @param dst      the dst
	 * @return true, if successful
	 * @see com.slytechs.protocol.descriptor.DissectorExtension#dissectPorts(java.nio.ByteBuffer,
	 *      int, int, int, int)
	 */
	@Override
	public boolean dissectPorts(ByteBuffer buffer, int offset, int encapsId, int src, int dst) {

		if (src == 80 || dst == 80) {
			dissectHttp(buffer, offset);

			return true;
		}

		return false;
	}

	/**
	 * Adds the record.
	 *
	 * @param id     the id
	 * @param offset the offset
	 * @param length the length
	 * @return true, if successful
	 */
	private boolean addRecord(int id, int offset, int length) {
		return recorder.addRecord(id, offset, length);
	}

	/**
	 * Dissect http.
	 *
	 * @param buf    the buf
	 * @param offset the offset
	 */
	private void dissectHttp(ByteBuffer buf, int offset) {
		int len = buf.remaining() - offset;

		if (!addRecord(WebIdTable.WEB_ID_HTTP, offset, len))
			return;
	}

	/**
	 * Reset.
	 *
	 * @see com.slytechs.protocol.descriptor.DissectorExtension#reset()
	 */
	@Override
	public void reset() {
	}

	/**
	 * Sets the extensions.
	 *
	 * @param ext the new extensions
	 * @see com.slytechs.protocol.descriptor.DissectorExtension#setExtensions(com.slytechs.protocol.descriptor.DissectorExtension)
	 */
	@Override
	public void setExtensions(DissectorExtension ext) {
	}

	/**
	 * Sets the recorder.
	 *
	 * @param recorder the new recorder
	 * @see com.slytechs.protocol.descriptor.DissectorExtension#setRecorder(com.slytechs.protocol.descriptor.PacketDissector.RecordRecorder)
	 */
	@Override
	public void setRecorder(RecordRecorder recorder) {
		this.recorder = recorder;
	}

}
