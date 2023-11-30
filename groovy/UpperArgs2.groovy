class UpperArgs2 {
	static void main(args) {
		args*.toUpperCase().each { println it }
	}
}