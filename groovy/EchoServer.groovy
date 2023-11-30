port = args[0] as int
socket = new ServerSocket(port)
println "listening on $port"

while (true) {
	socket.accept {
		it.withStreams { input, output ->
			// while (true) {
			// 	data = input.read()

			// 	if (data == -1) {
			// 		println "EOF"
			// 		break
			// 	}

			// 	output.write data
			// }
			input.eachByte { output.write it }
			println "EOF"
		}
	}
}