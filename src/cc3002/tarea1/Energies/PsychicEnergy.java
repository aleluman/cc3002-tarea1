package cc3002.tarea1.Energies;

import cc3002.tarea1.ITrainer;

/**
 * Class to represent a psychic type energy.
 * @author Alejandro Lumán Bahamondes
 */
public class PsychicEnergy extends AbstractEnergy {
    /**
     * creates a new psychic energy card
     */
    public PsychicEnergy(ITrainer trainer){
        super("Psychic", trainer);
    }
}
