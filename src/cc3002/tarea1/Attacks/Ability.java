package cc3002.tarea1.Attacks;

import cc3002.tarea1.Pokemon.IPokemon;
import cc3002.tarea1.Visitors.IAttackVisitor;

import java.util.HashMap;

/**
 * class to represent an ability of the pokemon
 * @author Alejandro Lumán Bahamondes
 */
public abstract class Ability extends AbstractAttack {
    private String name;
    private String description;

    /**
     * constructor for an abstract ability
     * @param name the ability's name
     * @param description the ability's description
     */
    protected Ability(String name, String description) {
        super(0, name, new HashMap<>(), description);
    }

    @Override
    public int getDamage() {
        return 0;
    }

    @Override
    public boolean hasEnergy(IPokemon pokemon) {
        return true;
    }
}
