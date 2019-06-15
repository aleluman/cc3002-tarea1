package cc3002.tarea1;

import cc3002.tarea1.Visitors.Visitor;

public interface IController {
    /**
     * Accept method for the different visitors
     * @param v visitor to perform an operation
     */
    void accept(Visitor v);

    void drawCard(ITrainer trainer);

    void seeGameCards();

    void playCard(ITrainer trainer);

    void selectCard(ITrainer trainer);

    void useAbility(ITrainer trainer);
}
