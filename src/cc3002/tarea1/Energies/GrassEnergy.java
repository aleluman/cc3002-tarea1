package cc3002.tarea1.Energies;

import cc3002.tarea1.ITrainer;

/**
 * Class to represent a grass type energy.
 * @author Alejandro Lumán Bahamondes
 */
public class GrassEnergy extends AbstractEnergy {
    /**
     * creates a new grass energy card
     */
    public GrassEnergy(ITrainer trainer){
        super("Grass", trainer);
    }
}
