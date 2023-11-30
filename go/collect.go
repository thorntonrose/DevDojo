package main

func Collect[A any, B any](items []A, f func(A) B) []B {
	result := make([]B, len(items))

	for i, item := range items {
		result[i] = f(item)
	}

	return result
}

func CollectEntries[T any, K comparable, V any](items []T, f func(T) (K, V)) map[K]V {
	result := map[K]V{}

	for _, item := range items {
		k, v := f(item)
		result[k] = v
	}

	return result
}
