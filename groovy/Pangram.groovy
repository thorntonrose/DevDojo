if (args.size() < 1) {
	println "usage: Pangram <sentence>"
} else {
	println args[0].toLowerCase().toSet().sort().join().contains("abcdefghijklmnopqrstuvwxyz")
}