def isHappy(n):
    nbs = set()
    nb = n

    while True:
        ns = str(nb)
        sum = 0
        for d in ns:
            id = int(d)
            sum += id * id
        if sum in nbs:
            return False
        if sum == 1:
            return True
        nbs.add(sum)
        nb = sum

print(isHappy(19))
print(isHappy(20))