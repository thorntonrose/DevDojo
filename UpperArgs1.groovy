// args.each { println it.toUpperCase() }
args*.toUpperCase().each { println it }
//println args*.toUpperCase()