package cc3002.tarea1.Pokemon;

import cc3002.tarea1.Attacks.IAttack;

import java.util.List;

/**
 * Class to represent a water type pokemon.
 * @author Alejandro Lumán Bahamondes
 */
public class WaterPokemon extends AbstractPokemon {
    /**
     * Creates a new water type pokemon.
     * @param id pokedex number of the pokemon
     * @param hp hit points of the pokemon
     * @param name name of the pokemon
     * @param attackList a list with up to 4 attacks
     */
    public WaterPokemon(int id, int hp, String name, List<IAttack> attackList) {
        super(id, hp, name, attackList);
    }

    @Override
    public void attack(IPokemon opponent) {
        opponent.receiveWaterDamage(getSelectedAttack());
    }

    @Override
    public void receiveGrassDamage(IAttack attack) {
        receiveWeaknessDamage(attack);
    }

    @Override
    public void receiveLightningDamage(IAttack attack) {
        receiveWeaknessDamage(attack);
    }

    @Override
    public void receiveFightingDamage(IAttack attack) {
        receiveResistedDamage(attack);
    }

}
