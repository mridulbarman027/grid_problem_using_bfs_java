import java.awt.*;

public class Map {
    public final int width;
    public final int height;

    private final Cell[][] cells;
    private final Move[] moves;
    private Point startPoint;

    public Map(int[][] mapData) {
        this.width = mapData[0].length;
        this.height = mapData.length;

        cells = new Cell[height][width];
        // define valid movements
        moves = new Move[] {
                new Move(1, 1),
                new Move(-1, 1),
                new Move(1, -1),
                new Move(-1, -1)
        };

        generateCells(mapData);
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point p) {
        if (!isValidLocation(p))
            throw new IllegalArgumentException("Invalid point");

        startPoint.setLocation(p);
    }

    public Cell getStartCell() {
        return getCellAtPoint(getStartPoint());
    }

    public Cell getCellAtPoint(Point p) {
        if (!isValidLocation(p))
            throw new IllegalArgumentException("Invalid point");

        return cells[p.y][p.x];
    }

    private void generateCells(int[][] mapData) {
        boolean foundStart = false;
        for (int i = 0; i < mapData.length; i++) {
            for (int j = 0; j < mapData[i].length; j++) {
                /*
                 * 0 = empty space
                 * 1 = wall
                 * 2 = starting point
                 */
                if (mapData[i][j] == 2) {
                    if (foundStart)
                        throw new IllegalArgumentException("Cannot have more than one start position");

                    foundStart = true;
                    startPoint = new Point(j, i);
                } else if (mapData[i][j] != 0 && mapData[i][j] != 1) {
                    throw new IllegalArgumentException("Map input data must contain only 0, 1, 2");
                }
                cells[i][j] = new Cell(j, i, mapData[i][j] == 1);
            }
        }

        if (!foundStart)
            throw new IllegalArgumentException("No start point in map data");
        // Add all cells adjacencies based on up, down, left, right movement
        generateAdj();
    }

    private void generateAdj() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                for (Move move : moves) {
                    Point p2 = new Point(j + move.getX(), i + move.getY());
                    if (isValidLocation(p2)) {
                        cells[i][j].addAdjCell(cells[p2.y][p2.x]);
                    }
                }
            }
        }
    }

    private boolean isValidLocation(Point p) {
        if (p == null)
            throw new IllegalArgumentException("Point cannot be null");

        return (p.x >= 0 && p.y >= 0) && (p.y < cells.length && p.x < cells[p.y].length);
    }

    private class Move {
        private int x;
        private int y;

        public Move(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}