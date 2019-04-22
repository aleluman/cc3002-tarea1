package cc3002.tarea1.Pokemon;

import cc3002.tarea1.Attacks.IAttack;
import cc3002.tarea1.Energies.IEnergy;
import java.util.List;

public abstract class AbstractPokemon implements IPokemon {
    private int id;
    private int hp;
    private int damageReceived;
    private IAttack selectedAttack;
    private String name;
    private List<IAttack> attackList;
    private List<IEnergy> energyList;

    protected AbstractPokemon(int id, int hp, String name, List<IAttack> attackList) {
        this.id = id;
        this.hp = hp;
        this.damageReceived = 0;
        this.name = name;
        this.attackList = attackList;
    }

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public int getHP() {
        return this.hp;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addEnergy(IEnergy energy) {
        this.energyList.add(energy);
    }

    @Override
    public void removeEnergy() {
        this.energyList.remove(this.energyList.size() - 1);
    }

    @Override
    public List<IEnergy> getEnergies() {
        return this.energyList;
    }

    @Override
    public IAttack getSelectedAttack() {
        return this.selectedAttack;
    }

    @Override
    public List<IAttack> getAttacks() {
        return this.attackList;
    }

    @Override
    public void selectAttack(int index) {
        this.selectedAttack = this.attackList.get(index);
    }

    @Override
    public void attack(IPokemon opponent) {
        opponent.receiveDamage(this.selectedAttack);
    }

    @Override
    public void receiveDamage(IAttack attack) {
        this.damageReceived += attack.getDamage();
    }

    @Override
    public void receiveWeaknessDamage(IAttack attack) {
        this.damageReceived += attack.getDamage() * 2;
    }

    @Override
    public void receiveResistedDamage(IAttack attack) {
        int effectiveDamage;
        if (attack.getDamage() < 30)
            effectiveDamage = 0;
        else
            effectiveDamage = attack.getDamage() - 30;
        this.damageReceived += effectiveDamage;
    }

    @Override
    public void receiveGrassDamage(IAttack attack) {
        this.damageReceived += attack.getDamage();
    }

    @Override
    public void receiveWaterDamage(IAttack attack) {
        this.damageReceived += attack.getDamage();
    }

    @Override
    public void receiveFireDamage(IAttack attack) {
        this.damageReceived += attack.getDamage();
    }

    @Override
    public void receiveLightningDamage(IAttack attack) {
        this.damageReceived += attack.getDamage();
    }

    @Override
    public void receivePsychicDamage(IAttack attack) {
        this.damageReceived += attack.getDamage();
    }

    @Override
    public void receiveFightingDamage(IAttack attack) {
        this.damageReceived += attack.getDamage();
    }
}