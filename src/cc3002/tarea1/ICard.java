package cc3002.tarea1;

import cc3002.tarea1.Visitors.CardVisitor;

/**
 * Interface to represent all types of cards for the game.
 * @author Alejandro Lumán Bahamondes
 */
public interface ICard {
    /**
     * Getter for the name of the card
     * @return the name of the card
     */
    String getName();

    /**
     * getter method for the pokemon trainer
     *
     * @return pokemon trainer
     */
    ITrainer getTrainer();

    /**
     * Accept method for the different visitors
     * @param v visitor to perform an operation
     */
    void accept(CardVisitor v);
}
