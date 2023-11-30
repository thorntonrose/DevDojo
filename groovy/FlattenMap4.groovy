// iterative
def flatten(Map src) {
	def dest = [:]
	def stack = []
	def keys = src.keySet() as List
	def index = 0
	def parentKey = ""

	while (true) {
		while (index < keys.size()) {
			def key = keys[index]
			def value = src[key]
			def flatKey = [parentKey, key].findAll().join(".")

			if (value instanceof Map) {
				stack.push([src, keys, index, flatKey])
				(src, keys, index, parentKey) = [value, value.keySet() as List, 0, flatKey]
			} else {
				dest[flatKey] = value
				index ++
			}
		}

		if (!stack) { break }
		(src, keys, index, parentKey) = stack.pop()
		index ++
	}

	dest
}

println flatten([a: 1])
println flatten([a: 1, b: [c: 2]])
println flatten([a: 1, b: [c: [d: 3]]])
println flatten([a: 1, b: [c: [d: 2]], e: 3])
