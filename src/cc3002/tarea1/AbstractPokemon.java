package cc3002.tarea1;

import cc3002.tarea1.Visitors.Visitor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class to represent an abstract pokemon (with no type)
 * @author Alejandro Lumán Bahamondes
 */
public abstract class AbstractPokemon implements IPokemon {
    private int id;
    private int hp;
    private int damageReceived;
    private IAttack selectedAttack;
    private String name;
    private List<IAttack> attackList;
    private Map<String, Integer> energies = new HashMap<>();
    private ITrainer trainer;


    protected AbstractPokemon(int id, int hp, String name, List<IAttack> attackList) {
        this.id = id;
        this.hp = hp;
        this.damageReceived = 0;
        this.name = name;
        if (attackList != null) {
            if (attackList.size() > 4) {
                attackList = attackList.subList(0, 4);
            }
            this.attackList = attackList;
        }
    }


    @Override
    public int getID() {
        return id;
    }

    @Override
    public int getHP() {
        return hp;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getReceivedDamage() {
        return damageReceived;
    }

    @Override
    public boolean isDead() {
        return (damageReceived >= hp);
    }

    @Override
    public void addEnergy(IEnergy energy) {
        String toAdd = energy.getName();
        energies.merge(toAdd, 1, Integer::sum);
        energies.merge("Any", 1, Integer::sum);
    }

    @Override
    public Map<String, Integer> getEnergies() {
        return energies;
    }

    @Override
    public void playEffect(ITrainer trainer) {
        if (trainer.getActivePokemon() == null) {
            trainer.selectActivePokemon(this);
        } else {
            trainer.addToBench(this);
        }
    }

    @Override
    public IAttack getSelectedAttack() {
        return selectedAttack;
    }

    @Override
    public List<IAttack> getAttacks() {
        return attackList;
    }

    @Override
    public void selectAttack(IAttack attack) {
        selectedAttack = attack;
    }

    @Override
    public boolean hasEnergyForAttack() {
        return selectedAttack.hasEnergy(this);
    }

    @Override
    public abstract void attack(IPokemon opponent);

    @Override
    public void receiveDamage(IAttack attack) {
        damageReceived += attack.getDamage();
    }

    @Override
    public void receiveWeaknessDamage(IAttack attack) {
        damageReceived += attack.getDamage() * 2;
    }

    @Override
    public void receiveResistedDamage(IAttack attack) {
        int effectiveDamage;
        if (attack.getDamage() < 30)
            effectiveDamage = 0;
        else
            effectiveDamage = attack.getDamage() - 30;
        damageReceived += effectiveDamage;
    }

    @Override
    public void receiveGrassDamage(IAttack attack) {
        damageReceived += attack.getDamage();
    }

    @Override
    public void receiveWaterDamage(IAttack attack) {
        damageReceived += attack.getDamage();
    }

    @Override
    public void receiveFireDamage(IAttack attack) {
        damageReceived += attack.getDamage();
    }

    @Override
    public void receiveLightningDamage(IAttack attack) {
        damageReceived += attack.getDamage();
    }

    @Override
    public void receivePsychicDamage(IAttack attack) {
        damageReceived += attack.getDamage();
    }

    @Override
    public void receiveFightingDamage(IAttack attack) {
        damageReceived += attack.getDamage();
    }

    @Override
    public void accept(Visitor v) {
        v.visitPokemon(this);
    }
}
