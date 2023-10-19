import java.util.ArrayList;

public abstract class GamePlayer {
    String name;
	int playerType;
    double wager;
    double ogMoney;
    ArrayList<String> playersCards = new ArrayList<String>();

	public GamePlayer(String name, double wager, double ogMoney) {
		this.name = name;
        this.wager = wager;
        this.ogMoney = ogMoney;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPlayerType() {
		return playerType;
	}

    public void setPlayerType(int i){
        this.playerType = i;
    }

    public double getWager(){
        return wager;
    }

    public void setWager(double wager){
        this.wager = wager;
    }

    public double getOrgMoney(){
        return ogMoney;
    }

    public void setOrgMoney(double orgMoney){
        this.ogMoney = orgMoney;
    }

    //adds the card and suit of a card to the player's total cards list
    public void addPlayerCard(String s){
        playersCards.add(s);
    }

    //locates and returns the card and suit of a player's card from the player's total card list
    public String getPlayerCard(int index){
        return this.playersCards.get(index);
    }

    //clears the player's total card list
    public void resetPlayersCards(){
        this.playersCards.clear();
    }
	
	public abstract String greeting();
}

