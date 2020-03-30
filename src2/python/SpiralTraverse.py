def spiralTraverse(matrix):
    array = []
    rowStart = 0
    rowEnd = len(matrix) - 1
    colStart = 0
    colEnd = len(matrix[0]) - 1

    while(rowStart <= rowEnd and colStart <= colEnd):
        for col in range(colStart, colEnd + 1):
            array.append(matrix[rowStart][col])
        
        for row in range(rowStart + 1, rowEnd + 1):
            array.append(matrix[row][colEnd])
        
        for col in reversed(range(colStart, colEnd)):
            array.append(matrix[rowEnd][col])

        for row in reversed(range(rowStart + 1, rowEnd)):
            array.append(matrix[row][colStart])

        rowStart += 1
        rowEnd -= 1
        colStart += 1
        colEnd -= 1

    return array

print(spiralTraverse([
    [1, 2, 3, 4],
    [12, 13, 14, 5],
    [11, 16, 15, 6],
    [10, 9, 8, 7]
]))

print(spiralTraverse([[1]]))


