package cc3002.tarea1;

import cc3002.tarea1.IAttack;
import cc3002.tarea1.IPokemon;

import java.util.List;
import java.util.Map;

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
        return this.damage;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Map<String, Integer> getEnergiesNeeded() {
        return this.energies;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public boolean haveEnergy(IPokemon pokemon) {
        if (pokemon.getEnergies().get("All") >= energies.get("All")) {
            if (pokemon.getEnergies().get("Grass") >= energies.get("Grass")) {
                if (pokemon.getEnergies().get("Fire") >= energies.get("Fire")) {
                    if (pokemon.getEnergies().get("Water") >= energies.get("Water")) {
                        if (pokemon.getEnergies().get("Psychic") >= energies.get("Psychic")) {
                            if (pokemon.getEnergies().get("Fighting") >= energies.get("Fighting")) {
                                if (pokemon.getEnergies().get("Lightning") >= energies.get("Lightning")) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
