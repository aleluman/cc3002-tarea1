package EnergyTest;

import cc3002.tarea1.Controller;
import cc3002.tarea1.Energies.FireEnergy;
import cc3002.tarea1.Energies.IEnergy;
import cc3002.tarea1.IController;
import cc3002.tarea1.Pokemon.IPokemon;
import cc3002.tarea1.ITrainer;
import cc3002.tarea1.Pokemon.GrassPokemon;
import cc3002.tarea1.Trainer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FireEnergyTest {
    private IEnergy fireEnergy;
    private IPokemon sceptile;
    private IController controller;
    private ITrainer trainer1, trainer2;

    @Before
    public void setUp() {
        trainer1 = new Trainer("Alejandro");
        trainer2 = new Trainer("Lumán");
        fireEnergy = new FireEnergy(trainer1);
        controller = new Controller(trainer1, trainer2);
        sceptile = new GrassPokemon(254, 120, "Sceptile", null, 0, trainer1, 0, null);
        trainer1.selectActivePokemon(sceptile);
    }

    @Test
    public void constructorTest() {
        assertEquals("Fire", fireEnergy.getName());
    }

    @Test
    public void addToPokemonTest() {
        assertTrue(sceptile.getEnergies().isEmpty());
        fireEnergy.addToPokemon(sceptile);
        assertFalse(sceptile.getEnergies().isEmpty());
        assertEquals((Integer)1, sceptile.getEnergies().get("Fire"));
        assertEquals((Integer)1, sceptile.getEnergies().get("Any"));
        fireEnergy.addToPokemon(sceptile);
        assertEquals((Integer)2, sceptile.getEnergies().get("Fire"));
        assertEquals((Integer)2, sceptile.getEnergies().get("Any"));
    }

    @Test
    public void playEffectTest() {
        controller.selectCard(sceptile);
        controller.playCard();
        assertTrue(controller.getActiveTrainer().getActivePokemon().getEnergies().isEmpty());
        controller.selectCard(fireEnergy);
        controller.playCard();
        assertEquals((Integer)1, controller.getActiveTrainer().getActivePokemon().getEnergies().get("Fire"));
        assertEquals((Integer)1, controller.getActiveTrainer().getActivePokemon().getEnergies().get("Any"));
    }
}
