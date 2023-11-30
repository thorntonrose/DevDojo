package main

import (
	"testing"
)

func TestBar(t *testing.T) {
	i := bar([]float64{ 1.0 })

	if i != 1 {
		t.Error("i != 1")
	}
}