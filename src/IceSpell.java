/**
 * @className: IceSpell
 * @description: class of ice spell
 * @author: Yan Tong
 **/
public class IceSpell extends Spell{
    public IceSpell(String name, int price, int minLevelReq, int damage, int manaCost) {
        super(name, price, minLevelReq, damage, manaCost);
    }

    public IceSpell(String name, int price, int minLevelReq) {
        super(name, price, minLevelReq);
    }

    @Override
    public void use(Role role) {

    }

}
