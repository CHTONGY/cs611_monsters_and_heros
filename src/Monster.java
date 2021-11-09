/**
 * @className: Monster
 * @description: monster class
 * @author: Yan Tong
 **/
public abstract class Monster extends Role implements Attackable{
    public Monster(String name, int level, int hp, int damage, int defense, int dodge, int[] position) {
        super(name, level, hp, damage, defense, dodge, position);
    }

    @Override
    public int getDamage() {
        return (int)(super.getDamage() * 0.5);
    }

    @Override
    public int getDefense() {
        return (int)(super.getDefense() * 0.01);
    }

    @Override
    public int getDodge() {
        return (int)(super.getDodge() * 0.005);
    }
}
