/**
 * @className: Item
 * @description: class of item
 * @author: Yan Tong
 **/
public abstract class Item implements Sellable{
    private String name;
    private int price;
    private int minLevelReq;

    public abstract void use(Role role);

    public Item(String name, int price, int minLevelReq) {
        this.name = name;
        this.price = price;
        this.minLevelReq = minLevelReq;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getMinLevelReq() {
        return minLevelReq;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    public void setMinLevelReq(int minLevelReq) {
        this.minLevelReq = minLevelReq;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", minLevelReq=" + minLevelReq +
                '}';
    }

    @Override
    public int getLevelReq() {
        return minLevelReq;
    }

    @Override
    public void sellTo(Buyable buyable) {
        buyable.getInventory().addItem(this);
    }
}
