package cc3002.tarea1.Visitors;

import cc3002.tarea1.Energies.IEnergy;
import cc3002.tarea1.Pokemon.IPokemon;
import cc3002.tarea1.TrainerCards.Potion;
import cc3002.tarea1.TrainerCards.ProfessorJuniper;

/**
 * Visitor interface to define the methods needed to get the effects of the cards when played
 * @author Alejandro Lumán Bahamondes
 */
public interface CardVisitor{
    /**
     * method to define what to do after playing a pokemon card
     * @param pokemon the pokemon card to be played
     */
    void visitPokemon(IPokemon pokemon);

    /**
     * method to define what to do after playing an energy card
     * @param energy the energy card to be played
     */
    void visitEnergy(IEnergy energy);

    /**
     * method to define what to do after playing a potion card
     * @param card the potion card to be played
     */
    void visitPotion(Potion card);

    /**
     * method to define what to do after playing a professor juniper card
     * @param card the professor juniper card to be played
     */
    void visitProfessorJuniper(ProfessorJuniper card);
}
