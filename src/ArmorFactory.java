import java.util.ArrayList;
import java.util.List;

/**
 * @className: ArmorFactory
 * @description: factory of armor
 * @author: Yan Tong
 **/
public class ArmorFactory extends ItemFactory{
    private static ArmorFactory armorFactory;
    private List<List<String>> armorInfos;

    private ArmorFactory() {
        readArmorInfo();
    }

    private void readArmorInfo() {
        String filePath = ReadFileUtil.configFileDir + "Armory.txt";
        List<String> wholeInfos = ReadFileUtil.readFile(filePath);
        armorInfos = new ArrayList<>();
        for(String info : wholeInfos) {
            armorInfos.add(ReadFileUtil.splitString(info, " "));
        }
    }

    // Name/cost/required level/damage reduction
    @Override
    public Item create() {
        int randNum = (int)(Math.random() * armorInfos.size());
        return create(randNum);
    }

    @Override
    public String getAllItemsInfo() {
        return getAllArmorInfos();
    }

    @Override
    public int getItemsSize() {
        return getAllArmorInfosSize();
    }

    public Item create(int index) {
        List<String> info = armorInfos.get(index);
        String name = info.get(0);
        int cost = Integer.valueOf(info.get(1));
        int reqLevel = Integer.valueOf(info.get(2));
        int damageRed = Integer.valueOf(info.get(3));
        return new Armor(name, cost, reqLevel, damageRed);
    }

    public static ArmorFactory getInstance() {
        if(armorFactory == null) {
            armorFactory = new ArmorFactory();
        }
        return armorFactory;
    }

    private String getAllArmorInfos() {
        StringBuilder sb = new StringBuilder();
        sb.append("\tName/cost/required level/damage reduction\n");
        for(int i = 0; i < armorInfos.size(); i++) {
            sb.append(i).append("\t");
            List<String> info = armorInfos.get(i);
            for(String s : info) {
                sb.append(s).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private int getAllArmorInfosSize() {
        return armorInfos.size();
    }

}
