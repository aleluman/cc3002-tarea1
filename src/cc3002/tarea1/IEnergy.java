package cc3002.tarea1;

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

    /**
     * method to execute the effect of the card when it's played, in this
     * case, add energy to a pokemon
     * @param trainer the owner of the card on which the effect will happen
     */
    void playEffect(ITrainer trainer);
}
