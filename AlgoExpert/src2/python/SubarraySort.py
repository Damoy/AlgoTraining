def subarraySort(array):
    n = len(array)
    if n == 2:
        res = [-1, -1]
        if array[0] > array[1]:
            res[0] = 0
            res[1] = 1
        return res

    left = 0
    right = n - 1

    while left < right and array[left] <= array[left + 1]:
        left += 1
    
    maxLeft = array[left]

    while right > 0 and array[right] > array[right - 1] \
        and array[right] > maxLeft:
        right -= 1

    updatedOnce = False

    for i in range(left + 1, right + 1):
        if not updatedOnce: updatedOnce = True
        v = array[i]

        if v < array[left]:
            while left >= 0 and v < array[left]:
                left -= 1
            left += 1
        elif v > array[right]:
            while right < n and v > array[right]:
                right += 1
            right -= 1
        
    return [-1, -1] if not updatedOnce else [left, right]

print(subarraySort([1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19]) == [3,9])
print(subarraySort([1, 2]) == [-1,-1])
print(subarraySort([2, 1]) == [0, 1])
print(subarraySort([1, 2, 4, 7, 10, 11, 7, 12, 7, 7, 16, 18, 19]) == [4,9])
print(subarraySort([1, 2, 4, 7, 10, 11, 7, 12, 13, 14, 16, 18, 19]) == [4, 6])
print(subarraySort([4, 8, 7, 12, 11, 9, -1, 3, 9, 16, -15, 51, 7]) == [0, 12])

# Time O(n) | Space O(1)
def subarraySort_v2(array):
    minOutOfOrder = float("inf")
    maxOutOfOrder = float("-inf")
    n = len(array)
    for i in range(n):
        if isOutOfOrder(i, array, n):
            minOutOfOrder = min(minOutOfOrder, array[i])
            maxOutOfOrder = max(maxOutOfOrder, array[i])
    if minOutOfOrder == float("inf"):
        return [-1, -1]
    subarrayLeftIdx = 0
    while minOutOfOrder >= array[subarrayLeftIdx]:
        subarrayLeftIdx += 1
    subarrayRightIdx = n - 1
    while maxOutOfOrder <= array[subarrayRightIdx]:
        subarrayRightIdx -= 1
    return [subarrayLeftIdx, subarrayRightIdx]

def isOutOfOrder(i, array, n):
    if i == 0:
        return array[i] > array[i + 1]
    if i == n - 1:
        return array[i] < array[i - 1]
    return array[i] > array[i + 1] or array[i] < array[i - 1]

print(subarraySort_v2([1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19]) == [3,9])
print(subarraySort_v2([1, 2]) == [-1,-1])
print(subarraySort_v2([2, 1]) == [0, 1])
print(subarraySort_v2([1, 2, 4, 7, 10, 11, 7, 12, 7, 7, 16, 18, 19]) == [4,9])
print(subarraySort_v2([1, 2, 4, 7, 10, 11, 7, 12, 13, 14, 16, 18, 19]) == [4, 6])
print(subarraySort_v2([4, 8, 7, 12, 11, 9, -1, 3, 9, 16, -15, 51, 7]) == [0, 12])