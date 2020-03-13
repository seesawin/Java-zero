package javaLanguage.interfaces.defaultMethods.integratingDefaultMethodsIntoExistingLibraries;

import java.util.*;
import java.util.stream.Collectors;

public class StandardDeck implements Deck {
    private List<Card> entireDeck;

    public StandardDeck(List<Card> existingList) {
        this.entireDeck = existingList;
    }

    public StandardDeck() {
        this.entireDeck = new ArrayList<>();
        for (Card.Suit s : Card.Suit.values()) {
            for (Card.Rank r : Card.Rank.values()) {
                this.entireDeck.add(new PlayingCard(r, s));
            }
        }
    }

    public Deck deckFactory() {
        return new StandardDeck(new ArrayList<Card>());
    }

    public int size() {
        return entireDeck.size();
    }

    public List<Card> getCards() {
        return entireDeck;
    }

    public void addCard(Card card) {
        entireDeck.add(card);
    }

    public void addCards(List<Card> cards) {
        entireDeck.addAll(cards);
    }


    public void addDeck(Deck deck) {
        List<Card> listToAdd = deck.getCards();
        entireDeck.addAll(listToAdd);
    }

    @Override
    public int compareTo(Card o) {
        return 0;
    }


    /**
     * The method Collections.sort sorts an instance of List whose element type implements the interface Comparable.
     * The member entireDeck is an instance of List whose elements are of the type Card, which extends Comparable.
     */
    public void sort() {
        Collections.sort(entireDeck);
    }

    public void sort(Comparator<Card> c) {
        Collections.sort(entireDeck, c);
    }

    public void shuffle() {
        Collections.shuffle(entireDeck);
    }

    public Map<Integer, Deck> deal(int players, int numberOfCards)
            throws IllegalArgumentException {
        int cardsDealt = players * numberOfCards;
        int sizeOfDeck = entireDeck.size();
        if (cardsDealt > sizeOfDeck) {
            throw new IllegalArgumentException(
                    "Number of players (" + players +
                            ") times number of cards to be dealt (" + numberOfCards +
                            ") is greater than the number of cards in the deck (" +
                            sizeOfDeck + ").");
        }

        Map<Integer, List<Card>> dealtDeck = entireDeck
                .stream()
                .collect(
                        Collectors.groupingBy(
                                card -> {
                                    int cardIndex = entireDeck.indexOf(card);
                                    if (cardIndex >= cardsDealt) return (players + 1);
                                    else return (cardIndex % players) + 1;
                                }));

        // Convert Map<Integer, List<Card>> to Map<Integer, Deck>
        Map<Integer, Deck> mapToReturn = new HashMap<>();

        for (int i = 1; i <= (players + 1); i++) {
            Deck currentDeck = deckFactory();
            currentDeck.addCards(dealtDeck.get(i));
            mapToReturn.put(i, currentDeck);
        }
        return mapToReturn;
    }

    public String deckToString() {
        return this.entireDeck
                .stream()
                .map(Card::toString)
                .collect(Collectors.joining("\n"));
    }

    public static void main(String... args) {
        StandardDeck myDeck = new StandardDeck();
        System.out.println("Creating deck:");
        myDeck.sort();
        System.out.println("Sorted deck");
        System.out.println(myDeck.deckToString());
        System.out.println("----------------------------------------------------------------");
        myDeck.shuffle();
        myDeck.sort(new SortByRankThenSuit());
        System.out.println("Sorted by SortByRankThenSuit(customized comparator)");
        System.out.println(myDeck.deckToString());
        System.out.println("----------------------------------------------------------------");
        myDeck.shuffle();
        /**
         * To start, suppose that you want to sort the deck of playing cards by rank, regardless of suit.
         * You can invoke the StandardDeck.sort method as follows:
         * */
        myDeck.sort(
                (firstCard, secondCard) ->
                        firstCard.getRank().value() - secondCard.getRank().value()
        );
        System.out.println("Sorted by rank");
        System.out.println(myDeck.deckToString());
        System.out.println("----------------------------------------------------------------");
        myDeck.shuffle();
        myDeck.sort(
                (firstCard, secondCard) -> {
                    int compare =
                            firstCard.getRank().value() - secondCard.getRank().value();
                    if (compare != 0)
                        return compare;
                    else
                        return firstCard.getSuit().value() - secondCard.getSuit().value();
                }
        );
        System.out.println("Sorted by rank, then by suit");
        System.out.println(myDeck.deckToString());
        System.out.println("----------------------------------------------------------------");
        /**
         * This invocation better demonstrates what to sort rather than how to do it.
         * */
        System.out.println("Sorted by rank, then by suit");
        myDeck.shuffle();
        myDeck.sort(
                Comparator.comparing(Card::getRank)
                        .thenComparing(Comparator.comparing(Card::getSuit)));
        System.out.println("Sorted by rank, then by suit with static and default methods");
        System.out.println(myDeck.deckToString());
        System.out.println("----------------------------------------------------------------");
        myDeck.sort(
                Comparator.comparing(Card::getRank)
                        .reversed()
                        .thenComparing(Comparator.comparing(Card::getSuit)));
        System.out.println("Sorted by rank reversed, then by suit static and default methods");
        System.out.println(myDeck.deckToString());
        System.out.println("----------------------------------------------------------------");
    }
}
