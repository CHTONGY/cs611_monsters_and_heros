/**
 * @className: MarketCell
 * @description: market cell on grid, can buy and sell items
 * @author: Yan Tong
 **/
public class MarketCell extends Cell{
    public MarketCell(int[] position) {
        super(position);
    }

    public MarketCell(int row, int col) {
        super(row, col);
    }

    @Override
    public void comeTo(Team team) {

    }

    @Override
    public String toString() {
        return "M";
    }
}
