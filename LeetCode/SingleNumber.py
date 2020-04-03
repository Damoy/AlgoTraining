def getSingleNumber(nums):
    res = 0
    for x in nums:
        res = res^x
    return res

print(getSingleNumber([4,1,1,2,3,2,3]))