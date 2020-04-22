def search(nums, target):
    left = 0
    n = len(nums)
    right = n - 1
    cpt = 0
    while cpt <= n // 2:
        mid = (left + abs(right - left) // 2) % n
        x = nums[mid]
        if x == target:
            return mid
        if x > nums[mid + 1]:
            if target > x:
                return -1
            # todo max
            left = mid + 1
            right = mid - 1
        elif x < nums[mid - 1]:
            if target < x:
                return -1
            # todo min
            left = mid + 1
            right = mid - 1
        elif target > x:
            left = mid + 1
        else:
            right = mid - 1
        cpt += 1
    return -1


print(search([4,5,6,7,0,1,2], 0))
