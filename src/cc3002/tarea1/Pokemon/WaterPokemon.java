package cc3002.tarea1.Pokemon;

import cc3002.tarea1.Attacks.IAttack;

import java.util.List;

public class WaterPokemon extends AbstractPokemon {
    public WaterPokemon(int id, int hp, String name, List<IAttack> attackList) {
        super(id, hp, name, attackList);
    }

    @Override
    public void attack(IPokemon opponent) {
        opponent.receiveWaterDamage(this.getSelectedAttack());
    }

    @Override
    public void receiveGrassDamage(IAttack attack) {
        this.receiveWeaknessDamage(attack);
    }

    @Override
    public void receiveLightningDamage(IAttack attack) {
        this.receiveWeaknessDamage(attack);
    }

    @Override
    public void receiveFightingDamage(IAttack attack) {
        this.receiveResistedDamage(attack);
    }

}
