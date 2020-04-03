# Time - O(n) | Space O(1)
def longestPeak(array):
    n = len(array)
    if n < 3:
        return 0
    if n == 3:
        return 3 if (array[1] > array[0] and array[1] > array[2]) else 0

    startIndex = 0
    endIndex = 0
    maxPeak = 0

    for i in range(1, n - 1):
        if array[i] > array[i - 1] and \
            array[i] > array[i + 1]:
            while i < n - 1 and array[i] > array[i + 1]:
                i += 1
            endIndex = i
            peakLength = endIndex - startIndex + 1
            if maxPeak < peakLength:
                maxPeak = peakLength
        elif array[i - 1] >= array[i]:
            startIndex = i

    return maxPeak

print(longestPeak([1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3]))
print(longestPeak([1, 2, 3, 4, 5, 1]))
print(longestPeak([1, 1, 3, 2, 1]))