import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @className: PotionFactory
 * @description: factory of potion
 * @author: Yan Tong
 **/
public class PotionFactory extends ItemFactory{
    private static PotionFactory potionFactory;
    private List<List<String>> potionInfos;
    private Map<String, Integer> attrIndexMap;

    private PotionFactory() {
        readPotionInfos();
        attrIndexMap = new HashMap<>();
        attrIndexMap.put("Health", 0);
        attrIndexMap.put("Mana", 1);
        attrIndexMap.put("Strength", 2);
        attrIndexMap.put("Dexterity", 3);
        attrIndexMap.put("Defense", 4);
        attrIndexMap.put("Agility", 5);
    }

    private void readPotionInfos() {
        String filePath = ReadFileUtil.configFileDir + "Potions.txt";
        potionInfos = new ArrayList<>();
        List<String> wholeInfos = ReadFileUtil.readFile(filePath);
        for(String info : wholeInfos) {
            potionInfos.add(ReadFileUtil.splitString(info, " "));
        }
    }

    // Health/Mana/Strength/Dexterity/Defense/Agility
    @Override
    public Item create() {
        int randNum = (int)(Math.random() * potionInfos.size());
        return create(randNum);
    }

    @Override
    public String getAllItemsInfo() {
        return getAllPotionInfos();
    }

    @Override
    public int getItemsSize() {
        return getAllPostionsSize();
    }

    public Item create(int index) {
        List<String> info = potionInfos.get(index);
        String name = info.get(0);
        int cost = Integer.valueOf(info.get(1));
        int reqLevel = Integer.valueOf(info.get(2));
        int attributeIncreaseVal = Integer.valueOf(info.get(3));
        String[] attributes = info.get(4).split("/");
        int[] attrIncrease = new int[6];
        for(String attr : attributes) {
            if(attr.equalsIgnoreCase("All")) {
                for(int i = 0; i < attrIncrease.length; i++) {
                    attrIncrease[i] = attributeIncreaseVal;
                    break;
                }
            }
            attrIncrease[attrIndexMap.get(attr)] = attributeIncreaseVal;
        }
        return new Potion(name, cost, reqLevel, attrIncrease);
    }

    public static PotionFactory getInstance() {
        if(potionFactory == null) {
            potionFactory = new PotionFactory();
        }
        return potionFactory;
    }

    private String getAllPotionInfos() {
        StringBuilder sb = new StringBuilder();
        sb.append("\tName/cost/required level/attribute increase/attribute affected\n");
        for(int i = 0; i < potionInfos.size(); i++) {
            sb.append(i).append("\t");
            List<String> info = potionInfos.get(i);
            for(String s : info) {
                sb.append(s).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private int getAllPostionsSize() {
        return potionInfos.size();
    }
}
