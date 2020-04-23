from collections import defaultdict
def subarraySum(nums, k):
    count = defaultdict(int)
    pref = 0
    answer = 0
    count[pref] = 1
    for v in nums:
        pref += v
        diff = pref - k
        answer += count[diff]
        count[pref] += 1
    return answer

print(subarraySum([1,1,1], 2))
