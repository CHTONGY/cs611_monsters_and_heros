/**
 * @className: Role
 * @description: role class in game
 * @author: Yan Tong
 **/
public abstract class Role {
    private String name;
    private Stats stats;
    private int[] position;

    public Role() {
    }

    public Role(String name, Stats stats, int[] position) {
        this.name = name;
        this.stats = stats;
        this.position = position;
    }

    public Role(String name, int level, int hp, int damage, int defense, int dodge, int[] position) {
        this.name = name;
        this.stats = new Stats(level, hp, damage, defense, dodge);
        this.position = position;
    }

    public void addLevel(int addition) {
        this.stats.addLevel(addition);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return stats.getLevel();
    }

    public void setLevel(int level) {
        stats.setLevel(level);
    }

    public int getHp() {
        return stats.getHp();
    }

    public void setHp(int hp) {
        stats.setHp(hp);
    }

    public int getDamage() {
        return stats.getDamage();
    }

    public void setDamage(int damage) {
        stats.setDamage(damage);
    }

    public int getDefense() {
        return stats.getDefense();
    }

    public void setDefense(int defense) {
        stats.setDefense(defense);
    }

    public int getDodge() {
        return stats.getDodge();
    }

    public void setDodge(int dodge) {
        stats.setDodge(dodge);
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public int getRow() {
        return position[0];
    }

    public void setRow(int row) {
        this.position[0] = row;
    }

    public int getCol() {
        return position[1];
    }

    public void setCol(int col) {
        this.position[1] = col;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }
}
