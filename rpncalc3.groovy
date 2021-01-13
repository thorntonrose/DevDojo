if (args.length < 1) {
	println "usage: rpncalc <expression>"
	return
}

stack = []

operations = [
	"+": { stack.pop() + stack.pop() },
	"-": { (- stack.pop()) + stack.pop() },
	"*": { stack.pop() * stack.pop() },
	"/": { (1 / stack.pop()) * stack.pop() }
].withDefault { key ->
	if (!key.isNumber()) { throw new Exception("unknown operator: $key") }
	return { key as float }
}

args[0].split(" ").each { stack.push operations[it]() }
println stack.pop()
