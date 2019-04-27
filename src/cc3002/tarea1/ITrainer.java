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
     * @return
     */
    List<IPokemon> getBenchPokemon();

    /**
     *
     * @param index
     */
    void selectAttack(int index);

    /**
     *
     * @param pokemon
     */
    void addToBench(IPokemon pokemon);
}
