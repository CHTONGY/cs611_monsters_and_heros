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
}
