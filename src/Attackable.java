/**
 * @interfaceName: Attackable
 * @description: attackable interface, class implement this interface can attack
 * @author: Yan Tong
 **/
public interface Attackable {
    String getName();
    void attack(Role role);
    int getHp();
    void setHp(int hp);
    int getDamage();
    int getDefense();
}
