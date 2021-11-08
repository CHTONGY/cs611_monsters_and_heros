/**
 * @className: LightningSpell
 * @description: class of lightning spell
 * @author: Yan Tong
 **/
public class LightningSpell extends Spell{
    public LightningSpell(String name, int price, int minLevelReq, int damage, int manaCost) {
        super(name, price, minLevelReq, damage, manaCost);
    }

    public LightningSpell(String name, int price, int minLevelReq) {
        super(name, price, minLevelReq);
    }

    @Override
    public void use(Role role) {

    }

}
