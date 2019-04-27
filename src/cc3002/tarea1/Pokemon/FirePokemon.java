package cc3002.tarea1.Pokemon;

import cc3002.tarea1.AbstractPokemon;
import cc3002.tarea1.IAttack;
import cc3002.tarea1.IPokemon;

import java.util.List;

/**
 * Class to represent a Fire type pokemon.
 * @author Alejandro Lumán Bahamondes
 */
public class FirePokemon extends AbstractPokemon {
    /**
     * Creates a new fire type pokemon.
     * @param id pokedex number of the pokemon
     * @param hp hit points of the pokemon
     * @param name name of the pokemon
     * @param attackList a list with up to 4 attacks
     */
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