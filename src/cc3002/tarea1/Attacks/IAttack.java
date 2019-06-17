package cc3002.tarea1.Attacks;

import cc3002.tarea1.Pokemon.IPokemon;
import cc3002.tarea1.Visitors.AttackVisitor;
import cc3002.tarea1.Visitors.CardVisitor;
import cc3002.tarea1.Visitors.IAttackVisitor;

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
     * returns a map containing the energies needed for the attack.
     * the map has the type of the energy as key and the quantity of that type
     * of energy as value.
     * @return map containing the type of energy and the quantity needed for the attack.
     */
    Map<String, Integer> getEnergiesNeeded();

    /**
     * getter for the description of the attack
     * @return the description of the attack
     */
    String getDescription();

    /**
     * method to check if the pokemon has enough energies for the attack.
     * @param pokemon pokemon to check
     * @return true if the pokemon has enough energies, false otherwise.
     */
    boolean hasEnergy(IPokemon pokemon);

    /**
     * Accept method for the different visitors
     * @param v visitor to perform an operation
     */
    void accept(IAttackVisitor v);
}
