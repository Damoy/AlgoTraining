def searchInSortedMatrix(matrix, target):
    row = 0
    col = len(matrix[0]) - 1

    while row < len(matrix) and col >= 0:
        elt = matrix[row][col]
        if elt == target:
            return [row, col]
        elif elt > target:
            col -= 1
        elif elt < target:
            row += 1

    return [-1, -1]

m = [
  [1, 4, 7, 12, 15, 1000],
  [2, 5, 19, 31, 32, 1001],
  [3, 8, 24, 33, 35, 1002],
  [40, 41, 42, 44, 45, 1003],
  [99, 100, 103, 106, 128, 1004]
]

print(searchInSortedMatrix(m, 1))
print(searchInSortedMatrix(m, 2))
print(searchInSortedMatrix(m, 4))
print(searchInSortedMatrix(m, 12))
print(searchInSortedMatrix(m, 15))
print(searchInSortedMatrix(m, 32))
print(searchInSortedMatrix(m, 99))
