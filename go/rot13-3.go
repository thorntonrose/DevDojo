package main

import (
	"fmt"
	"os"
	"unicode"
)

func isAToM(char rune) bool {
	return char >= rune('A') && char <= rune('M')
}

func isNToZ(char rune) bool {
	return char >= rune('N') && char <= rune('Z')
}

func rot13(char rune) rune {
	upperChar := unicode.ToUpper(char)

	switch {
		case isAToM(char):
			char += 13
		case isNToZ(char):
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