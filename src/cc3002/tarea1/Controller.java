package cc3002.tarea1;

import cc3002.tarea1.Visitors.AttackVisitor;
import cc3002.tarea1.Visitors.IAttackVisitor;
import cc3002.tarea1.Visitors.PlayVisitor;
import cc3002.tarea1.Visitors.CardVisitor;

/**
 * class to implement the controller interface
 * @author Alejandro Lumán Bahamondes
 */
public class Controller implements IController {
    private ITrainer activeTrainer, nonActiveTrainer;
    private CardVisitor play = new PlayVisitor();
    private IAttackVisitor attack = new AttackVisitor();
    private boolean energyPlayedThisTurn = false;

    /**
     * method to create a new controller
     * @param trainer1 first trainer in the game
     * @param trainer2 second trainer in the game
     */
    public Controller(ITrainer trainer1, ITrainer trainer2) {
        activeTrainer = trainer1;
        nonActiveTrainer = trainer2;
    }

    @Override
    public void drawCard() {
        ICard card = activeTrainer.getDeck().get(0);
        activeTrainer.getDeck().remove(0);
        activeTrainer.addToHand(card);
    }

    @Override
    public void playCard() {
        activeTrainer.getSelectedCard().accept(play);
    }

    @Override
    public void selectCard(ICard card) {
        activeTrainer.setSelectedCard(card);
    }

    @Override
    public void useAbility() {
        activeTrainer.getSelectedPokemon().getAbility().accept(attack);
    }

    @Override
    public void attack() {
        activeTrainer.getActivePokemon().attack(nonActiveTrainer.getActivePokemon());
    }

    /**
     * method to switch the current active trainer in a game
     */
    private void switchActiveTrainer(){
        ITrainer aux = nonActiveTrainer;
        nonActiveTrainer = activeTrainer;
        activeTrainer = aux;
    }

    @Override
    public void endPlayerTurn() {
        energyPlayedThisTurn = false;
        switchActiveTrainer();
    }

    @Override
    public ITrainer getActiveTrainer() {
        return activeTrainer;
    }
}
