# Upper bound - Time O(n^2 * n!) | Space O(n * n!)
# Roughly: O(n * n!) | Space O(n * n!)
def getPermutations_v1(array):
    permutations = []
    permutationsUtil_v1(array, [], permutations)
    return permutations

def permutationsUtil_v1(array, currentPermutation, permutations):
    if not len(array) and len(currentPermutation):
        permutations.append(currentPermutation)
    else:
        for i in range(len(array)):
            newArray = array[:i] + array[i + 1:]
            newPermutation = currentPermutation + [array[i]]
            permutationsUtil_v1(newArray, newPermutation, permutations)

# Upper bound - Time O(n * n!) | Space O(n * n!)
def getPermutations_v2(array):
    permutations = []
    permutationsUtils_v2(0, array, permutations)
    return permutations

def permutationsUtils_v2(i, array, permutations):
    # [1, 2, 3]
    if i == len(array) - 1:
        permutations.append(list(array)) # O(n)
    else:
        # For every index start from our current position
        # and until the end of the array
        for j in range(i, len(array)):
            # Step 2 - [1, 3, 2]
            swap(array, i, j)
            permutationsUtils_v2(i + 1, array, permutations)
            swap(array, i, j)

def swap(array, i, j):
    array[i], array[j] = array[j], array[i]

print(getPermutations_v1([1, 2, 3]))
print(getPermutations_v2([1, 2, 3]))
