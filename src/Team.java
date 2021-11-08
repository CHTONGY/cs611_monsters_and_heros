import java.util.List;

/**
 * @className: Team
 * @description: class of Team, collection of heroes
 * @author: Yan Tong
 **/
public class Team extends Role implements TeamIterable{
    private List<Role> teamMember;

    public Team(int teamMemberNum) {
        for(int i = 0; i < teamMemberNum; i++) {
            teamMember.add(HeroFactory.getInstance().create());
        }
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

    // TODO;
    private class AliveRoleIterator implements TeamIterator {
        int index = 0;
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Role next() {
            return null;
        }

        @Override
        public void reset() {

        }
    }
}
