package cc3002.tarea1.Energies;

import cc3002.tarea1.ICard;
import cc3002.tarea1.Pokemon.IPokemon;
import cc3002.tarea1.ITrainer;

/**
 * Interface to represent Energies (cost of the attacks of a pokemon).
 * @author Alejandro Lumán Bahamondes
 */
public interface IEnergy extends ICard {
    /**
     * method to add energy values to a pokemon
     * @param pokemon the pokemon to add energy to
     */
    void addToPokemon(IPokemon pokemon);

    /**
     * getter for the name of the card
     * @return string with the name of the card
     */
    String getName();
}
