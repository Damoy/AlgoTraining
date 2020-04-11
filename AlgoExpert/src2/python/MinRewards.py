def minRewards(scores):
    n = len(scores)
    res = [1 for _ in range(n)]
    for i in range(1, n):
        if scores[i] > scores[i - 1]:
            res[i] = res[i - 1] + 1
    for i in reversed(range(n - 1)):
        if scores[i] > scores[i + 1]:
            res[i] = max(res[i], res[i + 1] + 1)
    return sum(res)

print(minRewards([8, 4, 2, 1, 3, 6, 7, 9, 5]))