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
        warriorInfos = new ArrayList<>();
        List<String> wholeInfos = ReadFileUtil.readFile("../config_files/Warriors.txt");
        for(String info : wholeInfos) {
            warriorInfos.add(ReadFileUtil.splitString(info, " "));
        }
    }

    private void readSorcererInfos() {
        sorcererInfos = new ArrayList<>();
        List<String> wholeInfos = ReadFileUtil.readFile("../config_files/Sorcerers.txt");
        for(String info : wholeInfos) {
            sorcererInfos.add(ReadFileUtil.splitString(info, " "));
        }
    }

    private void readPaladinInfos() {
        paladinInfos = new ArrayList<>();
        List<String> wholeInfos = ReadFileUtil.readFile("../config_files/Paladins.txt");
        for(String info : wholeInfos) {
            paladinInfos.add(ReadFileUtil.splitString(info, " "));
        }
    }

    @Override
    public Role create() {
        return null;
    }

    public Role createWarrior() {

        return null;
    }

    public Role createSorcerer() {
        return null;
    }

    public Role createPaladin() {
        return null;
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
