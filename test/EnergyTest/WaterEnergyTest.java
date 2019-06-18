package EnergyTest;

import cc3002.tarea1.Controller;
import cc3002.tarea1.Energies.WaterEnergy;
import cc3002.tarea1.Energies.IEnergy;
import cc3002.tarea1.IController;
import cc3002.tarea1.Pokemon.IPokemon;
import cc3002.tarea1.ITrainer;
import cc3002.tarea1.Pokemon.GrassPokemon;
import cc3002.tarea1.Trainer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class WaterEnergyTest {
    private IEnergy waterEnergy;
    private IPokemon sceptile;
    private IController controller;
    private ITrainer trainer1, trainer2;

    @Before
    public void setUp() {
        waterEnergy = new WaterEnergy();
        sceptile = new GrassPokemon(254, 120, "Sceptile", null, 0, trainer1, 0, null);
        trainer1 = new Trainer("Alejandro");
        trainer2 = new Trainer("Lumán");
        controller = new Controller(trainer1, trainer2);
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
        controller.selectCard(sceptile);
        controller.playCard();
        assertTrue(controller.getActiveTrainer().getActivePokemon().getEnergies().isEmpty());
        controller.selectCard(waterEnergy);
        controller.playCard();
        assertEquals((Integer)1, controller.getActiveTrainer().getActivePokemon().getEnergies().get("Water"));
        assertEquals((Integer)1, controller.getActiveTrainer().getActivePokemon().getEnergies().get("Any"));
    }
}
