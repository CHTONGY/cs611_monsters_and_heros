/**
 * @className: Spell
 * @description: class of spell
 * @author: Yan Tong
 **/
public abstract class Spell extends Item{

    public Spell(String name, int price, int minLevelReq) {
        super(name, price, minLevelReq);
    }
}
