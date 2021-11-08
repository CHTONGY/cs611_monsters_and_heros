/**
 * @interfaceName: Sellable
 * @description: interface of sellable, classes implements this interface can be sold
 * @author: Yan Tong
 **/
public interface Sellable {
    int getPrice();
    void setPrice(int price);
    int getLevelReq();
    boolean sellTo(Buyable buyable);
}
