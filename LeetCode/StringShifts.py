def stringShift(s, shift):
    cpt = 0
    for shiftV in shift:
        cpt += shiftV[1] if shiftV[0] == 1 else -shiftV[1]

    if cpt == 0:
        return s
    n = len(s)
    cpt = cpt % n
    res = []
    if cpt < 0:
        cpt = -cpt
    for i in range(n):
        index = (i - cpt) % n
        res.append(s[index])
    return ''.join(res)

print(stringShift("abc", [[0,1],[1,2]]))
print(stringShift("abcdefg",  [[1,1],[1,1],[0,2],[1,3]]))