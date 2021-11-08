/**
 * @className: Paladin
 * @description: class of Paladin, a kind of hero
 * @author: Yan Tong
 **/
public class Paladin extends Hero{
    public Paladin(String name, int level, int hp, int damage, int defense, int dodge, int[] position) {
        super(name, level, hp, damage, defense, dodge, position);
    }

    public Paladin(String name, Stats stats, int[] position, int mana, int strength, int agility, int dexterity, int money, int experience, Inventory inventory) {
        super(name, stats, position, mana, strength, agility, dexterity, money, experience, inventory);
    }

    @Override
    public boolean levelUp() {
        boolean isLevelUp = super.levelUp();
        if(isLevelUp) {
            this.setStrength((this.getStrength() + Math.max(1, (int)(this.getStrength() * 0.1))));
            this.setAgility((this.getAgility() + Math.max(1, (int)(this.getAgility() * 0.05))));
            this.setDexterity((this.getDexterity() + Math.max(1, (int)(this.getDexterity() * 0.1))));
        }
        return isLevelUp;
    }
}
