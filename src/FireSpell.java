/**
 * @className: FireSpell
 * @description: class of fire spell
 * @author: Yan Tong
 **/
public class FireSpell extends Spell{
    public FireSpell(String name, int price, int minLevelReq, int damage, int manaCost) {
        super(name, price, minLevelReq, damage, manaCost);
    }

    public FireSpell(String name, int price, int minLevelReq) {
        super(name, price, minLevelReq);
    }

    @Override
    public void use(Role role) {

    }

}
