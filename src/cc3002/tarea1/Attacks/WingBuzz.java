package cc3002.tarea1.Attacks;

import cc3002.tarea1.Visitors.IAttackVisitor;

/**
 * class to represent a wing buzz ability
 * @author Alejandro Lumán Bahamondes
 */
public class WingBuzz extends Ability {
    /**
     * constructor for a wing buzz ability
     */
    public WingBuzz(){
        super("Wing Buzz", "Each turn, you can discard a card from your hand. If you do, discard the " +
                "card on top of your opponent's deck");
    }

    @Override
    public void accept(IAttackVisitor v) {
        v.visitWingBuzz(this);
    }
}
