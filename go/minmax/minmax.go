package main

func min(nums []float64) float64 {
	min := nums[0]

	for _, n := range nums[1:] {
		if n < min {
			min = n
		}
	}

	return min
}

func max(nums []float64) float64 {
	max := nums[0]

	for _, n := range nums[1:] {
		if n > max {
			max = n
		}
	}

	return max
}

func sum(nums []float64) float64 {
	sum := float64(0.0)

	for _, n := range nums {
		sum += n
	}

	return sum
}

func average(nums []float64) float64 {
	return sum(nums) / float64(len(nums))
}