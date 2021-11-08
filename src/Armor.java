/**
 * @className: Armor
 * @description: class of armor
 * @author: Yan Tong
 **/
public class Armor extends Item{
    private int defense;

    public Armor(String name, int price, int minLevelReq, int defense) {
        super(name, price, minLevelReq);
        this.defense = defense;
    }

    public Armor(String name, int price, int minLevelReq) {
        super(name, price, minLevelReq);
    }

    @Override
    public void use(Role role) {

    }

    @Override
    public void sellTo(Buyable buyable) {

    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}
