def findMaxLength(nums):
    d = {}
    d[0] = -1
    maxLen = 0
    count = 0
    for i in range(len(nums)):
        count += 1 if nums[i] == 1 else -1
        if count in d:
            maxLen = max(maxLen, i - d[count])
        else:
            d[count] = i
    return maxLen

print(findMaxLength([0,1,1,0,1,1,1,0]))
print(findMaxLength([0,0,1,0,0,0,1,1]))
print(findMaxLength([0,1,1]))