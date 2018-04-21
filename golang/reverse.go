package main

import (
	"fmt"
	"os"
)

func main() {
	str := os.Args[1]
	rev := ""

	for i := len(str) - 1; i >= 0; i-- {
		rev += string(str[i])
	}

	fmt.Println(rev)
}
