/**
 * @className: Potion
 * @description: class of potion
 * @author: Yan Tong
 **/
public class Potion extends Item{
    // Health/Mana/Strength/Dexterity/Defense/Agility
    private int[] increaseStats;

    public Potion(String name, int price, int minLevelReq, int[] increaseStats) {
        super(name, price, minLevelReq);
        this.increaseStats = increaseStats;
    }


    @Override
    public void use(Role role) {
        Hero hero = (Hero) role;
        hero.setHp(hero.getHp() + increaseStats[0]);
        hero.setMana(hero.getMana() + increaseStats[1]);
        hero.setStrength(hero.getStrength() + increaseStats[2]);
        hero.setDexterity(hero.getDexterity() + increaseStats[3]);
        hero.getStats().addDefense(increaseStats[4]);
        hero.setAgility(hero.getAgility() + increaseStats[5]);
        ((Hero) role).getInventory().removeItem(this);
    }

}
