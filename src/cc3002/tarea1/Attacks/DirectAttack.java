package cc3002.tarea1.Attacks;

import java.util.Map;

/**
 * class to represent an attack that does direct damage
 * @author Alejandro Lumán Bahamondes
 */
public abstract class DirectAttack extends AbstractAttack {
    /**
     * constructor for a direct attack
     * @param damage damage of the attack
     * @param name name of the attack
     * @param energies map with how many energies of each type the attack needs
     * @param description description of the attack
     */
    protected DirectAttack(int damage, String name, Map<String, Integer> energies, String description) {
        super(damage, name, energies, description);
    }

}
