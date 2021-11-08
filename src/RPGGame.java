/**
 * @className: RPGGame
 * @description: class of rpg game
 * @author: Yan Tong
 **/
public abstract class RPGGame extends Game{
    private Team team;

    public RPGGame() {
    }

    public RPGGame(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
