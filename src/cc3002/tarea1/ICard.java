package cc3002.tarea1;

import cc3002.tarea1.Visitors.Visitor;

/**
 * Interface to represent all types of cards for the game.
 * @author Alejandro Lumán Bahamondes
 */
public interface ICard {
    /**
     * Executes the effect of the card when it gets played, each type of card has it
     * own different effect on the game.
     * @param trainer the owner of the card on which the effect will happen
     */
    void playEffect(ITrainer trainer);

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
    void accept(Visitor v);
}
