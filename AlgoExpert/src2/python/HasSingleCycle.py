def hasSingleCycle(array):
	n = len(array)
	index = 0

	for i in range(n):
		if index == 0 and i > 0:
		    return False
		index = (index + array[index]) % n

	return index == 0

print(hasSingleCycle([2, 3, 1, -4, -4, 2]))
print(hasSingleCycle([2, 2, -1]))
print(hasSingleCycle([2, 2, 3]))