package main

import (
	"fmt"
	"os"
	"strconv"
)

func main() {
	if (len(os.Args) < 4) {
		fmt.Println("usage: triangle <int> <int> <int>")
	} else {
		a, _ := strconv.Atoi(os.Args[1])
		b, _ := strconv.Atoi(os.Args[2])
		c, _ := strconv.Atoi(os.Args[3])

		fmt.Println((a + b > c) && (a + c > b) && (b + c > a))
	}
}