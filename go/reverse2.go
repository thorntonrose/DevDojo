package main

import (
	"fmt"
	"os"
)

func main() {
	text := os.Args[1]
	max := len(text)
	rev := make([]rune, max)

	for i, c := range text {
		rev[max - i] = c
	}

	fmt.Println(string(rev))
}