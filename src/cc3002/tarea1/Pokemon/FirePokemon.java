package cc3002.tarea1.Pokemon;

import cc3002.tarea1.AbstractPokemon;
import cc3002.tarea1.IAttack;
import cc3002.tarea1.IPokemon;

import java.util.List;

public class FirePokemon extends AbstractPokemon {
    public FirePokemon(int id, int hp, String name, List<IAttack> attackList) {
        super(id, hp, name, attackList);
    }

    @Override
    public void attack(IPokemon opponent) {
        opponent.receiveFireDamage(getSelectedAttack());
    }

    @Override
    public void receiveWaterDamage(IAttack attack) {
        receiveWeaknessDamage(attack);
    }
}