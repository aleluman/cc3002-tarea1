package cc3002.tarea1.Energies;

import cc3002.tarea1.ICard;
import cc3002.tarea1.ITrainer;
import cc3002.tarea1.Pokemon.IPokemon;

public interface IEnergy extends ICard {
    void addToPokemon(IPokemon pokemon);

    int getType();

    String getName();

    void playEffect(ITrainer trainer);
}
