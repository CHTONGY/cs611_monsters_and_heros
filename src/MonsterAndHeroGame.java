/**
 * @className: MonsterAndHeroGame
 * @description: class of monster and hero
 * @author: Yan Tong
 **/
public class MonsterAndHeroGame extends RPGGame{
    private Grid grid;
    private Team team;

    public MonsterAndHeroGame(int teamMemberNum) {
        super();
        this.team = new Team(teamMemberNum);
        this.grid = new Grid(8,8, team);
        this.grid.initHeroesPosition();
    }

    @Override
    public void play() {
        boolean flag = true;
        while (flag) {
            grid.printGrid();
            handleControlInput();
        }
    }

    @Override
    public void welcome() {
        System.out.println("Welcome to Monsters and Heroes.");
        System.out.println(instruction());
    }

    public String instruction() {
        return "Please use w,a,s,d to control movement. " +
                "Enter i to see inventory. " +
                "Enter q to quit game.";
    }

    private void handleControlInput() {
        System.out.println(instruction());
//        System.out.print("please enter: ");
        String input = ScanUtil.scanString();
        while (true) {
            if(input.equalsIgnoreCase("q")) {
                System.out.println("thank you for your playing!");
                System.exit(0);
            } else if(input.equalsIgnoreCase("w") ||
                    input.equalsIgnoreCase("a") ||
                    input.equalsIgnoreCase("s") ||
                    input.equalsIgnoreCase("d")) {
                handleMovement(input);
                break;
            } else if(input.equalsIgnoreCase("i")) {
                showTeamInventory();
                break;
            } else {
                System.out.println("invalid input!");
                System.out.println(instruction());
//                System.out.println("please enter: ");
                input = ScanUtil.scanString();
            }
        }
    }

    private void showTeamInventory() {
        for(TeamIterator it = team.teamIterator(); it.hasNext();) {
            Hero hero = (Hero) it.next();
            System.out.print(hero.getName() + " ");
            System.out.println(hero.getInventory());
        }
    }

    private void handleMovement(String movement) {
        int destineRow = team.getRow();
        int destineCol = team.getCol();
        if(movement.equalsIgnoreCase("w")) {
            // move up
            destineRow -= 1;
        } else if(movement.equalsIgnoreCase("a")) {
            // move left
            destineCol -= 1;
        } else if(movement.equalsIgnoreCase("s")) {
            // move down
            destineRow += 1;
        } else {
            // move right
            destineCol += 1;
        }
        if(!isValidPlace(destineRow, destineCol)) {
            System.out.println("invalid movement, out of grid!");
        } else {
            grid.getCell(destineRow, destineCol).comeTo(team);
        }
    }

    private boolean isValidPlace(int row, int col) {
        return row >= 0 && row < grid.getRow() &&
                col >= 0 && col < grid.getCol();
    }
}
