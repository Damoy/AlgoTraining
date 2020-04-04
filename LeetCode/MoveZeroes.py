def moveZeroesToEnd(nums):
    left = 0
    right = 0
    n = len(nums)

    while right < n:
        if nums[right] != 0:
            nums[left] = nums[right]
            left += 1
        right += 1

    while left < n:
        nums[left] = 0
        left += 1

    return nums

print(moveZeroesToEnd([0, 1, 0, 3, 12]))

    