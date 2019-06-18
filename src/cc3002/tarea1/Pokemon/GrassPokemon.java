package cc3002.tarea1.Pokemon;

import cc3002.tarea1.Attacks.IAttack;
import cc3002.tarea1.ITrainer;

import java.util.List;

/**
 * Class to represent a Grass type pokemon.
 * @author Alejandro Lumán Bahamondes
 */
public class GrassPokemon extends AbstractPokemon {
    /**
     * Creates a new grass type pokemon.
     * @param id pokedex number of the pokemon
     * @param hp hit points of the pokemon
     * @param name name of the pokemon
     * @param attackList a list with up to 4 attacks
     * @param stage the stage of the pokemon evolution
     * @param trainer the pokemon's owner
     * @param evolutionID the pokemon's evolutionID
     * @param ability the pokemon's ability
     */
    public GrassPokemon(int id, int hp, String name, List<IAttack> attackList, int stage, ITrainer trainer,
                           int evolutionID, IAttack ability) {
        super(id, hp, name, attackList, stage, trainer, evolutionID, ability);
    }

    @Override
    public void attack(IPokemon opponent) {
        opponent.receiveGrassDamage(getSelectedAttack());
    }

    @Override
    public void receiveFireDamage(IAttack attack) {
        receiveWeaknessDamage(attack);
    }

    @Override
    public void receiveWaterDamage(IAttack attack) {
        receiveResistedDamage(attack);
    }


}
