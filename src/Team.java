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

    public Team() {
        teamMember = new ArrayList<>();
    }

    public Team(int teamMemberNum) {
        this();
        for(int i = 0; i < teamMemberNum; i++) {
            teamMember.add(HeroFactory.getInstance().create());
        }
    }

    public void addTeamMember(Role role) {
        teamMember.add(role);
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

        public AliveRoleIterator() {
            index = 0;
        }

        @Override
        public boolean hasNext() {
            Role role = next();
            index--;
            return role != null;
        }

        @Override
        public Role next() {
            int upperBound = index + teamMember.size();
            while (index < upperBound) {
                int i = (index++) % teamMember.size();
                Role role = teamMember.get(i);
                if(role.getHp() > 0) {
                    return role;
                }
            }
            return null;
        }

        @Override
        public void reset() {
            index = 0;
        }
    }

    private class NotAliveRoleIterator implements TeamIterator {
        int index;
        int aliveCounter;
        int notAliveCounter;

        public NotAliveRoleIterator() {
            index = 0;
            for(Role role : teamMember) {
                if(role.getHp() > 0) {
                    aliveCounter++;
                }
            }
        }

        @Override
        public boolean hasNext() {
            return notAliveCounter + aliveCounter < getTeamMemberNum();
        }

        @Override
        public Role next() {
            while (index < teamMember.size()) {
                Role role = teamMember.get(index++);
                if(role.getHp() <= 0) {
                    notAliveCounter++;
                    return role;
                }
            }
            return null;
        }

        @Override
        public void reset() {
            index = 0;
            aliveCounter = 0;
            notAliveCounter = 0;
        }
    }

    public int getTeamMemberNum() {
        return teamMember.size();
    }
}
