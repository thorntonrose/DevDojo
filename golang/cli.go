package main

import (
	"flag"
	"fmt"
	//"os"
)

func main() {
	linesFlag := flag.Bool("l", true, "lines")
	threadsFlag := flag.Int("t", 1, "threads")
	wordsFlag := flag.Bool("w", false, "words")
	helpFlag := flag.Bool("h", false, "help")
	flag.Parse()

	if *helpFlag {
		flag.PrintDefaults()
	} else {
		fmt.Println("linesFlag:", *linesFlag)
		fmt.Println("wordsFlag:", *wordsFlag)
		fmt.Println("threadsFlag:", *threadsFlag)
	}
}