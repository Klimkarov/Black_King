package Service;

import Entity.Card;
import Entity.Colors;
import Entity.Numbers;
import Entity.Player;

import java.util.*;

public class GameService {

    private final ArrayList<Card> deck;
    private final ArrayList<Player> players;

    public GameService() {
        this.deck = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void createDeck() {
        // The first for is to split 2 decks
        for (int i = 0; i < 2; i++) {
            //Iteration of enum Entity.Numbers
            for (Numbers num : Numbers.values()) {
                //Iteration of enum Entity.Colors
                for (Colors color : Colors.values()) {
                    // Defining, filling the deck with numbers and color
                    Card cards = new Card(num, color);
                    // fill the deck without all the Kings, removing the Kings
                    if (num != Numbers.KING) {
                        deck.add(cards);
                    }
                    // Check if the num contain a King and it is black_Club, then add it to the deck
                    if (num == Numbers.KING && color == Colors.CLUB && !deck.contains(cards)) {
                        deck.add(cards);
                    }
                }
            }
        }
        // Mixed cards
        Collections.shuffle(deck);
        System.out.println(deck);
    }

    // Create player only with name
    public void addPlayer(String name) {
        Player player = new Player(name);
        this.players.add(player);
    }

    // Dealing cards for players, one by one for every player
    public void dealCards() {
        int i = 0;
        int numberOfDealing = 0;
        int temp = numberOfDealing;
        while (i < deck.size()) {
            numberOfDealing++;
            System.out.println();
            System.out.println(numberOfDealing + " Dealing cards: ");
            for (Player player_i : players) {
                Card card = deck.get(i);
                if (player_i.getCards().contains(card)) {
                    // Instatly delete card if present in cards of player
                    player_i.getCards().remove(card);
                } else {
                    player_i.addCard(card);
                    System.out.println(player_i.getName() + " " + card.toString());
                }
                i++;
                if (i >= deck.size()) {
                    break;
                }
            }
        }
    }

    // Show the list of cards for every player
    public void getCardsOfPlayersWithoutDoubleCard() {
        for (Player player_i : players) {
            System.out.println(player_i + " " + player_i.getCards().size());
        }
    }


    public void getCardFromPLayer2AndPutInPlayer1(Player player1, Player player2) {

        // Get random card from player 2
        Card randomCard = player2.getRandomCard();
        System.out.println(player1.getName() + " pull the card: " + randomCard + " from " + player2.getName());

        // Removing the random card from player2
        player2.getCards().remove(randomCard);
        System.out.println("The new list for " + player2.getName() + " without " + randomCard + " is:");
        System.out.println(player2 + "  Number of cards: " + player2.getCards().size());

        // Add if not exist or remove if exist same card in player1
        if (player1.getCards().contains(randomCard)) {
            System.out.println("This card " + randomCard + " exist in the list of " + player1.getName() + " and will remove");
            player1.getCards().remove(randomCard);
        } else {
            System.out.println("Adding card: " + randomCard + " from: " + player2.getName() + " to " + player1.getName());
            player1.addCard(randomCard);
        }
        System.out.println("The new list for " + player1.getName() + " is " + player1 + "  Number of cards: " + player1.getCards().size());
    }

}











