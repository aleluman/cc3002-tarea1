package cc3002.tarea1.Attacks;

import cc3002.tarea1.Pokemon.IPokemon;

import java.util.List;

public class AbstractAttack implements IAttack {
    private int damage;
    private String name;
    private List<String> energies;
    private String description;

    protected AbstractAttack(int damage, String name, List<String> energies, String description) {
        this.damage = damage;
        this.name = name;
        this.energies = energies;
        this.description = description;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<String> getEnergiesNeeded() {
        return this.energies;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public boolean haveEnergy(IPokemon pokemon) {
        return false;
    }
}
