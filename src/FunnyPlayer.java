
public class FunnyPlayer extends GamePlayer{
    public FunnyPlayer(String name, double wager, double orgMoney) {
        super(name, wager, orgMoney);
    }
    public String greeting() {
        return "funny";
    }
}
