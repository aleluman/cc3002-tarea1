package cc3002.tarea1;

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
}
