def canJump(nums):
    n = len(nums)
    target = n - 1
    for i in range(n - 1, -1, -1):
        if i + nums[i] >= target:
            target = i
    return target == 0

print(canJump([2, 3, 1, 1, 4]))
print(canJump([3, 2, 1, 0, 4]))
print(canJump([0,2,3]))
print(canJump([2,3,1,1,4]))
print(canJump([1,2,3]))
print(canJump([1,0,1,0]))
print(canJump([1,1,1,0]))