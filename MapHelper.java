public class MapHelper {
    public static int countReachableCells(Map map) {
        if (map == null)
            throw new IllegalArgumentException("Arguments cannot be null");
        boolean[][] visited = new boolean[map.height][map.width];

        // subtract one to exclude starting point
        return bfs(map.getStartCell(), visited) - 1;
    }

    private static int bfs(Cell currentCell, boolean[][] visited) {
        visited[currentCell.y][currentCell.x] = true;
        int touchedCells = 0;

        for (Cell adjCell : currentCell.getAdjCells()) {
            if (!adjCell.isWall && !visited[adjCell.y][adjCell.x]) {
                touchedCells += dfs(adjCell, visited);
            }
        }

        return ++touchedCells;
    }
}
