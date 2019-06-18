package cc3002.tarea1.Energies;

import cc3002.tarea1.ITrainer;

/**
 * Class to represent a fire type energy.
 * @author Alejandro Lumán Bahamondes
 */
public class FireEnergy extends AbstractEnergy {
    /**
     * creates a new fire energy card
     */
    public FireEnergy(ITrainer trainer){
        super("Fire", trainer);
    }
}
