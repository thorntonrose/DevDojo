def freq = new File(args[0]).text.replaceAll("\\s", "").inject([:]) { map, c ->
	map[c] = (map[c] ?: 0) + 1
	map
}

println freq
