# Time O(n * 2^n) - Space O(n * 2^n)
def powerset(array):
    subsets = [[]]
    for v in array:
        for i in range(len(subsets)):
            subsets.append(subsets[i] + [v])
    return subsets

def powerset_rec(array, index = None):
    if index is None:
        index = len(array) - 1
    elif index < 0:
        return [[]]

    subsets = powerset_rec(array, index - 1)

    for i in range(len(subsets)):
        subsets.append(subsets[i] + [array[index]])

    return subsets

print(powerset([1, 2, 3]))
print(powerset_rec([1, 2, 3]))