/**
 * @className: Potion
 * @description: class of potion
 * @author: Yan Tong
 **/
public class Potion extends Item{
    private Stats increaseStats;

    public Potion(String name, int price, int minLevelReq, Stats increaseStats) {
        super(name, price, minLevelReq);
        this.increaseStats = increaseStats;
    }


    @Override
    public void use(Role role) {
        role.getStats().addStats(increaseStats);
    }

    @Override
    public void sellTo(Buyable buyable) {

    }
}
