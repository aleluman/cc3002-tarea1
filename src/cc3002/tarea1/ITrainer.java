package cc3002.tarea1;

import cc3002.tarea1.Pokemon.IPokemon;
import cc3002.tarea1.Visitors.CardVisitor;

import java.util.List;

/**
 * Interface to represent the players of the game.
 *
 * @author Alejandro Lumán Bahamondes
 */
public interface ITrainer {
    /**
     * getter for the trainer's name
     * @return the trainer's name
     */
    String getName();

    /**
     * method to select a pokemon to become the active pokemon
     * @param pokemon the pokemon that will be switched to active
     */
    void selectActivePokemon(IPokemon pokemon);

    /**
     * getter for the current active pokemon
     * @return the current active pokemon
     */
    IPokemon getActivePokemon();

    /**
     * getter for the current selected pokemon
     * @return the current selected pokemon
     */
    IPokemon getSelectedPokemon();

    /**
     * getter for the hand of cards
     * @return  list with the cards in the trainer's hand
     */
    List<ICard> getHand();

    /**
     * getter for the deck of cards
     * @return  list with the cards in the trainer's deck
     */
    List<ICard> getDeck();

    /**
     * getter for the list of pokemon in the bench
     * @return a list of pokemon in the bench, the maximum should be 5
     */
    List<IPokemon> getBenchPokemon();

    /**
     * method to select an attack from the current active pokemon
     * @param index the index of the attack on the attack list of the pokemon
     */
    void selectAttack(int index);

    /**
     * method to replace a pokemon whose received damage is greater than its HP
     */
    void replaceDeadPokemon();

    /**
     * method to add a pokemon to the bench
     * @param pokemon pokemon to be added to the bench
     */
    void addToBench(IPokemon pokemon);

    /**
     * method to add a card to the trainer's hand
     * @param card the card to be added to the hand
     */
    void addToHand(ICard card);

    /**
     * method to get the selected card from the trainer's hand
     * @return the selected card
     */
    ICard getSelectedCard();

    /**
     * method to set the selected card from the trainer's hand
     * @param index the index of the selected card from the list of cards
     */
    void setSelectedCard(int index);

    /**
     * method to set the selected pokemon from the trainer's bench
     * @param pokemon the selected pokemon from the bench
     */
    void setSelectedPokemon(IPokemon pokemon);

    /**
     * method to move a card to the discard pile
     * @param card the card to be moved
     * @param cardList the list of cards to remove the card from
     */
    void moveToDiscardPile(List<ICard> cardList, ICard card);

    /**
     * method to add a card to the discard pile
     * @param card card to be added to the discard pile
     */
    void addToDiscardPile(ICard card);
}
