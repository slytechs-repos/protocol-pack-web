# Web Protocol Pack
Web Protocol Pack consisting of numerous WEB based protocols and services.

### Latest status - [Pull Request #1](https://github.com/slytechs-repos/web-protocols/pull/1)
The module is currently almost ready for initial API delopment. Please see [pull #1](https://github.com/slytechs-repos/web-protocols/pull/1) for the latest status.

## Where to use this module
This module, **web-protocols** is an extension module which provides protocol level support for one of the main public APIs. You need to setup your application using either **jnetpcap-pro** or **jnetwork** modules which provide the main APIs for building applications using any of the protocol packs. In addition, you also need to include the **core-protocols** module as all protocol modules require its runtime and base protocol level support.

## What's inside
The **web-protocols** module jprovides support for the following services:
- HTTP protocol
  - Dechunking
  - Decompression
- TLS support
  - Decryption and encryption
- Small set of CODECS for HTTP data content type being transported
  - You can find specialized codes such as many different codes for voice and video in the **video-protocols** module
- QUIC protocol

### Protocol Table
Here is a table of all of the protocol definitions provided by this **core-protocols** module.

| Protocols | In-headers | Modes |
|-----------|------------|-------|
|HTTP       |GET/HEAD/POST/PUT/DELETE/CONNECT/OPTIONS/TRACE/PATCH | REQUEST/RESPONSE/REPRESENTATION/PAYLOAD |
|QUIC       |STREAMS/CRYPTO/TRANSPORT ||
|HTML       |                | |
|TLS        |ENCRYPTION | DECRYPTION |
