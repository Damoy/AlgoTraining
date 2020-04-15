def productExceptSelf(nums):
    n = len(nums)
    res = [0 for _ in nums]
    res[0] = 1
    for i in range(1, n):
        res[i] = nums[i - 1] * res[i - 1]
    R = 1
    for i in reversed(range(n)):
        res[i] = res[i] * R
        R *= nums[i]
    return res

print(productExceptSelf([1, 2, 3, 4]))
        