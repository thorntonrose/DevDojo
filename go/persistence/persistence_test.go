package main

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestPersistence(t *testing.T) {
	values := [][]int{{39, 3}, {999, 4}, {4, 0}}

	for _, val := range values {
		assert.Equal(t, val[1], persistence(val[0]))
	}
}