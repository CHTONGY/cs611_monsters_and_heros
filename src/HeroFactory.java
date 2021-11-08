import java.util.ArrayList;
import java.util.List;

/**
 * @className: HeroFactory
 * @description: factory class of hero
 * @author: Yan Tong
 **/
public class HeroFactory extends RoleFactory{
    private static HeroFactory heroFactory;
    private List<List<String>> warriorInfos;
    private List<List<String>> sorcererInfos;
    private List<List<String>> paladinInfos;

    private HeroFactory() {
        readWarriorInfos();
        readSorcererInfos();
        readPaladinInfos();
    }

    private void readWarriorInfos() {
        String filePath = ReadFileUtil.configFileDir + "Warriors.txt";
        warriorInfos = new ArrayList<>();
        List<String> wholeInfos = ReadFileUtil.readFile(filePath);
        for(String info : wholeInfos) {
            warriorInfos.add(ReadFileUtil.splitString(info, " "));
        }
    }

    private void readSorcererInfos() {
        String filePath = ReadFileUtil.configFileDir + "Sorcerers.txt";
        sorcererInfos = new ArrayList<>();
        List<String> wholeInfos = ReadFileUtil.readFile(filePath);
        for(String info : wholeInfos) {
            sorcererInfos.add(ReadFileUtil.splitString(info, " "));
        }
    }

    private void readPaladinInfos() {
        String filePath = ReadFileUtil.configFileDir + "Paladins.txt";
        paladinInfos = new ArrayList<>();
        List<String> wholeInfos = ReadFileUtil.readFile(filePath);
        for(String info : wholeInfos) {
            paladinInfos.add(ReadFileUtil.splitString(info, " "));
        }
    }

    @Override
    public Role create() {
        while (true) {
            double randNum = Math.random();
            if(randNum < 0.3) {
                return createWarrior();
            } else if(randNum < 0.6) {
                return createSorcerer();
            } else if(randNum < 0.9) {
                return createPaladin();
            }
            // if randNum between 0.9 and 1, then discard current round
        }
    }

    public Role createWarrior() {
        int index = (int)(Math.random() * warriorInfos.size());
        List<String> info = warriorInfos.get(index);
        String name = info.get(0);
//       mana/strength/agility/dexterity/starting money/starting experience
        int[] startingIndices = new int[6];
        for(int i = 0; i < 6; i++) {
            startingIndices[i] = Integer.valueOf(info.get(i+1));
        }
        return new Warrior(name, createStats(), null,
                startingIndices[0], startingIndices[1],
                startingIndices[2], startingIndices[3],
                startingIndices[4], startingIndices[5],
                new Inventory());
    }

    public Role createSorcerer() {
        int index = (int)(Math.random() * sorcererInfos.size());
        List<String> info = sorcererInfos.get(index);
        String name = info.get(0);
//       mana/strength/agility/dexterity/starting money/starting experience
        int[] startingIndices = new int[6];
        for(int i = 0; i < 6; i++) {
            startingIndices[i] = Integer.valueOf(info.get(i+1));
        }
        return new Sorcerer(name, createStats(), null,
                startingIndices[0], startingIndices[1],
                startingIndices[2], startingIndices[3],
                startingIndices[4], startingIndices[5],
                new Inventory());
    }

    public Role createPaladin() {
        int index = (int)(Math.random() * paladinInfos.size());
        List<String> info = paladinInfos.get(index);
        String name = info.get(0);
//       mana/strength/agility/dexterity/starting money/starting experience
        int[] startingIndices = new int[6];
        for(int i = 0; i < 6; i++) {
            startingIndices[i] = Integer.valueOf(info.get(i+1));
        }
        return new Paladin(name, createStats(), null,
                startingIndices[0], startingIndices[1],
                startingIndices[2], startingIndices[3],
                startingIndices[4], startingIndices[5],
                new Inventory());
    }

    private Stats createStats() {
        return new Stats(1, 100, 0, 0, 0);
    }

    public static HeroFactory getInstance() {
        if(heroFactory == null) {
            heroFactory = new HeroFactory();
        }
        return heroFactory;
    }
}
