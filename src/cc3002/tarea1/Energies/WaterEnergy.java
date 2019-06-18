package cc3002.tarea1.Energies;

import cc3002.tarea1.ITrainer;

/**
 * Class to represent a water type energy.
 * @author Alejandro Lumán Bahamondes
 */
public class WaterEnergy extends AbstractEnergy {
    /**
     * creates a new water energy card
     */
    public WaterEnergy(ITrainer trainer){
        super("Water", trainer);
    }
}
