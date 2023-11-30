package main

import (
	"flag"
	"fmt"
	"unicode"
)

func main() {
	decodeFlag := flag.Bool("d", false, "decode")
	flag.Parse()

	if len(flag.Args()) == 0 {
		flag.Usage()
	}

	text := flag.Arg(0)
	cipher := make([]rune, len(text))
	distance := 3

	if *decodeFlag {
		distance = -3
	}

	for index, char := range text {
		if unicode.IsLetter(char) {
			base := 'a'

			if distance < 0 {
				base = 'z'
			}

			if unicode.IsUpper(char) {
				base = unicode.ToUpper(base)
			}

			char = ((char - base + rune(distance)) % 26) + base
		}

		cipher[index] = char
	}

	fmt.Println(string(cipher))
}
