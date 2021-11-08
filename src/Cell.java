/**
 * @className: Cell
 * @description: each single cell in grid
 * @author: Yan Tong
 **/
public abstract class Cell {
    private int[] position;

    public Cell(int[] position) {
        this.position = position;
    }

    public Cell(int row, int col) {
        this.position = new int[]{row, col};
    }

    public abstract void comeTo(Team team);

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public int getRow() {
        return position[0];
    }

    public void setRow(int row) {
        this.position[0] = row;
    }

    public int getCol() {
        return position[1];
    }

    public void setCol(int col) {
        this.position[1] = col;
    }
}
