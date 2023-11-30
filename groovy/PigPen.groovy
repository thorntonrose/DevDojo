if (args.size() < 1) {
	println "usage: PigPen <word>"
	return
}

cipher = [:]
symbol = ""

new File("PigPenAlpha.txt").text.eachLine { line ->
	if (line.startsWith("~")) {
		cipher[line[1]] = symbol
		symbol = ""
	} else {
		symbol += line + "\n"
	}
}

//cipher.each { key, val -> val.eachLine { println it } }
symbols = args[0].toUpperCase().inject([]) { list, letter -> list << cipher[letter] }
//println symbols

4.times { n ->
	symbols.each { print(it.split("\n")[n] + " ") }
	println ""
}