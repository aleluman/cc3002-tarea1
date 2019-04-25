package cc3002.tarea1;

import java.util.List;

/**
 * Interface to represent Pokemon.
 * @author Alejandro Lumán Bahamondes
 */
public interface IPokemon extends ICard {
    /**
     *
     * @return
     */
    int getID();

    /**
     *
     * @return
     */
    int getHP();

    /**
     *
     * @return
     */
    String getName();

    /**
     *
     * @param energy
     */
    void addEnergy(IEnergy energy);

    /**
     *
     */
    void removeEnergy();

    /**
     *
     * @return
     */
    List<IEnergy> getEnergies();

    /**
     *
     * @return
     */
    List<IAttack> getAttacks();

    /**
     *
     * @param index
     */
    void selectAttack(int index);

    /**
     *
     * @return
     */
    IAttack getSelectedAttack();

    /**
     *
     * @param opponent
     */
    void attack(IPokemon opponent);

    /**
     *
     * @param attack
     */
    void receiveDamage(IAttack attack);

    /**
     *
     * @param attack
     */
    void receiveWeaknessDamage(IAttack attack);

    /**
     *
     * @param attack
     */
    void receiveResistedDamage(IAttack attack);

    /**
     *
     * @param attack
     */
    void receiveGrassDamage(IAttack attack);

    /**
     *
     * @param attack
     */
    void receiveWaterDamage(IAttack attack);

    /**
     *
     * @param attack
     */
    void receiveFireDamage(IAttack attack);

    /**
     *
     * @param attack
     */
    void receiveLightningDamage(IAttack attack);

    /**
     *
     * @param attack
     */
    void receivePsychicDamage(IAttack attack);

    /**
     *
     * @param attack
     */
    void receiveFightingDamage(IAttack attack);
}
