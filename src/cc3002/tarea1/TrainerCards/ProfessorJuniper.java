package cc3002.tarea1.TrainerCards;

import cc3002.tarea1.ITrainer;
import cc3002.tarea1.Visitors.CardVisitor;

/**
 * class to represent a professor juniper support card
 * @author Alejandro Lumán Bahamondes
 */
public class ProfessorJuniper extends TrainerCard{
    /**
     * constructor for a professor juniper support card
     * @param trainer the owner of the card
     */
    protected ProfessorJuniper(ITrainer trainer) {
        super("Discard your hand and draw 7 cards", "Professor Juniper", trainer);
    }

    @Override
    public void accept(CardVisitor v) {
        v.visitProfessorJuniper(this);
    }
}
