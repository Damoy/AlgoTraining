import sys

def getMaxSubArraySum(nums):
    if not len(nums):
        return 0

    if allNeg(nums):
        return maxArr(nums)

    maxSum = -sys.maxsize
    currentSum = 0
    for v in nums:
        currentSum = max(0, currentSum + v)
        if currentSum > maxSum:
            maxSum = currentSum
    return maxSum

def allNeg(nums):
    for v in nums:
        if v > 0:
            return False
    return True

def maxArr(nums):
    max = -sys.maxsize
    for v in nums:
        if v > max:
            max = v
    return max

print(getMaxSubArraySum([-2,1,-3,4,-1,2,1,-5,4]))
print(getMaxSubArraySum([-2, 1, 4, 3, -5, 10]))
print(getMaxSubArraySum([-2, 1, 4, -5, -2, 20]))
print(getMaxSubArraySum([-2,-1]))
