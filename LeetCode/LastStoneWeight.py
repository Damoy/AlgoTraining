def lastStoneWeight(stones):
    stones.sort()
    while len(stones) > 1:
        y = stones.pop()
        x = stones.pop()
        if x != y:
            stones.append(y - x)
            stones.sort()
    return stones[0] if len(stones) == 1 else 0

print(lastStoneWeight([2, 7, 4, 1, 8, 1]) == 1)