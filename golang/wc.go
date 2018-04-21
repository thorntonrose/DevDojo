package main

import (
	"flag"
	"fmt"
	"io/ioutil"
	"os"
	"strings"
)

func main() {
	linesFlag := flag.Bool("l", false, "lines")
	wordsFlag := flag.Bool("w", true, "words")
	charsFlag := flag.Bool("c", false, "characters")
	flag.Parse()

	flag.Usage = func() {
		fmt.Println("usage: wc [options] <file>")
		flag.PrintDefaults()
	}

	if len(flag.Args()) == 0 {
		flag.Usage()
	} else {
		fileName := flag.Arg(0)
		data, err := ioutil.ReadFile(fileName)

		if err != nil {
			fmt.Println(err)
			os.Exit(1)
		}

		text := string(data)

		if *linesFlag {
			fmt.Print(len(strings.Split(text, "\n")), " ")
		}

		if *wordsFlag {
			fmt.Print(len(strings.Fields(string(text))), " ")
		}

		if *charsFlag {
			fmt.Print(len(text), " ")
		}

		fmt.Println(fileName)
	}
}