package cc3002.tarea1.Visitors;

import cc3002.tarea1.Attacks.FireSpin;
import cc3002.tarea1.Attacks.WingBuzz;

/**
 * Visitor interface to define the methods needed to get the effects of different attacks
 * @author Alejandro Lumán Bahamondes
 */
public interface IAttackVisitor{
    /**
     * method to define the behavior of a wing buzz ability when played
     * @param ability the wing buzz ability
     */
    void visitWingBuzz(WingBuzz ability);

    /**
     * method to define the behavior of a fire spin attack when played
     * @param attack the fire spin attack
     */
    void visitFireSpin(FireSpin attack);
}
