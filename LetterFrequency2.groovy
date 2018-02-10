def freq = new File(args[0]).text.replaceAll("\\s", "").inject([:]) { map, c ->
	map[c] = (map[c] == null ? 0 : map[c]) + 1
	map
}

println freq