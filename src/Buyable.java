/**
 * @interfaceName: Buyable
 * @description: a class that can buy other items
 * @author: Yan Tong
 **/
public interface Buyable {
    Inventory getInventory();
    void buy(Sellable sellable);
    int getLevel();
    int getMoney();
    void setMoney(int money);
}
