package main

import (
	"fmt"
	"os"
	"unicode"
)

func main() {
	text := os.Args[1]
   rot := make([]rune, len(text))

	for index, char := range os.Args[1] {
		upperChar := unicode.ToUpper(char)

		switch {
			case upperChar >= rune('A') && upperChar <= rune('M'):
				char += 13
			case upperChar >= rune('N') && upperChar <= rune('Z'):
				char -= 13
      }

		rot[index] = char
	}

	fmt.Println(string(rot))
}