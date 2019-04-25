package cc3002.tarea1;

/**
 * Interface to represent Energies (cost of the attacks of a pokemon).
 * @author Alejandro Lumán Bahamondes
 */
public interface IEnergy extends ICard {
    /**
     *
     * @param pokemon
     */
    void addToPokemon(IPokemon pokemon);

    /**
     *
     * @return
     */
    int getType();

    /**
     *
     * @return
     */
    String getName();

    /**
     *
     * @param trainer the owner of the card on which the effect will happen
     */
    void playEffect(ITrainer trainer);
}
