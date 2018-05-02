public class DeckTest{
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.createDeck();
        deck.shuffle();
        deck.showShuffle();
        deck.deal();
        deck.deal();
    }
}