host = args[0]
port = args[1] as int
outData = args[2]

new Socket(host, port).withStreams { input, output ->
	outData.bytes.each { b ->
		output.write b
		inData = input.read()
		if (inData == -1) { throw new Exception("EOF") }
		print new String(inData as byte)
	}
}