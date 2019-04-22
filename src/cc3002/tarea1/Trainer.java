package cc3002.tarea1;

import cc3002.tarea1.Pokemon.IPokemon;

import java.util.List;

public class Trainer implements ITrainer {
    private String name;
    private List<ICard> deck;
    private List<ICard> hand;
    private List<IPokemon> benchPokemon;
    private ICard activePokemon;

    protected Trainer(String name, List<ICard> deck) {
        this.name = name;
        this.deck = deck;
    }

    @Override
    public void seeHandCards() {

    }

    @Override
    public void drawCard() {

    }

    @Override
    public void playCard() {

    }

    @Override
    public void selectActivePokemon() {

    }

    @Override
    public void addPokemonToBench() {

    }

    @Override
    public void selectAttack() {

    }
}
