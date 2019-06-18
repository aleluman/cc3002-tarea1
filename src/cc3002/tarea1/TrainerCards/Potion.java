package cc3002.tarea1.TrainerCards;

import cc3002.tarea1.ITrainer;
import cc3002.tarea1.Visitors.CardVisitor;

/**
 * class to represent a potion object
 * @author Alejandro Lumán Bahamondes
 */
public class Potion extends TrainerCard{
    /**
     * constructor for a potion object
     * @param trainer the owner of the card
     */
    protected Potion(ITrainer trainer) {
        super("Discard 3 damage counters from a pokemon", "Potion", trainer);
    }

    @Override
    public void accept(CardVisitor v) {
        v.visitPotion(this);
    }
}
