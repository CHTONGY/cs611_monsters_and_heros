/**
 * @className: Controller
 * @description: class of controller, to control the flow of logic
 * @author: Yan Tong
 **/
public class Controller {
    public static void control() {
        System.out.println("please enter number of heroes you want to play with: (1-3)");
        int teamMemberNum = ScanUtil.scanInt(1, 3);
        MonsterAndHeroGame game = new MonsterAndHeroGame(teamMemberNum);
        game.welcome();
        game.play();
    }
}
