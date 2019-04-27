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
     * getter for the damage of the attack
     * @return the damage of the attack
     */
    int getDamage();

    /**
     * getter for the name of the attack
     * @return the name of the attack
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
