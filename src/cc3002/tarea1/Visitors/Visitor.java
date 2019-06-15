package cc3002.tarea1.Visitors;

import cc3002.tarea1.*;

public interface Visitor {
    void visitPokemon(IPokemon pokemon);
    void visitEnergy(IEnergy energy);
    void visitTrainer(ITrainer trainer);
    void visitController(IController controller);
    void visitAttack(IAttack attack);
}
