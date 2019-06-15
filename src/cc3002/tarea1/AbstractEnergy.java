package cc3002.tarea1;

import cc3002.tarea1.Visitors.Visitor;

/**
 * Class to represent an arbitrary energy card
 * @author Alejandro Lumán Bahamondes
 */
public abstract class AbstractEnergy implements IEnergy {
    private String name;

    protected AbstractEnergy(String name) {
        this.name = name;
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
    public void playEffect(ITrainer trainer) {
        addToPokemon(trainer.getActivePokemon());
    }

    @Override
    public void accept(Visitor v) {
        v.visitEnergy(this);
    }
}
