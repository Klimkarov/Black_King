package Entity;

import java.util.ArrayList;
import java.util.Objects;

public class Card {

    private final Numbers numbers;
    private final Colors colors;


    public Card(Numbers numbers, Colors colors) {
        this.numbers = numbers;
        this.colors = colors;
    }

    // for better code, will show only the numbers and colors in String format
    @Override
    public String toString() {
        return this.numbers.toString() + "_" + this.colors.toString();
    }


    // I made this... when make comparison, to check exists card in the list or not
    // alt + insert = equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card deck = (Card) o;
        return this.numbers == deck.numbers && this.colors == deck.colors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers, colors);
    }
}
