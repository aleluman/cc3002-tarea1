package cc3002.tarea1.Pokemon;

import cc3002.tarea1.Attacks.IAttack;
import cc3002.tarea1.ITrainer;

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
     * @param stage the stage of the pokemon evolution
     * @param trainer the pokemon's owner
     * @param evolutionID the pokemon's evolutionID
     * @param ability the pokemon's ability
     */
    public WaterPokemon(int id, int hp, String name, List<IAttack> attackList, int stage, ITrainer trainer,
                           int evolutionID, IAttack ability) {
        super(id, hp, name, attackList, stage, trainer, evolutionID, ability);
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
