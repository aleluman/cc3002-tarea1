package cc3002.tarea1.Visitors;

import cc3002.tarea1.*;
import cc3002.tarea1.Attacks.IAttack;
import cc3002.tarea1.Energies.IEnergy;
import cc3002.tarea1.Pokemon.IPokemon;
import cc3002.tarea1.TrainerCards.PokemonPark;
import cc3002.tarea1.TrainerCards.Potion;
import cc3002.tarea1.TrainerCards.ProfessorJuniper;

public interface CardVisitor{
    void visitPokemon(IPokemon pokemon);
    void visitEnergy(IEnergy energy);
    void visitPotion(Potion card);
    void visitPokemonPark(PokemonPark card);
    void visitProfessorJuniper(ProfessorJuniper card);
}
