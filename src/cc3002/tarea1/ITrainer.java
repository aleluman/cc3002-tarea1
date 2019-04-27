package cc3002.tarea1;

import java.util.List;

/**
 * Interface to represent the players of the game.
 *
 * @author Alejandro Lumán Bahamondes
 */
public interface ITrainer {
    /**
     *
     */
    void seeCards();

    /**
     * plays the card and its corresponding effect
     * @param card the card being played
     */
    void playCard(ICard card);

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
     * getter for the hand of cards
     * @return  list with the cards in the trainer's hand
     */
    List<ICard> getHand();

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
}
