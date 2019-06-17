package cc3002.tarea1.Pokemon;

import cc3002.tarea1.Attacks.IAttack;
import cc3002.tarea1.Energies.IEnergy;
import cc3002.tarea1.ICard;
import cc3002.tarea1.ITrainer;
import cc3002.tarea1.TrainerCards.ITrainerCard;

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
     * getter for the received damage number
     * @return the received damage
     */
    int getReceivedDamage();

    /**
     * method to add an energy value to the pokemon
     *
     * @param energy an energy card
     */
    void addEnergy(IEnergy energy);

    /**
     * method to return the evolution stage of the pokemon
     * @return the evolution stage of the pokemon
     */
    int getStage();

    /**
     * method to check if the current active pokemon is dead
     *
     * @return whether the pokemon is dead or not
     */
    boolean isDead();

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

    /**
     * method to get the ID of the pokemon evolution, if it exists
     * @return the ID of the evolution of the pokemon
     */
    int getEvolutionID();

    /**
     * method to get the owner of the card
     * @return the owner of the card (trainer)
     */
    ITrainer getTrainer();

    /**
     * method to set a trainer object card attached to the pokemon
     */
    void setObject(ITrainerCard object);

    /**
     * method to get the pokemon attached object
     * @return the attached object
     */
    ITrainerCard getObject();

    /**
     * setter method for the received damage of the pokemon
     * @param damage damage received
     */
    void setReceivedDamage(int damage);

    /**
     * method to get the pokemon's ability if it has one
     * @return the pokemon's ability
     */
    IAttack getAbility();
}
