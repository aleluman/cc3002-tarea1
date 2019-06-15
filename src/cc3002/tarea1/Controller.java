package cc3002.tarea1;

import cc3002.tarea1.Visitors.Visitor;

public class Controller implements IController {
    private ITrainer trainer1, trainer2;
    private ITrainer activeTrainer;

    @Override
    public void accept(Visitor v) {
        v.visitController(this);
    }

    @Override
    public void drawCard(ITrainer trainer) {

    }

    @Override
    public void seeGameCards() {

    }

    @Override
    public void playCard(ITrainer trainer) {

    }

    @Override
    public void selectCard(ITrainer trainer) {

    }

    @Override
    public void useAbility(ITrainer trainer) {

    }
}
