/**
 * @className: Fight
 * @description: monsters and heroes fight
 * @author: Yan Tong
 **/
public class Fight {
    private Team team1;
    private Team team2;

    public Fight(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public Team fight() {
        TeamIterator aliveIt1 = team1.aliveTeamIterator();
        TeamIterator aliveIt2 = team2.aliveTeamIterator();
        Role role1 = null;
        Role role2 = null;
        while (aliveIt1.hasNext() && aliveIt2.hasNext()) {
            role1 = aliveIt1.next();
            role2 = aliveIt2.next();

            role1.attack(role2);
            if (role2.getHp() <= 0) {
                role2 = aliveIt2.next();
            }
            role2.attack(role1);

        }
        if(role2 == null) {
            return team1;
        } else {
            return team2;
        }
    }
}
