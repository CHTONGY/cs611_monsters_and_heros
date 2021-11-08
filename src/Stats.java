import java.util.Iterator;

/**
 * @className: Stats
 * @description: class of stats info
 * @author: Yan Tong
 **/
public class Stats{
    private int level;
    private int hp;
    private int damage;
    private int defense;
    private int dodge;

    public Stats(int level, int hp, int damage, int defense, int dodge) {
        this.level = level;
        this.hp = hp;
        this.damage = damage;
        this.defense = defense;
        this.dodge = dodge;
    }

    public Stats(Stats stats) {
        this(stats.getLevel(),
                stats.getHp(),
                stats.getDamage(),
                stats.getDefense(),
                stats.getDodge());
    }

    public void addDodge(int addition) {
        this.dodge += addition;
    }

    public void minusDodge(int minus) {
        this.dodge -= minus;
    }

    public void addDefense(int addition) {
        this.defense += addition;
    }

    public void minusDefense(int minus) {
        this.defense -= minus;
    }

    public void addDamage(int addition) {
        this.damage += addition;
    }

    public void minusDamage(int minus) {
        this.damage -= minus;
    }

    public void addHp(int addition) {
        this.hp += addition;
    }

    public void minusHp(int minus) {
        this.hp -= minus;
    }

    public void addLevel(int addition) {
        this.level += addition;
    }

    public void minusLevel(int minus) {
        this.level -= minus;
    }

    public void addStats(Stats otherStats) {
        addLevel(otherStats.getLevel());
        addHp(otherStats.getHp());
        addDamage(otherStats.getDamage());
        addDefense(otherStats.getDefense());
        addDodge(otherStats.getDodge());
    }

    public void minusStats(Stats otherStats) {
        minusLevel(otherStats.getLevel());
        minusHp(otherStats.getHp());
        minusDamage(otherStats.getDamage());
        minusDefense(otherStats.getDefense());
        minusDodge(otherStats.getDodge());
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDodge() {
        return dodge;
    }

    public void setDodge(int dodge) {
        this.dodge = dodge;
    }
}
