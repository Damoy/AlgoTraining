def numIslands(grid):
    sizes = []
    visited = [[False for value in row] for row in grid]

    for y in range(len(grid)):
        for x in range(len(grid[y])):
            if visited[y][x]:
                continue
            traverseNode(y, x, grid, visited, sizes)

    return len(sizes)

def traverseNode(y, x, grid, visited, sizes):
    currentRiverSize = 0
    nodes = [[y, x]]

    while(len(nodes)):
        current = nodes.pop()
        y = current[0]
        x = current[1]
        if visited[y][x]:
            continue

        visited[y][x] = True
        
        if grid[y][x] == '0':
            continue

        currentRiverSize += 1
        neighbors = getUnvisitedNeighbors(y, x, grid, visited)

        for neighbor in neighbors:
            nodes.append(neighbor)
    
    if currentRiverSize > 0:
        sizes.append(currentRiverSize)

def getUnvisitedNeighbors(y, x, grid, visited):
    unvisited = []
    if y > 0 and not visited[y - 1][x]:
        unvisited.append([y - 1, x])

    if y < len(grid) - 1 and not visited[y + 1][x]:
        unvisited.append([y + 1, x])

    if x > 0 and not visited[y][x - 1]:
        unvisited.append([y, x - 1])

    if x < len(grid[y]) - 1 and not visited[y][x + 1]:
        unvisited.append([y, x + 1])
    
    return unvisited

print(numIslands([
    [1,1,1,1,0],
    [1,1,0,1,0],
    [1,1,0,0,0],
    [0,0,0,0,0]
]))

print(numIslands([["1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0","0","1","1"]])