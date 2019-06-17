package cc3002.tarea1.TrainerCards;

import cc3002.tarea1.Visitors.CardVisitor;

public class PokemonPark extends TrainerCard{
    @Override
    public void accept(CardVisitor v) {
        v.visitPokemonPark(this);
    }
}
