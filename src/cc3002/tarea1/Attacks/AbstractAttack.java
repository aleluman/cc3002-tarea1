package cc3002.tarea1.Attacks;

import cc3002.tarea1.Pokemon.IPokemon;
import cc3002.tarea1.Visitors.AttackVisitor;
import cc3002.tarea1.Visitors.CardVisitor;
import cc3002.tarea1.Visitors.IAttackVisitor;

import java.util.Map;

/**
 * Class to represent an arbitrary attack
 * @author Alejandro Lumán Bahamondes
 */
public abstract class AbstractAttack implements IAttack {
    private int damage;
    private String name;
    private Map<String, Integer> energies;
    private String description;

    protected AbstractAttack(int damage, String name, Map<String, Integer> energies, String description) {
        this.damage = damage;
        this.name = name;
        this.energies = energies;
        this.description = description;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Map<String, Integer> getEnergiesNeeded() {
        return energies;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean hasEnergy(IPokemon pokemon) {
        Map<String, Integer> energyList = pokemon.getEnergies();
        if (energyList.isEmpty())
            return false;
        for (String energy : energies.keySet()) {
            if (energyList.get(energy) < energies.get(energy))
                return false;
        }
        return true;
    }

    @Override
    public abstract void accept(IAttackVisitor v);
}
