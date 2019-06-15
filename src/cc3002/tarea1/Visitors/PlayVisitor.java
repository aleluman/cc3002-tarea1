package cc3002.tarea1.Visitors;

import cc3002.tarea1.*;

public class PlayVisitor implements Visitor{
    @Override
    public void visitPokemon(IPokemon pokemon) {
        if (pokemon.getTrainer().getActivePokemon() == null) {
            pokemon.getTrainer().selectActivePokemon(pokemon);
        } else {
            pokemon.getTrainer().addToBench(pokemon);
        }
    }

    @Override
    public void visitEnergy(IEnergy energy) {

    }

    @Override
    public void visitTrainer(ITrainer trainer) {

    }

    @Override
    public void visitController(IController controller) {

    }

    @Override
    public void visitAttack(IAttack attack) {

    }
}
