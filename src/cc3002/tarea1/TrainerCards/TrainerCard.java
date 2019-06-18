package cc3002.tarea1.TrainerCards;

import cc3002.tarea1.ITrainer;
import cc3002.tarea1.Visitors.CardVisitor;

/**
 * class to represent a generic trainer card
 * @author Alejandro Lumán Bahamondes
 */
public abstract class TrainerCard implements ITrainerCard{
    private String description;
    private String name;
    private ITrainer trainer;

    /**
     * constructor for a generic trainer card
     * @param description the description of the card
     * @param name the name of the card
     * @param trainer the trainer of the card
     */
    protected TrainerCard(String description, String name, ITrainer trainer) {
        this.description = description;
        this.name = name;
        this.trainer = trainer;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ITrainer getTrainer() {
        return trainer;
    }

    @Override
    public abstract void accept(CardVisitor v);

}
