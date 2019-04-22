package cc3002.tarea1.Pokemon;

import cc3002.tarea1.Attacks.IAttack;

import java.util.List;

public class FightingPokemon extends AbstractPokemon{
    public FightingPokemon(int id, int hp, String name, List<IAttack> attackList) {
        super(id, hp, name, attackList);
    }

    @Override
    public void attack(IPokemon opponent) {
        opponent.receiveFightingDamage(this.getSelectedAttack());
    }

    @Override
    public void receivePsychicDamage(IAttack attack) {
        this.receiveWeaknessDamage(attack);
    }

    @Override
    public void receiveGrassDamage(IAttack attack) {
        this.receiveWeaknessDamage(attack);
    }

}
