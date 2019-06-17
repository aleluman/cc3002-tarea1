package cc3002.tarea1.Pokemon;

import cc3002.tarea1.Attacks.IAttack;

import java.util.List;

/**
 * Class to represent a lightning type pokemon.
 * @author Alejandro Lumán Bahamondes
 */
public class LightningPokemon extends AbstractPokemon {
    /**
     * Creates a new lightning type pokemon.
     * @param id pokedex number of the pokemon
     * @param hp hit points of the pokemon
     * @param name name of the pokemon
     * @param attackList a list with up to 4 attacks
     */
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
