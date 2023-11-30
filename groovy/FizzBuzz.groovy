(1..100).each {
	/*
	def by3 = it % 3 == 0
	def by5 = it % 5 == 0

	if (by3 & by5) { println "$it: fizzbuzz"}
	else if (by3) { println "$it: fizz" }
	else if (by5) { println "$it: buzz" }
	*/

	/*
	if(it % 15 == 0) println "$it: Fizzbuzz"
	else if(it % 5 == 0) println "$it: Fizz"
	else if(it % 3 == 0) println "$it: Buzz"
	*/

	def label = "${it % 3 == 0 ? 'fizz' : ''}${it % 5 == 0 ? 'buzz' : ''}"
	if (label) { println "$it: $label" }
}