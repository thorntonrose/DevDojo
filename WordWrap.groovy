if (args.length < 2) {
	println "usage: groovy WordWrap <line-length> <file>"
} else {
	println wrap(new File(args[1]).text, args[0] as int)
}

def wrap(text, lineLength) {
	def lines = []
	//def line = ""
	def line = new StringBuilder()

	text.split("\\s+").each { word ->
		if (line.size() + word.size() + 1 < lineLength) {
			//line += (line ? " " : "") + word
			line.append(line.size() > 0 ? " " : "").append(word)
		} else {
			//lines << line
			//line = ""
			lines << line.toString()
			line = new StringBuilder().append(word)
		}
	}

	lines << line.toString()

	return lines.join("\n")
}