import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: SpellFactory
 * @description: factory of spell
 * @author: Yan Tong
 **/
public class SpellFactory extends ItemFactory{
    private static SpellFactory spellFactory;
    private List<List<String>> fireSpellInfos;
    private List<List<String>> iceSpellInfos;
    private List<List<String>> lightningSpellInfos;

    private SpellFactory() {
        fireSpellInfos = new ArrayList<>();
        iceSpellInfos = new ArrayList<>();
        lightningSpellInfos = new ArrayList<>();
        readSpellInfos(fireSpellInfos, "FireSpells.txt");
        readSpellInfos(iceSpellInfos, "IceSpells.txt");
        readSpellInfos(lightningSpellInfos, "LightningSpells.txt");
    }

    private void readSpellInfos(List<List<String>> infos, String fileName) {
        String filePath = ReadFileUtil.configFileDir + fileName;
        List<String> wholeInfos = ReadFileUtil.readFile(filePath);
        for(String info : wholeInfos) {
            infos.add(ReadFileUtil.splitString(info, " "));
        }
    }

    // Name/cost/required level/damage/mana cost
    @Override
    public Item create() {
        return null;
    }

    @Override
    public String getAllItemsInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("\tName/cost/required level/damage/mana cost\n");
        for(int i = 0; i < fireSpellInfos.size(); i++) {
            sb.append("f").append(i).append("\t");
            List<String> info = fireSpellInfos.get(i);
            for(String s : info) {
                sb.append(s).append("\t");
            }
            sb.append("\n");
        }
        for(int i = 0; i < iceSpellInfos.size(); i++) {
            sb.append("i").append(i).append("\t");
            List<String> info = iceSpellInfos.get(i);
            for(String s : info) {
                sb.append(s).append("\t");
            }
            sb.append("\n");
        }
        for(int i = 0; i < lightningSpellInfos.size(); i++) {
            sb.append("l").append(i).append("\t");
            List<String> info = lightningSpellInfos.get(i);
            for(String s : info) {
                sb.append(s).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public int getItemsSize() {
        return fireSpellInfos.size() + lightningSpellInfos.size() + iceSpellInfos.size();
    }

    public Item createFireSpell(int index) {
        List<String> info = fireSpellInfos.get(index);
        String name = info.get(0);
        int cost = Integer.valueOf(info.get(1));
        int levelReq = Integer.valueOf(info.get(2));
        int damage = Integer.valueOf(info.get(3));
        int manaCost = Integer.valueOf(info.get(4));
        return new FireSpell(name, cost, levelReq, damage, manaCost);
    }

    public Item createIceSpell(int index) {
        List<String> info = iceSpellInfos.get(index);
        String name = info.get(0);
        int cost = Integer.valueOf(info.get(1));
        int levelReq = Integer.valueOf(info.get(2));
        int damage = Integer.valueOf(info.get(3));
        int manaCost = Integer.valueOf(info.get(4));
        return new IceSpell(name, cost, levelReq, damage, manaCost);
    }

    public Item createLightningSpell(int index) {
        List<String> info = lightningSpellInfos.get(index);
        String name = info.get(0);
        int cost = Integer.valueOf(info.get(1));
        int levelReq = Integer.valueOf(info.get(2));
        int damage = Integer.valueOf(info.get(3));
        int manaCost = Integer.valueOf(info.get(4));
        return new LightningSpell(name, cost, levelReq, damage, manaCost);
    }

    public static SpellFactory getInstance() {
        if(spellFactory == null) {
            spellFactory = new SpellFactory();
        }
        return spellFactory;
    }

    public int getFireSpellSize() {
        return fireSpellInfos.size();
    }

    public int getIceSpellSize() {
        return iceSpellInfos.size();
    }

    public int getLightningSpellSize() {
        return lightningSpellInfos.size();
    }
}
