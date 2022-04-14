grid = [[0, 0, 0, 0, 0, 0, 0, 0],
        [0, -1, 0, 0, 0, -1, 0, 0],
        [0, 0, 0, 0, -1, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, -1, 0, 0, -1, 0],
        [0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, -1, 0],
        [0, 0, -1, 0, 0, -1, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, -1, 0, 0, 0],
        ]
row = len(grid)
col = len(grid[0])
start_position = [9, 3]

possible_paths = -1
queue = []


def explore_diagonal(x, y):
    if x+1 < row and y+1 < col:
        if grid[x+1][y+1] == 0:
            queue.append([x+1, y+1])
            visitNode([x+1, y+1])
    if x-1 >= 0 and y-1 >= 0:
        if grid[x-1][y-1] == 0:
            queue.append([x-1, y-1])
            visitNode([x-1, y-1])
    if x-1 >= 0 and y+1 < col:
        if grid[x-1][y+1] == 0:
            queue.append([x-1, y+1])
            visitNode([x-1, y+1])
    if x+1 < row and y-1 >= 0:
        if grid[x+1][y-1]:
            queue.append([x+1, y-1])
            visitNode([x+1, y-1])


def visitNode(pos):
    global possible_paths
    if grid[pos[0]][pos[1]] == 0:
        grid[pos[0]][pos[1]] = 1
        possible_paths += 1


queue.append(start_position)
visitNode(start_position)

while len(queue) > 0:
    node = queue.pop()
    explore_diagonal(node[0], node[1])

# print(grid)

print(possible_paths) 
