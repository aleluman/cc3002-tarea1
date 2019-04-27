package cc3002.tarea1.Pokemon;

import cc3002.tarea1.AbstractPokemon;
import cc3002.tarea1.IAttack;
import cc3002.tarea1.IPokemon;

import java.util.List;

public class LightningPokemon extends AbstractPokemon {
    public LightningPokemon(int id, int hp, String name, List<IAttack> attackList) {
        super(id, hp, name, attackList);
    }

    @Override
    public void attack(IPokemon opponent) {
        opponent.receiveLightningDamage(getSelectedAttack());
    }

    @Override
    public void receiveFightingDamage(IAttack attack) {
        receiveWeaknessDamage(attack);
    }
}
