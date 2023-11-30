def flatten(Map src, Map dest=[:], String parentKey="") {
	src.each { key, val -> dest += flatten(val, dest, [parentKey, key].findAll().join(".")) }
	dest
}

def flatten(val, Map dest, String key) {
	dest + [(key): val]
}

println flatten([a: 1])
println flatten([a: 1, b: [c: 2]])
println flatten([a: 1, b: [c: [d: 3]]])
println flatten([a: 1, b: [c: [d: 2]], e: 3])
