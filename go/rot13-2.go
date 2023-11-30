package main

import (
	"fmt"
	"os"
	"unicode"
)

func rot13(char rune) rune {
	upperChar := unicode.ToUpper(char)

	switch {
		case (upperChar >= rune('A') && upperChar <= rune('M')):
			char += 13
		case (upperChar >= rune('N') && upperChar <= rune('Z')):
			char -= 13
	}

   return char
}

func rot13Text(text string) string {
   rot := make([]rune, len(text))

	for index, char := range text {
		rot[index] = rot13(char)
	}

	return string(rot)
}

func main() {
	fmt.Println(rot13Text(os.Args[1]))
}