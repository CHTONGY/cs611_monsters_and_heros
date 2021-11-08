/**
 * @className: Weapon
 * @description: class of weapon
 * @author: Yan Tong
 **/
public class Weapon extends Item{
    private int damage;
    private int handsReq;

    public Weapon(String name, int price, int minLevelReq, int damage, int handsReq) {
        super(name, price, minLevelReq);
        this.damage = damage;
        this.handsReq = handsReq;
    }

    public Weapon(String name, int price, int minLevelReq) {
        super(name, price, minLevelReq);
    }

    @Override
    public void use(Role role) {
        ((Hero)role).setWeapon(this);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHandsReq() {
        return handsReq;
    }

    public void setHandsReq(int handsReq) {
        this.handsReq = handsReq;
    }
}
