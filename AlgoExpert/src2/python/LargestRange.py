# Time O(n) | Space O(n)
def largestRange_v2(array):
    bestRange = None
    maxLen = 0
    nums = {}
    for v in array:
        nums[v] = True
    for v in array:
        if not nums[v]:
            continue
        nums[v] = False
        currentLen = 1
        left = v - 1
        right = v + 1
        while left in nums:
            nums[left] = False
            currentLen += 1
            left -= 1
        while right in nums:
            nums[right] = False
            currentLen += 1
            right += 1
        if currentLen > maxLen:
            bestRange = [left + 1, right - 1]
            maxLen = currentLen
    return bestRange

print(largestRange_v2([1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6]) == [0,7])
print(largestRange_v2([8, 4, 2, 10, 3, 6, 7, 9, 1]) == [6,10])
print(largestRange_v2([19, -1, 18, 17, 2, 10, 3, 12, 5, 16, 4, 11, 8, 7, 6, 15, 12, 12, 2, 1, 6, 13, 14]) == [10,19])

# can be improved
def largestRange(array):
    n = len(array)
    if n == 1:
        return [array[0], array[0]]
    elif n == 2:
        return [min(array[0], array[1]), max(array[0], array[1])]
        
    s = set()
    minElt = 0
    maxElt = 0
    maxCount = 0

    for v in array:
        s.add(v)

    for v in array:
        elt = v
        while elt in s:
            elt = elt + 1
        currentMaxElt = elt
        if v in s and currentMaxElt not in s:
            currentMaxElt -= 1

        elt = v - 1
        startElt = elt
        while elt in s:
            elt = elt - 1
        if startElt in s and elt not in s:
            elt += 1
        diff = startElt - elt
        
        if diff > maxCount:
            maxCount = diff
            maxElt = currentMaxElt
            minElt = elt
    return [minElt, maxElt]

print(largestRange([1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6]) == [0,7])
print(largestRange([8, 4, 2, 10, 3, 6, 7, 9, 1]) == [6,10])
print(largestRange([19, -1, 18, 17, 2, 10, 3, 12, 5, 16, 4, 11, 8, 7, 6, 15, 12, 12, 2, 1, 6, 13, 14]) == [10,19])