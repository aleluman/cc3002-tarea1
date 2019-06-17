package cc3002.tarea1;

import cc3002.tarea1.Pokemon.IPokemon;
import cc3002.tarea1.Visitors.CardVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * class to implement the trainer interface
 * @author Alejandro Lumán Bahamondes
 */
public class Trainer implements ITrainer {
    private String name;
    private List<ICard> hand = new ArrayList<>();
    private List<ICard> deck = new ArrayList<>();
    private List<ICard> discardPile = new ArrayList<>();
    private List<ICard> prizeCards = new ArrayList<>();
    private List<IPokemon> benchPokemon = new ArrayList<>();
    private IPokemon activePokemon;
    private IPokemon selectedPokemon;
    private ICard selectedCard;

    /**
     * method to create a new trainer
     * @param name the name of the trainer
     */
    public Trainer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<ICard> getHand() {
        return hand;
    }

    @Override
    public List<ICard> getDeck() {
        return deck;
    }

    @Override
    public IPokemon getActivePokemon() {
        return activePokemon;
    }

    @Override
    public IPokemon getSelectedPokemon() {
        return activePokemon;
    }

    @Override
    public List<IPokemon> getBenchPokemon() {
        return benchPokemon;
    }

    @Override
    public void replaceDeadPokemon() {
        if (activePokemon.isDead()) {
            if (!benchPokemon.isEmpty()) {
                activePokemon = benchPokemon.get(0);
                benchPokemon.remove(0);
            }
            else
                activePokemon = null;
        }
    }

    @Override
    public void addToBench(IPokemon pokemon) {
        if (benchPokemon.size() < 5)
            benchPokemon.add(pokemon);
    }

    @Override
    public void selectActivePokemon(IPokemon pokemon) {
        activePokemon = pokemon;
        benchPokemon.remove(pokemon);
    }

    @Override
    public void selectAttack(int index) {
        if (index < activePokemon.getAttacks().size())
            activePokemon.selectAttack(activePokemon.getAttacks().get(index));
        else
            activePokemon.selectAttack(null);
    }

    @Override
    public void addToHand(ICard card) {
        hand.add(card);
    }

    @Override
    public ICard getSelectedCard() {
        return selectedCard;
    }

    @Override
    public void setSelectedCard(int index) {
        selectedCard = getHand().get(index);
    }

    @Override
    public void setSelectedPokemon(IPokemon pokemon) {
        selectedPokemon = pokemon;
    }

    @Override
    public void moveToDiscardPile(List<ICard> cardList, ICard card) {
        if (cardList.contains(card)){
            cardList.remove(card);
            addToDiscardPile(card);
        }
    }

    @Override
    public void addToDiscardPile(ICard card) {
        discardPile.add(card);
    }
}

