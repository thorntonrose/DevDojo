if (args.length < 1) {
	println "usage: rpncalc <expression>"
	return
}

stack = []
operations = [ "+": { add() }, "-": { subtract() }, "*": { multiply() }, "/": { divide() } ]

args[0].split(" ").each { token ->
	if (token.isNumber()) {
		stack.push token as float
	} else {
		def operation = operations[token]
		if (!operation) { throw new Exception("unknown operator: $token") }
		operation()
	}
}

println stack.pop()

//-----------------------------------------------------------------------------

def add() {
	stack.push stack.pop() + stack.pop()
}

def subtract() {
	stack.push((- stack.pop()) + stack.pop())
}

def multiply() {
	stack.push stack.pop() * stack.pop()
}

def divide() {
	stack.push((1/stack.pop()) * stack.pop())
}