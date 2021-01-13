if (args.length < 1) {
	println "usage: rpncalc <expression>"
	return
}

stack = []
operations = ["+": { add() }, "-": { subtract() }, "*": { multiply() }, "/": { divide() }]

args[0].split(" ").each {
	if (it.isNumber()) {
		stack.push it as float
	} else {
		if (!operations[it]) { throw new Exception("unknown operator: $it") }
		stack.push operations[it]()
	}
}

println stack.pop()

//-----------------------------------------------------------------------------

def add() { stack.pop() + stack.pop() }
def subtract() { (- stack.pop()) + stack.pop() }
def multiply() { stack.pop() * stack.pop() }
def divide() { (1 / stack.pop()) * stack.pop() }
