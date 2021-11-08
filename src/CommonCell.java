/**
 * @className: CommonPlace
 * @description: common cell on grid, can pass and meet monster
 * @author: Yan Tong
 **/
public class CommonCell extends Cell{
    public CommonCell(int[] position) {
        super(position);
    }

    public CommonCell(int row, int col) {
        super(row, col);
    }

    @Override
    public void comeTo(Team team) {
        team.updatePosition(this.getPosition());
    }

    @Override
    public String toString() {
        return " ";
    }
}
