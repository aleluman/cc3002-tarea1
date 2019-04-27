package cc3002.tarea1;

import java.util.List;
import java.util.Map;

/**
 * Interface to represent Pokemon.
 *
 * @author Alejandro Lumán Bahamondes
 */
public interface IPokemon extends ICard {
    /**
     * getter method for the pokemon ID
     *
     * @return pokemon ID
     */
    int getID();

    /**
     * getter method for the pokemon HP
     *
     * @return pokemon HP
     */
    int getHP();

    /**
     * getter method for the pokemon name
     *
     * @return pokemon name
     */
    String getName();

    /**
     * method to add an energy value to the pokemon
     *
     * @param energy an energy card
     */
    void addEnergy(IEnergy energy);

    /**
     * method to check if the current active pokemon is dead
     *
     * @return whether the pokemon is dead or not
     */
    boolean isDead();

    /**
     * executes the effect on the card when playing it. In this case, it adds the pokemon to
     * the active pokemon field if it's not already occupied, or adds it to the bench if it isn't.
     * If the bench already has 5 pokemon, it doesn't do anything.
     *
     * @param trainer the owner of the card on which the effect will happen
     */
    @Override
    default void playEffect(ITrainer trainer) {

    }

    /**
     * method to get the energy values associated to the pokemon
     *
     * @return Map with energy type as key and quantity as value
     */
    Map<String, Integer> getEnergies();

    /**
     * method to check if the pokemon has enough energy to attack
     *
     * @return if the pokemon has energy or not
     */
    boolean hasEnergyForAttack();

    /**
     * method to get the pokemon possible attacks
     *
     * @return list with the pokemon attacks
     */
    List<IAttack> getAttacks();

    /**
     * method to select the active pokemon attack
     *
     * @param attack attack to be selected
     */
    void selectAttack(IAttack attack);

    /**
     * method to get the selected attack
     *
     * @return active pokemon selected attack
     */
    IAttack getSelectedAttack();

    /**
     * method to attack a opponent pokemon with the current active pokemon
     *
     * @param opponent receiver of the attack
     */
    void attack(IPokemon opponent);

    /**
     * method to receive damage from another pokemon
     *
     * @param attack attack from where the damage is applied
     */
    void receiveDamage(IAttack attack);

    /**
     * method to receive damage from an attack for which the current active pokemon has a weakness
     *
     * @param attack attack from where the damage is applied
     */
    void receiveWeaknessDamage(IAttack attack);

    /**
     * method to receive damage from an attack for which the current active pokemon is resistant
     *
     * @param attack attack from where the damage is applied
     */
    void receiveResistedDamage(IAttack attack);

    /**
     * method to receive a grass attack
     *
     * @param attack attack from where the damage is applied
     */
    void receiveGrassDamage(IAttack attack);

    /**
     * method to receive a water attack
     *
     * @param attack attack from where the damage is applied
     */
    void receiveWaterDamage(IAttack attack);

    /**
     * method to receive a fire attack
     *
     * @param attack attack from where the damage is applied
     */
    void receiveFireDamage(IAttack attack);

    /**
     * method to receive a lightning attack
     *
     * @param attack attack from where the damage is applied
     */
    void receiveLightningDamage(IAttack attack);

    /**
     * method to receive a psychic attack
     *
     * @param attack attack from where the damage is applied
     */
    void receivePsychicDamage(IAttack attack);

    /**
     * method to receive a fighting attack
     *
     * @param attack attack from where the damage is applied
     */
    void receiveFightingDamage(IAttack attack);
}
