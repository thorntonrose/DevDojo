package main

import (
	"fmt"
	"testing"
)

func TestMin(t *testing.T) {
	result := min([]float64{ 2.0, 1.0 })
	if result != 1.0 { t.Error("result != 1.0") }
}

func TestMax(t *testing.T) {
	result := max([]float64{ 1.0, 2.0 })
	if result != 2.0 { t.Error("result != 2.0") }
}

func TestSum(t *testing.T) {
	result := sum([]float64{ 1.0, 1.0 })
	if result != 2.0 { t.Error("result != 2.0") }
}

func TestAverage(t *testing.T) {
	//result := average([]float64{ 1.0, 2.0 })
	//if result != 1.5 { t.Error("result != 1.5") }
	result := average([]float64{1.0, -0.6, 0.5, 2.0, 6.0, 7.9})
	fmt.Println(result)
}