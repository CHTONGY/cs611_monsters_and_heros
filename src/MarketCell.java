/**
 * @className: MarketCell
 * @description: market cell on grid, can buy and sell items
 * @author: Yan Tong
 **/
public class MarketCell extends Cell{

    public MarketCell(int[] position) {
        super(position);

    }

    public MarketCell(int row, int col) {
        this(new int[]{row, col});
    }

    @Override
    public void comeTo(Team team) {
        welcome();
        listAllItems();
        for(TeamIterator it = team.teamIterator(); it.hasNext();) {
            Role role = it.next();
            System.out.println("buy for " + role.getName());
            buyFromMarket(role);
        }
    }

    private void buyFromMarket(Role role) {
        instruction();
        System.out.printf("money you have: %d, current level: %d\n",
                ((Hero) role).getMoney(), role.getLevel());
        String input = ScanUtil.scanString();
        while (true) {

            if(input.equalsIgnoreCase("q")) {
                break;
            } else if(input.equalsIgnoreCase("w")) {
                buyWeapon(role);
            } else if(input.equalsIgnoreCase("a")) {
                buyArmor(role);
            } else if(input.equalsIgnoreCase("p")) {
                buyPotion(role);
            } else if(input.equalsIgnoreCase("s")) {
                buySpell(role);
            } else {
                System.out.println("invalid input!");
            }
            instruction();
            System.out.printf("money you have: %d, current level: %d\n",
                    ((Hero) role).getMoney(), role.getLevel());
            input = ScanUtil.scanString();
        }
    }

    private void buySpell(Role role) {
        System.out.println("please enter the number of potion you want to buy:");
        String input = ScanUtil.scanString();
        while (true) {
            if(input.charAt(0) == 'f') {
                int index = Integer.valueOf(input.substring(1));
                FireSpell fp = (FireSpell) SpellFactory.getInstance().createFireSpell(index);
                fp.sellTo((Buyable) role);
                break;
            } else if(input.charAt(0) == 'i') {
                int index = Integer.valueOf(input.substring(1));
                IceSpell ip = (IceSpell) SpellFactory.getInstance().createIceSpell(index);
                ip.sellTo((Buyable) role);
                break;
            } else if(input.charAt(0) == 'l') {
                int index = Integer.valueOf(input.substring(1));
                LightningSpell lp = (LightningSpell) SpellFactory.getInstance().createLightningSpell(index);
                lp.sellTo((Buyable) role);
                break;
            } else {
                System.out.println("invalid input!");
                System.out.println("please enter the number of potion you want to buy:");
                input = ScanUtil.scanString();
            }
        }
    }

    private void buyPotion(Role role) {
        System.out.println("please enter the number of potion you want to buy:");
        int index = ScanUtil.scanInt(0, PotionFactory.getInstance().getItemsSize()-1);
        Potion potion = (Potion) PotionFactory.getInstance().create(index);
        boolean isSuccess = potion.sellTo((Buyable) role);
        if(!isSuccess) {
            System.out.println("cannot buy this potion: not enough money or level");
        } else {
            System.out.println("success!");
        }
    }

    private void buyArmor(Role role) {
        System.out.println("please enter the number of armor you want to buy:");
        int index = ScanUtil.scanInt(0, ArmorFactory.getInstance().getItemsSize()-1);
        Armor armor = (Armor) ArmorFactory.getInstance().create(index);
        boolean isSuccess = armor.sellTo((Buyable) role);
        if(!isSuccess) {
            System.out.println("cannot buy this armor: not enough money or level");
        } else {
            System.out.println("success!");
        }
    }

    private void buyWeapon(Role role) {
        System.out.println("please enter the number of weapon you want to buy:");
        int index = ScanUtil.scanInt(0, WeaponFactory.getInstance().getItemsSize()-1);
        Weapon weapon = (Weapon) WeaponFactory.getInstance().create(index);
        boolean isSuccess = weapon.sellTo((Buyable) role);
        if(!isSuccess) {
            System.out.println("cannot buy this weapon: not enough money or level");
        } else {
            System.out.println("success!");
        }
    }

    private void instruction() {
        System.out.println("Please enter category you want to buy. " +
                "'w' for weapon, " +
                "'a' for armor, " +
                "'p' for potion, " +
                "'s' for spell, " +
                "'q' for quit.");
    }

    private void welcome() {
        System.out.println("welcome to shop, here are all you can buy");
    }

    private void listAllItems() {
        System.out.println("All weapons:");
        System.out.println(WeaponFactory.getInstance().getAllItemsInfo());
        System.out.println("All armors:");
        System.out.println(ArmorFactory.getInstance().getAllItemsInfo());
        System.out.println("All potions:");
        System.out.println(PotionFactory.getInstance().getAllItemsInfo());
        System.out.println("All spells:");
        System.out.println(SpellFactory.getInstance().getAllItemsInfo());
    }

    @Override
    public String toString() {
        return "M";
    }
}
