package cc3002.tarea1;

import cc3002.tarea1.IEnergy;
import cc3002.tarea1.ITrainer;
import cc3002.tarea1.IPokemon;

public abstract class AbstractEnergy implements IEnergy {
    private String name;
    private int type;

    protected AbstractEnergy(int type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public void addToPokemon(IPokemon pokemon) {
        pokemon.addEnergy(this);
    }

    @Override
    public int getType() {
        return this.type;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void playEffect(ITrainer trainer) {
        this.addToPokemon(trainer.getActivePokemon());
    }
}
