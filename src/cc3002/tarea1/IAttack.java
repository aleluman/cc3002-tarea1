package cc3002.tarea1;

import cc3002.tarea1.IPokemon;

import java.util.List;
import java.util.Map;

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
    Map<String, Integer> getEnergiesNeeded();

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
