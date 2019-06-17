package cc3002.tarea1.Visitors;

import cc3002.tarea1.*;
import cc3002.tarea1.Attacks.IAttack;
import cc3002.tarea1.Energies.IEnergy;
import cc3002.tarea1.Pokemon.IPokemon;
import cc3002.tarea1.TrainerCards.ITrainerCard;
import cc3002.tarea1.TrainerCards.PokemonPark;
import cc3002.tarea1.TrainerCards.Potion;
import cc3002.tarea1.TrainerCards.ProfessorJuniper;

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
    public void visitPokemonPark(PokemonPark card) {

    }

    @Override
    public void visitProfessorJuniper(ProfessorJuniper card) {

    }

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

    private boolean checkEvolution(ITrainer trainer, IPokemon pokemon) {
        return trainer.getSelectedPokemon().getEvolutionID() == pokemon.getID();
    }

}
