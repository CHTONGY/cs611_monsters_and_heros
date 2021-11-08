/**
 * @className: Hero
 * @description: hero class
 * @author: Yan Tong
 **/
public abstract class Hero extends Role implements Attackable, Buyable{
    private int mana;
    private int strength;
    private int agility;
    private int dexterity;
    private int money;
    private int experience;
    private Inventory inventory;
    private Weapon weapon;
    private Armor armor;

    public Hero(String name, int level, int hp, int damage, int defense, int dodge, int[] position) {
        super(name, level, hp, damage, defense, dodge, position);
        this.inventory = new Inventory();
    }

    public Hero(String name, Stats stats, int[] position, int mana, int strength, int agility, int dexterity, int money, int experience, Inventory inventory) {
        super(name, stats, position);
        this.mana = mana;
        this.strength = strength;
        this.agility = agility;
        this.dexterity = dexterity;
        this.money = money;
        this.experience = experience;
        this.inventory = inventory;
    }

    public abstract void levelUp();

    @Override
    public Inventory getInventory() {
        return this.inventory;
    }

    @Override
    public void attack(Role role) {
        int dodgeChance = role.getDodge();
        if((int)(Math.random() * 5) < dodgeChance) {
            // dodge
            return;
        } else {
            int hp = role.getHp() - getStats().getDamage() + role.getDefense();
        }
    }

    @Override
    public Stats getStats() {
        int damage = (int) (strength * 0.05);
        if(weapon != null) {
            damage = (int) ((strength + weapon.getDamage()) * 0.05);
        }
        super.getStats().setDamage(damage);

        int defense = 0;
        if(armor != null) {
            defense = (int) (armor.getDefense() * 0.1);
        }
        super.getStats().setDefense(defense);

        int dodge = (int)(agility * 0.002);
        super.getStats().setDodge(dodge);

        return super.getStats();
    }

    @Override
    public void buy(Sellable sellable) {
        if(sellable.getLevelReq() > this.getLevel()) {
            System.out.printf("cannot buy! require level: %d, current level %d.\n",
                    sellable.getLevelReq(), this.getLevel());
        } else {
            minusMoney(sellable.getPrice());
            this.getInventory().addItem((Item) sellable);
        }
    }

    public void addMoney(int addition) {
        this.money += addition;
    }

    public void minusMoney(int minus) {
        this.money -= minus;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }


}
