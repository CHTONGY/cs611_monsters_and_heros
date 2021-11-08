import java.util.ArrayList;
import java.util.List;

/**
 * @className: WeaponFactory
 * @description: factory of weapon
 * @author: Yan Tong
 **/
public class WeaponFactory extends ItemFactory{
    private static WeaponFactory weaponFactory;
    private List<List<String>> weaponInfos;

    private WeaponFactory() {
        readWeaponInfos();
    }

    private void readWeaponInfos() {
        String filePath = ReadFileUtil.configFileDir + "Weaponry.txt";
        List<String> wholeInfos = ReadFileUtil.readFile(filePath);
        weaponInfos = new ArrayList<>();
        for(String info : wholeInfos) {
            weaponInfos.add(ReadFileUtil.splitString(info, " "));
        }
    }

    // Name/cost/level/damage/required hands
    @Override
    public Item create() {
        int randNum = (int)(Math.random() * weaponInfos.size());
        return create(randNum);
    }

    @Override
    public String getAllItemsInfo() {
        return getAllWeaponInfos();
    }

    @Override
    public int getItemsSize() {
        return getAllWeaponInfosSize();
    }

    public Item create(int index) {
        List<String> info = weaponInfos.get(index);
        String name = info.get(0);
        int cost = Integer.valueOf(info.get(1));
        int reqLevel = Integer.valueOf(info.get(2));
        int damage = Integer.valueOf(info.get(3));
        int handsReq = Integer.valueOf(info.get(4));
        return new Weapon(name, cost, reqLevel, damage, handsReq);
    }

    public static WeaponFactory getInstance() {
        if(weaponFactory == null) {
            weaponFactory = new WeaponFactory();
        }
        return weaponFactory;
    }

    private String getAllWeaponInfos() {
        StringBuilder sb = new StringBuilder();
        sb.append("\tName/cost/level/damage/required hands\n");
        for(int i = 0; i < weaponInfos.size(); i++) {
            sb.append(i).append("\t");
            List<String> info = weaponInfos.get(i);
            for(String s : info) {
                sb.append(s).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private int getAllWeaponInfosSize() {
        return weaponInfos.size();
    }
}
