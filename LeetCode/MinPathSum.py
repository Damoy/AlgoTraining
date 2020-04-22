def minPathSum(grid):
    h = len(grid)
    w = len(grid[0])
    for row in range(h):
        for col in range(w):
            if row == 0 and col == 0:
                continue
            if row == 0:
                grid[0][col] += grid[0][col - 1]
            elif col == 0:
                grid[row][0] += grid[row - 1][0]
            else:
                grid[row][col] = grid[row][col] + min(grid[row - 1][col], grid[row][col - 1])
    return grid[h - 1][w - 1]

print(minPathSum([[1,3,1],[1,5,1],[4,2,1]]))