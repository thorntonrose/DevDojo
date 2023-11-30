def cli = new CliBuilder(usage: "groovy WordWrap2 <options>")
cli.l args: 1, argName: "number", required: true, "line length"
cli.f args: 1, argName: "name", required: true, "file"

def opts = cli.parse(args)
if (! opts) { return }

println wrap(new File(opts.f).text, opts.l as int)

def wrap(text, lineLength) {
	def lines = []
	//def line = ""
	def line = new StringBuilder()

	text.split("\\s+").each { word ->
		if (line.size() + word.size() < lineLength) {
			//line += (line ? " " : "") + word
			line.append(line.size() > 0 ? " " : "").append(word)
		} else {
			lines << line.toString()
			line = new StringBuilder()
		}
	}

	return lines.join("\n")
}