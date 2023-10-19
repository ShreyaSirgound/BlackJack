
public class RiskyPlayer extends GamePlayer{
    public RiskyPlayer(String name, double wager, double orgMoney) {
        super(name, wager, orgMoney);
    }
    public String greeting() {
        return "risky";
    }
}
