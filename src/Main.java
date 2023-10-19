import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println(Jokes.loadJokes());
		Scanner scan = new Scanner(System.in);
	
	//creates and populates the initial deck
		String[] card = new String[52];
		String[] suit = new String[52];
		int[] cardValue = new int[52];
		Integer[] deck = new Integer[52];
		
		//populates the array that will act as the deck (through indexes)
		//these indexes will later be shuffled and used to reference the arrays holding the various card values and characteristics
		for (int i = 0; i < 52; i++) {
			deck[i] = i;
		}
		
		String[] possibleCards = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		String[] possibleSuits = {"\u2665", "\u2666", "\u2663", "\u2660"};
		
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j <= 13; j++) {
				card[(j-1) + (i*13)] = possibleCards[j-1];
				suit[(j-1) + (i*13)] = possibleSuits[i];
				
				if(card[(j-1) + (i*13)] == "K" || card[(j-1) + (i*13)] == "Q" || card[(j-1) + (i*13)] == "J") {
					cardValue[(j-1) + (i*13)] = 10;
				} else {
					cardValue[(j-1) + (i*13)] = j;
				}
			}
		}
		Deck d = new Deck(card, suit, cardValue, deck);
		
		System.out.println("Original Deck:");
		d.printDeck(deck);
		System.out.println();
	
		//converts the deck to a list, shuffles elements, and converts back into an array
		System.out.println("Shuffled Deck:");
		d.shuffleDeck(deck);
		d.printDeck(deck);
		System.out.println();
		System.out.println("--------------------------------------------");
		
	//gets initial information from all players
		System.out.println();
		System.out.print("How many players are there? ");
		int numPlayers = scan.nextInt();
		scan.nextLine();
		System.out.println();
		
		String[] names = new String[numPlayers]; //names of all players
		double[] ogMoney = new double[numPlayers]; //max amount of money any player can use throughout the game
		int[] playerType = new int[numPlayers]; //holds what type of player the user is
		ArrayList<GamePlayer> playersList = new ArrayList<GamePlayer>();
		
		for(int i = 0; i < numPlayers; i++) {
			try {
				System.out.println("For Player " + (i+1) + ":");
				System.out.print("What is your name?: ");
				String n = scan.nextLine();
				names[i] = n;
	
				System.out.print("How much money do you have?: ");
				double money = scan.nextDouble();
				scan.nextLine();
				ogMoney[i] = money;

				System.out.print("Are you a funny, angry, or risky player? [INPUT: 1, 2, 3] ");
				int a = scan.nextInt();
				scan.nextLine();

				if(a > 3 || a < 1){
					System.out.println("Information not inputted correctly. Please try again: " + "\n");
					i--;
				continue;
				}
				playerType[i] = a;

				//creates the player object
					GamePlayer player;
					switch (a){
						case 1:
							player = new FunnyPlayer(n, 0.0, money);
							player.setPlayerType(a);
							playersList.add(player);
							break;
						case 2:
							player = new AngryPlayer(n, 0.0, money);
							player.setPlayerType(a);
							playersList.add(player);
							break;
						case 3:
							player = new RiskyPlayer(n, 0.0, money);
							player.setPlayerType(a);
							playersList.add(player);
							break;
					}

				System.out.println();
			} catch (InputMismatchException e) {
				scan.nextLine();
				System.out.println("Information not inputted correctly. Please try again: " + "\n");
				i--;
				continue;
			}
		}
		GamePlayer dealer = new Dealer("Dealer", 0.0, 0.0); //the dealer that will be used throughout the game
		playersList.add(dealer);
		System.out.println("--------------------------------------------");
		
	//playing rounds
		ArrayList<Double> wagers = new ArrayList<Double>();
		
		System.out.println("ROUND 1");
		//takes the input for every player's wager for the round
		for(String n : names) {
			System.out.print(n + "'s wager: ");	
			wagers.add(scan.nextDouble());

		}
		System.out.println();

		for(int i = 0; i < playersList.size(); i++){
			for(int j = 0; j < 2; j++){
				playersList.get(i).addPlayerCard(d.getCardById(deck[51-(2*i)-j]));
			}
		}

		for(GamePlayer p : playersList){
			System.out.println(p.getName());
			for(int i = 0; i < 2; i++){
				System.out.println(p.getPlayerCard(i));
			}
		}
		
	}
}
