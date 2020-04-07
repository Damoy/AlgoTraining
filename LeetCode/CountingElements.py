from collections import defaultdict

def countElements(arr):
    res = defaultdict(int)

    for e in arr:
        res[e] += 1
    
    count = 0

    for key in res.keys():
        if (key + 1) in res:
            count += res[key]

    return count

print(countElements([1,2,3]) == 2)
print(countElements([1,1,3,3,5,5,7,7]) == 0)
print(countElements([1,3,2,3,5,0]) == 3)
print(countElements([1,1,2,2]) == 2)

