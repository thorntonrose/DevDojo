def freq = args.join("").inject([:]) { map, c ->
	//if (map[c] == null) { map[c] = 1 }
	//else { map[c] ++ }
	map[c] = (map[c] == null ? 0 : map[c]) + 1
	return map
}

println freq