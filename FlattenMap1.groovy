def flatten(Map src, String parentKey="") {
	def dest = [:]

	src.each { key, val ->
		key = [parentKey, key].findAll().join(".")
		dest += val instanceof Map ? flatten(val, key) : [(key): val]
	}

	dest
}

println flatten([a: 1])
println flatten([a: 1, b: [c: 2]])
println flatten([a: 1, b: [c: [d: 3]]])
println flatten([a: 1, b: [c: [d: 2]], e: 3])
