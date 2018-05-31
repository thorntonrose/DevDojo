package main

import (
	"fmt"
	"os"
	"strings"
)

func main() {
	if len(os.Args) < 2 {
		fmt.Println("usage: pangram <sentence>")
	} else {
		text := strings.ToLower(os.Args[1])

		for r := 'a'; r <= 'z'; r ++ {
			if !strings.ContainsRune(text, r) {
				fmt.Println("false")
				return
			}
		}

		fmt.Println("true")
	}
}