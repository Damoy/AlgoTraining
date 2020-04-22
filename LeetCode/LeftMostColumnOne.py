def test(arr):
    dim = [len(arr), len(arr[0])]
    colRes = dim[1]
    for row in range(dim[0]):
        left = 0
        right = dim[1] - 1
        while left <= right:
            col = left + (right - left) // 2
            if arr[row][col] == 1:
                colRes = min(colRes, col)
                right = col - 1
            else:
                left = col + 1
    return colRes if colRes != dim[1] else -1


print(test([[0,0],[0,1]]))