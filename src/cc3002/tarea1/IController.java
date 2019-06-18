package cc3002.tarea1;


/**
 * Interface to represent a controller for the game that allows two trainers to play
 *
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
     * method to select a card to perform an operation
     *
     * @param card the card to be selected
     */
    void selectCard(ICard card);

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

    /**
     * method to get the current active trainer
     * @return the active trainer
     */
    ITrainer getActiveTrainer();
}
