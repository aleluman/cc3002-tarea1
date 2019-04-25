package cc3002.tarea1;

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
     *
     */
    void drawCard();

    /**
     *
     * @param card
     */
    void playCard(ICard card);

    /**
     *
     * @param pokemon
     */
    void selectActivePokemon(IPokemon pokemon);

    /**
     *
     * @return
     */
    IPokemon getActivePokemon();

    /**
     *
     * @param pokemon
     */
    void addPokemonToBench(IPokemon pokemon);

    /**
     *
     * @param pokemon
     */
    void selectAttack(IPokemon pokemon);
}
