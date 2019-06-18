package cc3002.tarea1.Energies;

import cc3002.tarea1.ITrainer;

/**
 * Class to represent a fighting type energy.
 * @author Alejandro Lumán Bahamondes
 */
public class FightingEnergy extends AbstractEnergy {
    /**
     * creates a new fighting energy card
     */
    public FightingEnergy(ITrainer trainer){
        super("Fighting", trainer);
    }
}
