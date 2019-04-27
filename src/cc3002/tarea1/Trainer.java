package cc3002.tarea1;

import java.util.ArrayList;
import java.util.List;

public class Trainer implements ITrainer {
    private String name;
    private List<ICard> hand = new ArrayList<>();
    private List<IPokemon> benchPokemon = new ArrayList<>();
    private IPokemon activePokemon;

    public Trainer(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    @Override
    public void seeCards() {

    }

    @Override
    public IPokemon getActivePokemon() {
        return activePokemon;
    }

    @Override
    public void playCard(ICard card) {
        card.playEffect(this);
    }

    @Override
    public List<IPokemon> getBenchPokemon() {
        return benchPokemon;
    }

    @Override
    public void addToBench(IPokemon pokemon) {
        benchPokemon.add(pokemon);
    }

    @Override
    public void selectActivePokemon(IPokemon pokemon) {
        benchPokemon.add(activePokemon);
        activePokemon = pokemon;
        benchPokemon.remove(pokemon);
    }

    @Override
    public void selectAttack(int index) {
        activePokemon.selectAttack(activePokemon.getAttacks().get(index));
    }
}

