package EnergyTest;

import cc3002.tarea1.Energies.LightningEnergy;
import cc3002.tarea1.Energies.IEnergy;
import cc3002.tarea1.Pokemon.IPokemon;
import cc3002.tarea1.ITrainer;
import cc3002.tarea1.Pokemon.GrassPokemon;
import cc3002.tarea1.Trainer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LightningEnergyTest {
    private IEnergy lightningEnergy;
    private IPokemon sceptile;
    private ITrainer trainer;

    @Before
    public void setUp() {
        lightningEnergy = new LightningEnergy();
        sceptile = new GrassPokemon(254, 120, "Sceptile", null);
        trainer = new Trainer("Alejandro");
    }

    @Test
    public void constructorTest() {
        assertEquals("Lightning", lightningEnergy.getName());
    }

    @Test
    public void addToPokemonTest() {
        assertTrue(sceptile.getEnergies().isEmpty());
        lightningEnergy.addToPokemon(sceptile);
        assertFalse(sceptile.getEnergies().isEmpty());
        assertEquals((Integer)1, sceptile.getEnergies().get("Lightning"));
        assertEquals((Integer)1, sceptile.getEnergies().get("Any"));
        lightningEnergy.addToPokemon(sceptile);
        assertEquals((Integer)2, sceptile.getEnergies().get("Lightning"));
        assertEquals((Integer)2, sceptile.getEnergies().get("Any"));
    }

    @Test
    public void playEffectTest() {
        trainer.playCard(sceptile);
        assertTrue(trainer.getActivePokemon().getEnergies().isEmpty());
        lightningEnergy.playEffect(trainer);
        assertEquals((Integer)1, trainer.getActivePokemon().getEnergies().get("Lightning"));
        assertEquals((Integer)1, trainer.getActivePokemon().getEnergies().get("Any"));
    }
}
