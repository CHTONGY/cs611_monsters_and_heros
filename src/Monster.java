/**
 * @className: Monster
 * @description: monster class
 * @author: Yan Tong
 **/
public abstract class Monster extends Role implements Attackable{
    public Monster(String name, int level, int hp, int damage, int defense, int dodge, int[] position) {
        super(name, level, hp, damage, defense, dodge, position);
    }
}
