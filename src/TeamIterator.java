/**
 * @interfaceName: TeamIterator
 * @description: to iterate role in team
 * @author: Yan Tong
 **/
public interface TeamIterator {
    boolean hasNext();
    Role next();
    void reset();
}
