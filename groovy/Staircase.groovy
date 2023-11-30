if (args.size() == 0) {
	println "usage: Staircase <height>"
} else {
	def stairs = args[0] as int

	stairs.times { n ->
		println(("#" * (n + 1)).padLeft(stairs, " "))
	}
}