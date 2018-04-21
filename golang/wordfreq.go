package main

import (
	"fmt"
	"strings"
	"os"
)

func main() {
   freq := make(map[string]int)

   for _, field := range strings.Fields(os.Args[1]) {
      if _, ok := freq[field]; ok {
			freq[field] ++
		} else {
			freq[field] = 1
		}
   }

   for key, val := range freq {
      fmt.Printf("%s: %v\n", key, val)
   }
}