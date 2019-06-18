package cc3002.tarea1.Visitors;

import cc3002.tarea1.*;
import cc3002.tarea1.Energies.IEnergy;
import cc3002.tarea1.Pokemon.IPokemon;
import cc3002.tarea1.TrainerCards.Potion;
import cc3002.tarea1.TrainerCards.ProfessorJuniper;

import java.util.List;

/**
 * class to implement the CardVisitor methods
 * @author Alejandro Lumán Bahamondes
 */
public class PlayVisitor implements CardVisitor {
    @Override
    public void visitPokemon(IPokemon pokemon) {
        ITrainer trainer = pokemon.getTrainer();
        if (pokemon.getStage() == 0) {
            if (trainer.getActivePokemon() == null) {
                trainer.selectActivePokemon(pokemon);
            } else {
                trainer.addToBench(pokemon);
            }
            trainer.getHand().remove(pokemon);
        } else {
            if (checkEvolution(trainer, pokemon)) {
                evolve(trainer, pokemon);
            }
        }
    }

    @Override
    public void visitEnergy(IEnergy energy) {
        energy.getTrainer().getSelectedPokemon().addEnergy(energy);
    }

    @Override
    public void visitPotion(Potion card) {
        int receivedDamage = card.getTrainer().getSelectedPokemon().getReceivedDamage();
        if (receivedDamage > 30)
            receivedDamage -= 30;
        else
            receivedDamage = 0;
        card.getTrainer().getSelectedPokemon().setReceivedDamage(receivedDamage);
    }

    @Override
    public void visitProfessorJuniper(ProfessorJuniper card) {
        ITrainer trainer = card.getTrainer();
        List<ICard> hand = trainer.getHand();
        for (ICard i : hand) {
            trainer.moveToDiscardPile(hand, i);
        }
        for (int i = 0; i < 7; i++) {
            ICard drawnCard = trainer.getDeck().get(0);
            trainer.getDeck().remove(0);
            trainer.addToHand(drawnCard);
        }
    }

    /**
     * method to evolve a pokemon
     * @param trainer the owner of the pokemon
     * @param evolvedPokemon the pokemon evolution
     */
    private void evolve(ITrainer trainer, IPokemon evolvedPokemon) {
        if (trainer.getHand().contains(trainer.getSelectedPokemon())) {
            trainer.getHand().remove(trainer.getSelectedPokemon());
            trainer.moveToDiscardPile(trainer.getHand(), trainer.getSelectedPokemon());
            trainer.addToBench(evolvedPokemon);
        } else {
            trainer.addToDiscardPile(trainer.getSelectedPokemon());
            trainer.selectActivePokemon(evolvedPokemon);
        }
        evolvedPokemon.setObject(trainer.getSelectedPokemon().getObject());
    }

    /**
     * method to check if the trainer's selected pokemon can evolve
     * @param trainer the owner of the card
     * @param pokemon the card of the evolved pokemon
     * @return if the pokemon can evolve or not
     */
    private boolean checkEvolution(ITrainer trainer, IPokemon pokemon) {
        return trainer.getSelectedPokemon().getEvolutionID() == pokemon.getID();
    }

}
