package EnergyTest;

import cc3002.tarea1.Energies.WaterEnergy;
import cc3002.tarea1.IEnergy;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.ITrainer;
import cc3002.tarea1.Pokemon.GrassPokemon;
import cc3002.tarea1.Trainer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class WaterEnergyTest {
    private IEnergy waterEnergy;
    private IPokemon sceptile;
    private ITrainer trainer;

    @Before
    public void setUp() {
        waterEnergy = new WaterEnergy();
        sceptile = new GrassPokemon(254, 120, "Sceptile", null);
        trainer = new Trainer("Alejandro");
    }

    @Test
    public void constructorTest() {
        assertEquals("Water", waterEnergy.getName());
    }

    @Test
    public void addToPokemonTest() {
        assertTrue(sceptile.getEnergies().isEmpty());
        waterEnergy.addToPokemon(sceptile);
        assertFalse(sceptile.getEnergies().isEmpty());
        assertEquals((Integer)1, sceptile.getEnergies().get("Water"));
        assertEquals((Integer)1, sceptile.getEnergies().get("Any"));
        waterEnergy.addToPokemon(sceptile);
        assertEquals((Integer)2, sceptile.getEnergies().get("Water"));
        assertEquals((Integer)2, sceptile.getEnergies().get("Any"));
    }

    @Test
    public void playEffectTest() {
        trainer.playCard(sceptile);
        assertTrue(trainer.getActivePokemon().getEnergies().isEmpty());
        waterEnergy.playEffect(trainer);
        assertEquals((Integer)1, trainer.getActivePokemon().getEnergies().get("Water"));
        assertEquals((Integer)1, trainer.getActivePokemon().getEnergies().get("Any"));
    }
}
