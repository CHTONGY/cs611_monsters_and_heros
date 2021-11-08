/**
 * @className: InaccessibleCell
 * @description: inaccessible cell
 * @author: Yan Tong
 **/
public class InaccessibleCell extends Cell{
    public InaccessibleCell(int[] position) {
        super(position);
    }

    public InaccessibleCell(int row, int col) {
        super(row, col);
    }

    @Override
    public void comeTo(Team team) {
        System.out.println("inaccessible cell!");
    }

    @Override
    public String toString() {
        return "X";
    }
}
