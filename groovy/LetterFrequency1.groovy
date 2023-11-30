def freq = args.join("").inject([:]) { map, c ->
	//if (map[c] == null) { map[c] = 1 } else { map[c] ++ }
	map[c] = (map[c] ?: 0) + 1
	map
}

println freq
