package Service;

import Entity.Card;
import Entity.Colors;
import Entity.Numbers;
import Entity.Player;

import java.util.ArrayList;

public class MainClass {

    static final Card blackKing = new Card(Numbers.KING, Colors.CLUB);
    ArrayList<Player> players;

    public static void main(String[] args) {

        GameService game = new GameService();
        System.out.println("Generating a deck of cards:");
        game.createDeck();

        System.out.println();
        // Adding name for every player
        game.addPlayer("Sashko");
        game.addPlayer("Zarko");
        game.addPlayer("Dimce");
        game.addPlayer("Goran");

        System.out.println("The Players are:" + " " + game.getPlayers());
        System.out.println("\n");



        // Adding cards for every player
        System.out.println("Adding cards one by one to players: ");
        game.dealCards();

        System.out.println();
        System.out.println("Show List Of Cards for Every Player Without Double Card and number of cards in the List: ");
        game.getCardsOfPlayersWithoutDoubleCard();

        System.out.println();
        // main logic game
        int x = 0;
        int y = x + 1;
        while (game.getPlayers().size() != 1) {

            if (x > game.getPlayers().size() - 1) {
                x = 0;
            }

            if (x == game.getPlayers().size() - 1) {
                y = 0;
            }

            // Adding index and value for player
            Player player1 = game.getPlayers().get(x);
            Player player2 = game.getPlayers().get(y);

            game.getCardFromPLayer2AndPutInPlayer1(player1, player2);
            System.out.println();

            if (player1.getCards().size() == 0) {
                System.out.println("This player: " + player1.getName() + " his number of the cards is: " + player1.getCards().size() +
                        " and will be removed");
                game.getPlayers().remove(player1);
            }
            if (player1.getCards().size() == 1 && player1.getCards().contains(blackKing)) {
                System.out.println("This player: " + player1.getName() + " contain " + blackKing + " and is Looser");
            }

            if (player2.getCards().size() == 0) {
                System.out.println("This player: " + player2.getName() + " his number of the cards is: " + player2.getCards().size() +
                        " and will be removed");
                game.getPlayers().remove(player2);
            }

            if (player2.getCards().size() == 1 && player2.getCards().contains(blackKing)) {
                System.out.println("This player: " + player2.getName() + " contain " + blackKing + " and is Looser");
                break;
            }
            x++;
            y++;
        }
        System.out.println("Final list of players: " + " " + game.getPlayers());

    }
}



