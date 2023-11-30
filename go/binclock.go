package main

import (
	"fmt"
	"strings"
	"time"
)

func main() {
	fmt.Print("\033[2J") // clear, home

	for {
		now := time.Now()
		digits := [6]string{}

		for i, n := range []int { now.Hour(), now.Minute(), now.Second() } {
			digits[i*2], digits[i*2+1] = binary(n/10), binary(n%10)

			for line := 1; line <= 4; line ++ {
				fmt.Printf("\033[%v;%vH%c", line, i*2, digits[i][line-1])
				fmt.Printf("\033[%v;%vH%c", line, i*2+1, digits[i*2+1][line-1])
			}
		}

		time.Sleep(time.Second)
	}
}

func binary(i int) string {
	return strings.Replace(strings.Replace(fmt.Sprintf("%04b", i), "0", "-", -1), "1", "*", -1)
}