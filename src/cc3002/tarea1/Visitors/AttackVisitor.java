package cc3002.tarea1.Visitors;

import cc3002.tarea1.Attacks.FireSpin;
import cc3002.tarea1.Attacks.WingBuzz;

/**
 * class to implement the IAttackVisitor methods
 * @author Alejandro Lumán Bahamondes
 */
public class AttackVisitor implements IAttackVisitor{
    /**
     * method to define the behavior of the wing buzz ability
     */
    @Override
    public void visitWingBuzz(WingBuzz ability) {

    }

    /**
     * method to define the behavior of the fire spin attack
     */
    @Override
    public void visitFireSpin(FireSpin attack) {

    }
}
