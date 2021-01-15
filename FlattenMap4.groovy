// iterative
def flatten(Map src) {
	def dest = [:]
	def stack = []
	def ctx = [src: src, keys: src.keySet() as List, index: 0, flatKey: ""]

	while (true) {
		while (ctx.index < ctx.keys.size()) {
			def key = ctx.keys[ctx.index]
			def value = ctx.src[key]
			def flatKey = [ctx.flatKey, key].findAll().join(".")

			if (value instanceof Map) {
				stack.push ctx
				ctx = [src: value, keys: value.keySet() as List, index: 0, flatKey: flatKey]
			} else {
				dest[flatKey] = value
				ctx.index ++
			}
		}

		if (!stack) { break }
		ctx = stack.pop()
		ctx.index ++
	}

	dest
}

println flatten([a: 1])
println flatten([a: 1, b: [c: 2]])
println flatten([a: 1, b: [c: [d: 3]]])
println flatten([a: 1, b: [c: [d: 2]], e: 3])
