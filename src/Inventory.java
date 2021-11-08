import java.util.ArrayList;
import java.util.List;

/**
 * @className: Inventory
 * @description: class of inventory, has collection of items
 * @author: Yan Tong
 **/
public class Inventory {
    private List<Item> inventoryList;

    public Inventory() {
        this.inventoryList = new ArrayList<>();
    }

    public void addItem(Item item) {
        inventoryList.add(item);
    }

    public void removeItem(Item item) {
        inventoryList.remove(item);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("inventory list:{\n");
        for(Item item : inventoryList) {
            sb.append(item).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}
