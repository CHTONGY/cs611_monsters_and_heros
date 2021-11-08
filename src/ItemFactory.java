/**
 * @className: ItemFactory
 * @description: factory of item
 * @author: Yan Tong
 **/
public abstract class ItemFactory {
    public abstract Item create();
    public abstract String getAllItemsInfo();
    public abstract int getItemsSize();
}
