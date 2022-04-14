import java.util.LinkedList;

public class Cell {
    public final int x;
    public final int y;
    public final boolean isWall;
    private final LinkedList<Cell> adjCells;

    public Cell(int x, int y, boolean isWall) {
        if (x < 0 || y < 0)
            throw new IllegalArgumentException("x, y must be greater than 0");

        this.x = x;
        this.y = y;
        this.isWall = isWall;

        adjCells = new LinkedList<>();
    }

    public void addAdjCell(Cell c) {
        if (c == null)
            throw new IllegalArgumentException("Cell cannot be null");

        adjCells.add(c);
    }

    public LinkedList<Cell> getAdjCells() {
        return adjCells;
    }
}