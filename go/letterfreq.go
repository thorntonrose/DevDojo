package main

import (
	"fmt"
	"os"
)

func main() {
   freq := make(map[rune]int)

   for _, char := range os.Args[1] {
      if _, ok := freq[char]; ok {
			freq[char] ++
		} else {
			freq[char] = 1
		}
   }

   for key, val := range freq {
      fmt.Printf("%c: %v\n", key, val)
   }
}