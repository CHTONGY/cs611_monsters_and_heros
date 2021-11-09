/**
 * @className: CommonPlace
 * @description: common cell on grid, can pass and meet monster
 * @author: Yan Tong
 **/
public class CommonCell extends Cell{
    public CommonCell(int[] position) {
        super(position);
    }

    public CommonCell(int row, int col) {
        super(row, col);
    }

    @Override
    public void comeTo(Team team) {
        team.updatePosition(this.getPosition());

        // 0.6 of 1 meet monster
        if(Math.random() < 0.7) {
            Team monsterTeam = createMonsterTeam(team.getTeamMemberNum());
            Fight fight = new Fight(team, monsterTeam);
            Team winTeam = fight.fight();
            if(winTeam == monsterTeam) {
                System.out.println("monster team win, all heroes die. game over");
                System.out.println("thanks for your playing");
                System.exit(0);
            } else {
                System.out.println("hero team win, reward heroes.");
                rewardTeam(team);
            }
        }
    }

    private void rewardTeam(Team team) {
        for(TeamIterator aliveIt = team.aliveTeamIterator(); aliveIt.hasNext();) {
            rewardRole(aliveIt.next());
        }
        for(TeamIterator it = team.teamIterator(); it.hasNext();) {
            recoverRole(it.next());
        }
    }

    private void recoverRole(Role role) {
        Hero hero = (Hero) role;
        if(hero.getHp() <= 0) {
            hero.setHp(50 * hero.getLevel());
        } else {
            hero.setHp((int)(hero.getHp() * 1.1));
        }
        hero.setMana((int)(hero.getMana() * 1.1));
        System.out.printf("recover %s, now hp: %d, mana: %d\n",
                role.getName(), hero.getHp(), hero.getMana());
    }

    private void rewardRole(Role role) {
        Hero hero = (Hero) role;
        int moneyAddition = 100 * hero.getLevel();
        hero.addMoney(moneyAddition);
        hero.addExp(2);
        System.out.printf("%s gain %d money, 2 exp.\n", role.getName(), moneyAddition);
    }

    private Team createMonsterTeam(int teamMember) {
        Team monsterTeam = new Team();
        for(int i = 0; i < teamMember; i++) {
            Role role = MonsterFactory.getInstance().create();
            monsterTeam.addTeamMember(role);
        }
        monsterTeam.updatePosition(getPosition());
        return monsterTeam;
    }

    @Override
    public String toString() {
        return " ";
    }
}
