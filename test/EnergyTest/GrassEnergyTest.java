package EnergyTest;

import cc3002.tarea1.Energies.GrassEnergy;
import cc3002.tarea1.IEnergy;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.ITrainer;
import cc3002.tarea1.Pokemon.GrassPokemon;
import cc3002.tarea1.Trainer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GrassEnergyTest {
    private IEnergy grassEnergy;
    private IPokemon sceptile;
    private ITrainer trainer;

    @Before
    public void setUp() {
        grassEnergy = new GrassEnergy();
        sceptile = new GrassPokemon(254, 120, "Sceptile", null);
        trainer = new Trainer("Alejandro");
    }

    @Test
    public void constructorTest() {
        assertEquals("Grass", grassEnergy.getName());
    }

    @Test
    public void addToPokemonTest() {
        assertTrue(sceptile.getEnergies().isEmpty());
        grassEnergy.addToPokemon(sceptile);
        assertFalse(sceptile.getEnergies().isEmpty());
        assertEquals((Integer)1, sceptile.getEnergies().get("Grass"));
        assertEquals((Integer)1, sceptile.getEnergies().get("Any"));
        grassEnergy.addToPokemon(sceptile);
        assertEquals((Integer)2, sceptile.getEnergies().get("Grass"));
        assertEquals((Integer)2, sceptile.getEnergies().get("Any"));
    }

    @Test
    public void playEffectTest() {
        trainer.playCard(sceptile);
        assertTrue(trainer.getActivePokemon().getEnergies().isEmpty());
        grassEnergy.playEffect(trainer);
        assertEquals((Integer)1, trainer.getActivePokemon().getEnergies().get("Grass"));
        assertEquals((Integer)1, trainer.getActivePokemon().getEnergies().get("Any"));
    }
}