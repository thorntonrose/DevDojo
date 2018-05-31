if (args.size() < 3) {
	println "usage: Triangle <int> <int> <int>"
} else {
	(a, b, c) = args.collect { it as int }
	println a + b > c && a + c > b && c + b > a
}