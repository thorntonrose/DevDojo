def flatten(Map src, Map dest, String prefix = "") {
	src.each { key, val ->
		if (val instanceof Map) {
			flatten(src, dest, "$key.")
		} else {
			dest[key] = val
		}
	}

	return dest
}

println flatten([a: 1], [:])