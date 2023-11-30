package main

import (
	_ "fmt"
	"strconv"
)

func persistence(num int) int {
	count := 0

	for num > 10 {
		digits := strconv.Itoa(num)
		total := 1

		for _, d := range digits {
			i, _ := strconv.Atoi(string(d))
			total *= i
		}

		count ++
		num = total
	}

	return count
}