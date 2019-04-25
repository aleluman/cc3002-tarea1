package cc3002.tarea1.Pokemon;

import cc3002.tarea1.AbstractPokemon;
import cc3002.tarea1.IAttack;
import cc3002.tarea1.IPokemon;

import java.util.List;

public class PsychicPokemon extends AbstractPokemon {
    public PsychicPokemon(int id, int hp, String name, List<IAttack> attackList) {
        super(id, hp, name, attackList);
    }

    @Override
    public void attack(IPokemon opponent) {
        opponent.receivePsychicDamage(this.getSelectedAttack());
    }

    @Override
    public void receivePsychicDamage(IAttack attack) {
        this.receiveWeaknessDamage(attack);
    }

    @Override
    public void receiveFightingDamage(IAttack attack) {
        this.receiveResistedDamage(attack);
    }

}
