package cc3002.tarea1.Attacks;

import cc3002.tarea1.Visitors.IAttackVisitor;

import java.util.Map;

/**
 * class to represent a fire spin attack
 * @author Alejandro Lumán Bahamondes
 */
public class FireSpin extends DirectAttack{
    /**
     * constructor for a fire spin attack
     * @param energies    map with how many energies of each type the attack needs
     */
    public FireSpin(Map<String, Integer> energies) {
        super(80, "Fire Spin", energies, "Discard 2 energies attached to this pokemon");
    }

    @Override
    public void accept(IAttackVisitor v) {
        v.visitFireSpin(this);
    }
}
