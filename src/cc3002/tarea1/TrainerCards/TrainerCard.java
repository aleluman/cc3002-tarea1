package cc3002.tarea1.TrainerCards;

import cc3002.tarea1.ITrainer;
import cc3002.tarea1.Visitors.CardVisitor;

public abstract class TrainerCard implements ITrainerCard{
    String description;
    String name;
    ITrainer trainer;

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
