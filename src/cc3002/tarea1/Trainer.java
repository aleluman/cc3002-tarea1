package cc3002.tarea1;

import java.util.ArrayList;
import java.util.List;

/**
 * class to implement the trainer interface
 * @author Alejandro Lumán Bahamondes
 */
public class Trainer implements ITrainer {
    private String name;
    private List<ICard> hand = new ArrayList<>();
    private List<IPokemon> benchPokemon = new ArrayList<>();
    private IPokemon activePokemon;

    /**
     * method to create a new trainer
     * @param name the name of the trainer
     */
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
    public List<ICard> getHand() {
        return hand;
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
    public void replaceDeadPokemon() {
        if (activePokemon.isDead()) {
            activePokemon = benchPokemon.get(0);
        }
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

