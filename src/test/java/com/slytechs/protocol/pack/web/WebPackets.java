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
import java.nio.ByteOrder;

import com.slytechs.protocol.Packet;
import com.slytechs.protocol.runtime.util.HexStrings;

/**
 * Various hex packets used in testing.
 * 
 * @author Sly Technologies Inc
 * @author repos@slytechs.com
 * @author Mark Bednarczyk
 *
 */
public enum WebPackets {

	/**
	 * 192.168.1.140 174.143.213.184 HTTP 200 GET /images/layout/logo.png HTTP/1.0
	 * 
	 * <pre>
	Frame 4: 200 bytes on wire (1600 bits), 200 bytes captured (1600 bits)
	Ethernet II, Src: ASUSTekC_b3:01:84 (00:1d:60:b3:01:84), Dst: Actionte_2f:47:87 (00:26:62:2f:47:87)
	    Destination: Actionte_2f:47:87 (00:26:62:2f:47:87)
	    Source: ASUSTekC_b3:01:84 (00:1d:60:b3:01:84)
	    Type: IPv4 (0x0800)
	Internet Protocol Version 4, Src: 192.168.1.140, Dst: 174.143.213.184
	    0100 .... = Version: 4
	    .... 0101 = Header Length: 20 bytes (5)
	    Differentiated Services Field: 0x00 (DSCP: CS0, ECN: Not-ECT)
	    Total Length: 186
	    Identification: 0xcb5d (52061)
	    010. .... = Flags: 0x2, Don't fragment
	    ...0 0000 0000 0000 = Fragment Offset: 0
	    Time to Live: 64
	    Protocol: TCP (6)
	    Header Checksum: 0x2864 [validation disabled]
	    [Header checksum status: Unverified]
	    Source Address: 192.168.1.140
	    Destination Address: 174.143.213.184
	Transmission Control Protocol, Src Port: 57678 (57678), Dst Port: http (80), Seq: 1, Ack: 1, Len: 134
	    Source Port: 57678 (57678)
	    Destination Port: http (80)
	    [Stream index: 0]
	    [Conversation completeness: Complete, WITH_DATA (31)]
	    [TCP Segment Len: 134]
	    Sequence Number: 1    (relative sequence number)
	    Sequence Number (raw): 2387613954
	    [Next Sequence Number: 135    (relative sequence number)]
	    Acknowledgment Number: 1    (relative ack number)
	    Acknowledgment number (raw): 3344080265
	    1000 .... = Header Length: 32 bytes (8)
	    Flags: 0x018 (PSH, ACK)
	    Window: 46
	    [Calculated window size: 5888]
	    [Window size scaling factor: 128]
	    Checksum: 0x4729 [unverified]
	    [Checksum Status: Unverified]
	    Urgent Pointer: 0
	    Options: (12 bytes), No-Operation (NOP), No-Operation (NOP), Timestamps
	    [Timestamps]
	    [SEQ/ACK analysis]
	    TCP payload (134 bytes)
	Hypertext Transfer Protocol
	    GET /images/layout/logo.png HTTP/1.0\r\n
	    User-Agent: Wget/1.12 (linux-gnu)\r\n
	    Accept:\r\n
	    Host: packetlife.net\r\n
	    Connection: Keep-Alive\r\n
	    \r\n
	    [Full request URI: http://packetlife.net/images/layout/logo.png]
	    [HTTP request 1/1]
	    [Response in frame: 36]
	 * </pre>
	 */
	ETH_IPv4_TCP_HTTP(""
			+ "0026622f4787001d60b301840800"
			+ "450000bacb5d400040062864c0a8018cae8fd5b8"
			+ "e14e00508e501902c7529d898018002e472900000101080a0021d25f31c7ba48"
			+ "474554202f696d616765732f6c61796f75742f6c6f676f2e706e6720485454502f312e300d0a557365722d4167656e743a20576765742f312e313220286c696e75782d676e75290d0a4163636570743a202a2f2a0d0a486f73743a207061636b65746c6966652e6e65740d0a436f6e6e656374696f6e3a204b6565702d416c6976650d0a0d0a"),

	;

	/** The array. */
	private final byte[] array;

	/**
	 * Instantiates a new packet definition.
	 *
	 * @param hexbytes the hexbytes
	 */
	WebPackets(String hexbytes) {
		this.array = HexStrings.parseHexString(hexbytes);
	}

	/**
	 * To array.
	 *
	 * @return the byte[]
	 */
	public byte[] toArray() {
		return array;
	}

	/**
	 * To byte buffer.
	 *
	 * @return the byte buffer
	 */
	public ByteBuffer toByteBuffer() {
		return ByteBuffer.wrap(array).order(ByteOrder.BIG_ENDIAN);
	}

	/**
	 * To packet.
	 *
	 * @return the packet
	 */
	public Packet toPacket() {
		var packet = new Packet(toByteBuffer());

		return packet;
	}

}
