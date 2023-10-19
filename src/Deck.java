import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {
	//creates and populates the initial deck
	String[] card = new String[52];
	String[] suit = new String[52];
	int[] cardValue = new int[52];
	Integer[] deckIndexes = new Integer[52];

	public Deck(String[] card, String[] suit, int[] cardValue, Integer[] deckIndexes) {
		this.card = card;
		this.suit = suit;
		this.cardValue = cardValue;
		this.deckIndexes = deckIndexes;
	}

	public void printDeck(Integer[] deckIndexes) {
		for (int i = 0; i < 52; i++) {
			System.out.print(card[deckIndexes[i]] + "" + suit[deckIndexes[i]] + " ");
		}
	}

	public Integer[] shuffleDeck(Integer[] deckIndexes){
		List<Integer> deckList = Arrays.asList(deckIndexes);
		Collections.shuffle(deckList);
		this.deckIndexes = deckList.toArray(deckIndexes);
		return deckIndexes;
	}

	public String getCardById(int i){
		String s = card[i] + "" + suit[i];
		return s;
	}
}
