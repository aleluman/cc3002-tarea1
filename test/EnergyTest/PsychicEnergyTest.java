package EnergyTest;

import cc3002.tarea1.Energies.PsychicEnergy;
import cc3002.tarea1.Energies.IEnergy;
import cc3002.tarea1.Pokemon.IPokemon;
import cc3002.tarea1.ITrainer;
import cc3002.tarea1.Pokemon.GrassPokemon;
import cc3002.tarea1.Trainer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PsychicEnergyTest {
    private IEnergy psychicEnergy;
    private IPokemon sceptile;
    private ITrainer trainer;

    @Before
    public void setUp() {
        psychicEnergy = new PsychicEnergy();
        sceptile = new GrassPokemon(254, 120, "Sceptile", null);
        trainer = new Trainer("Alejandro");
    }

    @Test
    public void constructorTest() {
        assertEquals("Psychic", psychicEnergy.getName());
    }

    @Test
    public void addToPokemonTest() {
        assertTrue(sceptile.getEnergies().isEmpty());
        psychicEnergy.addToPokemon(sceptile);
        assertFalse(sceptile.getEnergies().isEmpty());
        assertEquals((Integer)1, sceptile.getEnergies().get("Psychic"));
        assertEquals((Integer)1, sceptile.getEnergies().get("Any"));
        psychicEnergy.addToPokemon(sceptile);
        assertEquals((Integer)2, sceptile.getEnergies().get("Psychic"));
        assertEquals((Integer)2, sceptile.getEnergies().get("Any"));
    }

    @Test
    public void playEffectTest() {
        trainer.playCard(sceptile);
        assertTrue(trainer.getActivePokemon().getEnergies().isEmpty());
        psychicEnergy.playEffect(trainer);
        assertEquals((Integer)1, trainer.getActivePokemon().getEnergies().get("Psychic"));
        assertEquals((Integer)1, trainer.getActivePokemon().getEnergies().get("Any"));
    }
}
