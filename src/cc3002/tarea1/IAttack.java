package cc3002.tarea1;

import cc3002.tarea1.IPokemon;

import java.util.List;

/**
 * Interface to represent the attacks of the pokemon.
 * @author Alejandro Lumán Bahamondes
 */
public interface IAttack {
    /**
     *
     * @return
     */
    int getDamage();

    /**
     *
     * @return
     */
    String getName();

    /**
     *
     * @return
     */
    List<String> getEnergiesNeeded();

    /**
     *
     * @return
     */
    String getDescription();

    /**
     *
     * @param pokemon
     * @return
     */
    boolean haveEnergy(IPokemon pokemon);
}
