if (args.length < 1) {
	println "usage: rpncalc <expression>"
	return
}

stack = []
operations = ["+": { add() }, "-": { subtract() }, "*": { multiply() }, "/": { divide() }]

add = { stack.pop() + stack.pop() }
subtract = { (- stack.pop()) + stack.pop() }
multiply = { stack.pop() * stack.pop() }
divide = { (1 / stack.pop()) * stack.pop() }

calculate = {
	if (!operations[it]) { throw new Exception("unknown operator: $it") }
	operations[it]()
}

args[0].split(" ").each { stack.push it.isNumber() ? it as float : calculate(it) }
println stack.pop()
