package cc3002.tarea1.Pokemon;

import cc3002.tarea1.AbstractPokemon;
import cc3002.tarea1.IAttack;
import cc3002.tarea1.IPokemon;

import java.util.List;

/**
 * Class to represent a fighting type pokemon.
 * @author Alejandro Lumán Bahamondes
 */
public class FightingPokemon extends AbstractPokemon {
    /**
     * Creates a new fighting type pokemon.
     * @param id pokedex number of the pokemon
     * @param hp hit points of the pokemon
     * @param name name of the pokemon
     * @param attackList a list with up to 4 attacks
     */
    public FightingPokemon(int id, int hp, String name, List<IAttack> attackList) {
        super(id, hp, name, attackList);
    }

    @Override
    public void attack(IPokemon opponent) {
        opponent.receiveFightingDamage(getSelectedAttack());
    }

    @Override
    public void receivePsychicDamage(IAttack attack) {
        receiveWeaknessDamage(attack);
    }

    @Override
    public void receiveGrassDamage(IAttack attack) {
        receiveWeaknessDamage(attack);
    }

}
