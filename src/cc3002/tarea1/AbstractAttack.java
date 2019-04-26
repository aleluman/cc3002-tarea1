package cc3002.tarea1;

import cc3002.tarea1.IAttack;
import cc3002.tarea1.IPokemon;

import java.util.List;

public abstract class AbstractAttack implements IAttack {
    private int damage;
    private String name;
    private int[] energies;
    private String description;

    protected AbstractAttack(int damage, String name, int[] energies, String description) {
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
    public int[] getEnergiesNeeded() {
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
