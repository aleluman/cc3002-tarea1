package cc3002.tarea1.Energies;

import cc3002.tarea1.ITrainer;

/**
 * Class to represent a lightning type energy.
 * @author Alejandro Lumán Bahamondes
 */
public class LightningEnergy extends AbstractEnergy {
    /**
     * creates a new lightning energy card
     */
    public LightningEnergy(ITrainer trainer){
        super("Lightning", trainer);
    }
}
