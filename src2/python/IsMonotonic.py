def isMonotonic(array):
	n = len(array)
	if n < 2:
		return True
	
	inf = None
	current = array[0]
	
	for i in range(1, len(array)):
		if current == array[i]:
			current = array[i]
			continue
		
		if inf is None:
			inf = current < array[i]
		
		valid = current < array[i] if inf else current > array[i]
		
		if not valid:
			return False
		
		current = array[i]
		
	return True

print(isMonotonic([-1, -5, -10, -1100, -1100, -1101, -1102, -9001]))
print(isMonotonic([-1, 5, -1]))
print(isMonotonic([-1, -5, -10, -1100, -900, -1101, -1102, -9001]))
print(isMonotonic([1, 1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 8, 9, 10, 11]))
print(isMonotonic([-1, -1, -2, -3, -4, -5, -5, -5, -6, -7, -8, -8, -9, -10, -11]))
print(isMonotonic([-1, -1, -2, -3, -4, -5, -5, -5, -6, -7, -8, -7, -9, -10, -11]))
