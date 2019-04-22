package cc3002.tarea1;

import cc3002.tarea1.Pokemon.IPokemon;

import java.util.List;

public class Trainer implements ITrainer {
    private String name;
    private List<ICard> deck;
    private List<ICard> hand;
    private List<IPokemon> benchPokemon;
    private IPokemon activePokemon;

    protected Trainer(String name, List<ICard> deck) {
        this.name = name;
        this.deck = deck;
    }

    @Override
    public void seeHandCards() {

    }

    @Override
    public void drawCard() {
        this.hand.add(this.deck.get(this.deck.size() - 1));
        this.hand.remove(this.deck.size() - 1);
    }

    @Override
    public void playCard(ICard card) {
        card.playEffect();

    }

    @Override
    public void selectActivePokemon(IPokemon pokemon) {
        this.benchPokemon.add(this.activePokemon);
        this.activePokemon = pokemon;
        this.benchPokemon.remove(pokemon);
    }

    @Override
    public void addPokemonToBench(IPokemon pokemon) {

    }

    @Override
    public void selectAttack(IPokemon pokemon) {
        pokemon.getSelectedAttack();
    }
}
