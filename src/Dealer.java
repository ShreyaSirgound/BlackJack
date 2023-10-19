public class Dealer extends GamePlayer{
    public Dealer(String name, double wager, double orgMoney) {
        super("Dealer", 0.0, 0.0);
    }
    public String greeting() {
        return "im the dealer";
    }
}
