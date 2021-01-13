def flatten(Map src, Map dest=[:], String parentKey="") {
	src.each { key, val ->
		key = [parentKey, key].findAll().join(".")
		// if (val instanceof Map) { flatten(val, dest, key) } else { dest[key] = val }
		val instanceof Map ? flatten(val, dest, key) : (dest[key] = val)
	}

	dest
}

println flatten([a: 1])
println flatten([a: 1, b: [c: 2]])
println flatten([a: 1, b: [c: [d: 3]]])
println flatten([a: 1, b: [c: [d: 2]], e: 3])
