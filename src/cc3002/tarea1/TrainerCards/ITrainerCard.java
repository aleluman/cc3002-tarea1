package cc3002.tarea1.TrainerCards;

import cc3002.tarea1.ICard;

/**
 * Interface to represent a trainer card
 * @author Alejandro Lumán Bahamondes
 */
public interface ITrainerCard extends ICard {
    /**
     * method to get the description of the card
     * @return the description of the card
     */
    String getDescription();
}
