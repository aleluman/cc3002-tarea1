package cc3002.tarea1;

import cc3002.tarea1.Visitors.CardVisitor;

/**
 * Interface to represent a controller for the game that allows two trainers to play
 * @author Alejandro Lumán Bahamondes
 */
public interface IController {
    /**
     * method to draw a card from a trainer's deck and put it into it's hand
     */
    void drawCard();

    /**
     * method to play the current trainer's selected card
     */
    void playCard();

    /**
     * method to select the card to be played
     * @param index index of the card on the hand
     */
    void selectCard(int index);

    /**
     * method to use the ability of the current active pokemon of the active trainer
     */
    void useAbility();

    /**
     * method to attack the opponent active pokemon
     */
    void attack();

    /**
     * method to end the current player's turn
     */
    void endPlayerTurn();
}
