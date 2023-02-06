package Entity;

import java.util.ArrayList;
import java.util.Random;

public class Player {

    private final String name;
    // each player will have more cards => list of cards
    private final ArrayList<Card> cards;

    /*there is no need to have ArrayList<Card> cards as an input parameter, the cards are already loaded from somewhere else,
    so I just set a name */
    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", cards=" + cards +
                '}';
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Card getRandomCard() {
        for (Card cardX : cards) {
            Random random = new Random();
            int randomX = new Random().nextInt(cards.size());
            return cards.get(randomX);
        }
        return null;
    }

    public Card getCard() {
        for (Card card : getCards()) {
            return card;
        }
        return null;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

}
