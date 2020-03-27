def riverSizes(matrix):
    sizes = []
    visited = [[False for value in row] for row in matrix]

    for y in range(len(matrix)):
        for x in range(len(matrix[y])):
            if visited[y][x]:
                continue
            traverseNode(y, x, matrix, visited, sizes)

    return sizes

def traverseNode(y, x, matrix, visited, sizes):
    currentRiverSize = 0
    nodes = [[y, x]]

    while(len(nodes)):
        current = nodes.pop()
        y = current[0]
        x = current[1]
        if visited[y][x]:
            continue

        visited[y][x] = True
        
        if matrix[y][x] == 0:
            continue

        currentRiverSize += 1
        neighbors = getUnvisitedNeighbors(y, x, matrix, visited)

        for neighbor in neighbors:
            nodes.append(neighbor)
    
    if currentRiverSize > 0:
        sizes.append(currentRiverSize)

def getUnvisitedNeighbors(y, x, matrix, visited):
    unvisited = []
    if y > 0 and not visited[y - 1][x]:
        unvisited.append([y - 1, x])

    if y < len(matrix) - 1 and not visited[y + 1][x]:
        unvisited.append([y + 1, x])

    if x > 0 and not visited[y][x - 1]:
        unvisited.append([y, x - 1])

    if x < len(matrix[y]) - 1 and not visited[y][x + 1]:
        unvisited.append([y, x + 1])
    
    return unvisited

print(riverSizes([
    [1, 0, 0, 1, 0],
    [1, 0, 1, 0, 0],
    [0, 0, 1, 0, 1],
    [1, 0, 1, 0, 1],
    [1, 0, 1, 1, 0]
]))

print(riverSizes([[1,1,1,0,1,1,0,0,0,1,0]]))

print(riverSizes([
    [1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0],
    [1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0],
    [0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1],
    [1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0],
    [1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1]
]))