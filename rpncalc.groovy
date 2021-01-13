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
		stack.push operation()
	}
}

println stack.pop()

//-----------------------------------------------------------------------------

def add() {
	stack.pop() + stack.pop()
}

def subtract() {
	(- stack.pop()) + stack.pop()
}

def multiply() {
	stack.pop() * stack.pop()
}

def divide() {
	(1 / stack.pop()) * stack.pop()
}
