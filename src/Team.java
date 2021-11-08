import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @className: Team
 * @description: class of Team, collection of heroes
 * @author: Yan Tong
 **/
public class Team extends Role implements TeamIterable{
    private List<Role> teamMember;

    public Team(int teamMemberNum) {
        teamMember = new ArrayList<>();
        for(int i = 0; i < teamMemberNum; i++) {
            teamMember.add(HeroFactory.getInstance().create());
        }
    }

    public void updatePosition(int[] position) {
        this.setPosition(position);
        for(TeamIterator it = teamIterator(); it.hasNext();) {
            Role role = it.next();
            role.setPosition(position);
        }
    }

    public void updatePosition(int row, int col) {
        updatePosition(new int[]{row, col});
    }

    @Override
    public TeamIterator teamIterator() {
        return new AllRoleIterator();
    }

    public TeamIterator aliveTeamIterator() {
        return new AliveRoleIterator();
    }

    private class AllRoleIterator implements TeamIterator {
        private int index;

        public AllRoleIterator() {
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < teamMember.size();
        }

        @Override
        public Role next() {
            return teamMember.get(index++);
        }

        @Override
        public void reset() {
            index = 0;
        }
    }


    private class AliveRoleIterator implements TeamIterator {
        int index;
        Set<Integer> notAlive;

        public AliveRoleIterator() {
            index = 0;
            notAlive = new HashSet<>();
        }

        @Override
        public boolean hasNext() {
            return notAlive.size() == teamMember.size();
        }

        @Override
        public Role next() {
            while (index < teamMember.size()) {
                while (index < index + teamMember.size()) {
                    int i = (index++) % teamMember.size();
                    Role role = teamMember.get(i);
                    if(role.getHp() <= 0) {
                        notAlive.add(i);
                    } else {
                        return role;
                    }
                }
            }
            return null;
        }

        @Override
        public void reset() {
            index = 0;
            notAlive.clear();
        }
    }
}
