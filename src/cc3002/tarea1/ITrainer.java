package cc3002.tarea1;

import cc3002.tarea1.Pokemon.IPokemon;

public interface ITrainer {
    void seeCards();
    void drawCard();
    void playCard(ICard card);
    void selectActivePokemon(IPokemon pokemon);
    IPokemon getActivePokemon();
    void addPokemonToBench(IPokemon pokemon);
    void selectAttack(IPokemon pokemon);
}
