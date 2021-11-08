import java.util.Arrays;

/**
 * @className: Grid
 * @description: the grid of the world
 * @author: Yan Tong
 **/
public class Grid {
    private Cell[][] cells;
    private int[] heroesPosition;
    private int row;
    private int col;

    public Grid(int row, int col) {
        this.cells = new Cell[row][col];
        this.row = row;
        this.col = col;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                cells[i][j] = generateCell(i, j);
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public int[] getHeroesPosition() {
        return heroesPosition;
    }

    public void setHeroesPosition(int[] heroesPosition) {
        this.heroesPosition = heroesPosition;
    }

    public int[] initHeroesPosition() {
        while(true) {
            int initRow = (int)(Math.random() * this.row);
            int initCol = (int)(Math.random() * this.col);
            if(cells[initRow][initCol] instanceof CommonCell) {
                heroesPosition = new int[]{initRow, initCol};
                return heroesPosition;
            }
        }
    }

    public void setHeroesPosition(int row, int col) {
        this.heroesPosition = new int[]{row, col};
    }

    private Cell generateCell(int row, int col) {
        // 0.2 create inaccessible
        // 0.2 create market
        // 0.6 create common cell
        double randNum = Math.random();
        if(randNum < 0.2) {
            return new InaccessibleCell(row, col);
        } else if(randNum < 0.4) {
            return new MarketCell(row, col);
        } else {
            return new CommonCell(row, col);
        }
    }


    public void printGrid() {
        for(int i = 0; i < row; i++) {
            printBar();
            printRow(i);
        }
        printBar();
    }

    private void printBar() {
        for(int i = 0; i < col; i++) {
            System.out.print("+--");
        }
        System.out.println("+");
    }

    private void printRow(int row) {
        for(int j = 0; j < col; j++) {
            System.out.print("|");
            if(row == heroesPosition[0] && j == heroesPosition[1]) {
                System.out.print("T ");
            } else {
                System.out.print(cells[row][j] + " ");
            }
        }
        System.out.println("|");
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
