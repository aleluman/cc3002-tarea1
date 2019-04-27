package cc3002.tarea1;

import java.util.List;

public class Trainer implements ITrainer {
    private String name;
    private List<ICard> hand;
    private List<IPokemon> benchPokemon;
    private IPokemon activePokemon;

    protected Trainer(String name) {
        this.name = name;
    }

    @Override
    public void seeCards() {

    }

    @Override
    public IPokemon getActivePokemon() {
        return this.activePokemon;
    }

    @Override
    public void playCard(ICard card) {
        card.playEffect(this);

    }

    @Override
    public void selectActivePokemon(IPokemon pokemon) {
        this.benchPokemon.add(this.activePokemon);
        this.activePokemon = pokemon;
        this.benchPokemon.remove(pokemon);
    }

    @Override
    public void selectAttack(IPokemon pokemon) {
        pokemon.getSelectedAttack();
    }
}

