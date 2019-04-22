package cc3002.tarea1.Attacks;

import cc3002.tarea1.Pokemon.IPokemon;

import java.util.List;

public interface IAttack {
    int getDamage();
    String getName();
    List<String> getEnergiesNeeded();
    String getDescription();
    boolean haveEnergy(IPokemon pokemon);
}
