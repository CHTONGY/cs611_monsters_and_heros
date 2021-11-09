import java.util.ArrayList;
import java.util.List;

/**
 * @className: MonsterFactory
 * @description: factory of monster
 * @author: Yan Tong
 **/
public class MonsterFactory extends RoleFactory{
    private static MonsterFactory monsterFactory;
    private List<List<String>> dragonInfos;
    private List<List<String>> exoskeletonInfos;
    private List<List<String>> spiritInfos;

    private MonsterFactory() {
        dragonInfos = new ArrayList<>();
        exoskeletonInfos = new ArrayList<>();
        spiritInfos = new ArrayList<>();
        readMonsterInfos(dragonInfos, "Dragons.txt");
        readMonsterInfos(exoskeletonInfos, "Exoskeletons.txt");
        readMonsterInfos(spiritInfos, "Spirits.txt");
    }

    private void readMonsterInfos(List<List<String>> infos, String fileName) {
        String filePath = ReadFileUtil.configFileDir + fileName;
        List<String> wholeInfos = ReadFileUtil.readFile(filePath);
        for(String info : wholeInfos) {
            infos.add(ReadFileUtil.splitString(info, " "));
        }
    }

    // Name/level/damage/defense/dodge chance
    @Override
    public Role create() {
        while (true) {
            double randNum = Math.random();
            if(randNum < 0.3) {
                return createDragon();
            } else if(randNum < 0.6) {
                return createExoskeleton();
            } else if(randNum < 0.9) {
                return createSpirit();
            }
            // if randNum between 0.9 and 1, then discard current round
        }
    }

    public Role createDragon() {
        int index = (int)(Math.random() * dragonInfos.size());
        List<String> info = dragonInfos.get(index);
        String name = info.get(0);
        int level = Integer.valueOf(info.get(1));
        int damage = Integer.valueOf(info.get(2));
        int defense = Integer.valueOf(info.get(3));
        int dodgeChance = Integer.valueOf(info.get(4));
        return new Dragon(name, level, 100*level, damage, defense, dodgeChance, null);
    }

    public Role createExoskeleton() {
        int index = (int)(Math.random() * exoskeletonInfos.size());
        List<String> info = exoskeletonInfos.get(index);
        String name = info.get(0);
        int level = Integer.valueOf(info.get(1));
        int damage = Integer.valueOf(info.get(2));
        int defense = Integer.valueOf(info.get(3));
        int dodgeChance = Integer.valueOf(info.get(4));
        return new Exoskeleton(name, level, 100*level, damage, defense, dodgeChance, null);
    }

    public Role createSpirit() {
        int index = (int)(Math.random() * spiritInfos.size());
        List<String> info = spiritInfos.get(index);
        String name = info.get(0);
        int level = Integer.valueOf(info.get(1));
        int damage = Integer.valueOf(info.get(2));
        int defense = Integer.valueOf(info.get(3));
        int dodgeChance = Integer.valueOf(info.get(4));
        return new Spirit(name, level, 100*level, damage, defense, dodgeChance, null);
    }

    public static MonsterFactory getInstance() {
        if(monsterFactory == null) {
            monsterFactory = new MonsterFactory();
        }
        return monsterFactory;
    }
}
