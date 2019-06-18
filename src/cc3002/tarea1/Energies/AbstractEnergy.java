package cc3002.tarea1.Energies;

import cc3002.tarea1.Pokemon.IPokemon;
import cc3002.tarea1.ITrainer;
import cc3002.tarea1.Visitors.CardVisitor;

/**
 * Class to represent an arbitrary energy card
 * @author Alejandro Lumán Bahamondes
 */
public abstract class AbstractEnergy implements IEnergy {
    private String name;
    private ITrainer trainer;

    protected AbstractEnergy(String name, ITrainer trainer) {
        this.name = name;
        this.trainer = trainer;
    }

    @Override
    public void addToPokemon(IPokemon pokemon) {
        pokemon.addEnergy(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void accept(CardVisitor v) {
        v.visitEnergy(this);
    }

    @Override
    public ITrainer getTrainer() {
        return trainer;
    }
}
