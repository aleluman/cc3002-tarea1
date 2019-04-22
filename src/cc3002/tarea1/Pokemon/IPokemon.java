package cc3002.tarea1.Pokemon;

import cc3002.tarea1.Attacks.IAttack;
import cc3002.tarea1.Energies.IEnergy;
import cc3002.tarea1.ICard;

import java.util.List;

public interface IPokemon extends ICard {
    int getID();
    int getHP();
    String getName();
    void addEnergy(IEnergy energy);
    void removeEnergy();
    List<IEnergy> getEnergies();
    List<IAttack> getAttacks();
    void selectAttack(int index);
    IAttack getSelectedAttack();
    void attack(IPokemon opponent);
    void receiveDamage(IAttack attack);
    void receiveWeaknessDamage(IAttack attack);
    void receiveResistedDamage(IAttack attack);
    void receiveGrassDamage(IAttack attack);
    void receiveWaterDamage(IAttack attack);
    void receiveFireDamage(IAttack attack);
    void receiveLightningDamage(IAttack attack);
    void receivePsychicDamage(IAttack attack);
    void receiveFightingDamage(IAttack attack);
}
