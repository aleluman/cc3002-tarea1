package TrainerTest;

import cc3002.tarea1.*;
import cc3002.tarea1.Attacks.DirectAttack;
import cc3002.tarea1.Attacks.IAttack;
import cc3002.tarea1.Energies.GrassEnergy;
import cc3002.tarea1.Pokemon.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrainerTest {
    private ITrainer trainer1, trainer2;
    private Controller controller;
    private ICard sceptile,
            alakazam,
            raikou,
            blaziken,
            garchomp,
            swampert,
            pikachu;
    private ICard grassEnergyCard;

    @Before
    public void setUp() {
        trainer1 = new Trainer("Alejandro");
        trainer2 = new Trainer(("Lumán"));
        controller = new Controller(trainer1, trainer2);
        sceptile = new GrassPokemon(254, 120, "Sceptile", null, 2, trainer1, 0, null);
        alakazam = new PsychicPokemon(65, 110, "Alakazam", null, 2, trainer1, 0, null);
        raikou = new LightningPokemon(243, 150, "Raikou", null, 2, trainer1, 0, null);
        blaziken = new FirePokemon(257, 120, "Blaziken", null, 2, trainer1, 0, null);
        garchomp = new FightingPokemon(445, 140, "Garchomp", null, 2, trainer1, 0, null);
        swampert = new WaterPokemon(260, 120, "Swampert", null, 2, trainer1, 0, null);
        pikachu = new LightningPokemon(25, 60, "Pikachu", null, 2, trainer1, 0, null);
        grassEnergyCard = new GrassEnergy();
    }

    @Test
    public void constructorTest() {
        assertEquals("Alejandro", trainer1.getName());
        assertTrue(trainer1.getHand().isEmpty());
        assertTrue(trainer1.getBenchPokemon().isEmpty());
        assertNull(trainer1.getActivePokemon());
    }

    @Test
    public void playCardTest() {
        controller.selectCard(sceptile);
        controller.playCard();
        assertEquals("Sceptile", trainer1.getActivePokemon().getName());
        assertEquals(0, trainer1.getBenchPokemon().size());
        controller.selectCard(alakazam);
        controller.playCard();
        assertEquals("Sceptile", trainer1.getActivePokemon().getName());
        controller.selectCard(raikou);
        controller.playCard();
        assertEquals(2, trainer1.getBenchPokemon().size());
        controller.selectCard(blaziken);
        controller.playCard();
        assertEquals(3, trainer1.getBenchPokemon().size());
        controller.selectCard(garchomp);
        controller.playCard();
        assertEquals(4, trainer1.getBenchPokemon().size());
        controller.selectCard(swampert);
        controller.playCard();
        assertEquals(5, trainer1.getBenchPokemon().size());
        controller.selectCard(pikachu);
        controller.playCard();
        assertEquals(5, trainer1.getBenchPokemon().size());
        controller.selectCard(grassEnergyCard);
        controller.playCard();
        Map<String, Integer> energies = new HashMap<>();
        energies.put("Grass", 1);
        energies.put("Any", 1);
        assertEquals(energies, trainer1.getActivePokemon().getEnergies());
    }

    @Test
    public void addToBenchTest() {
        assertEquals(0, trainer1.getBenchPokemon().size());
        trainer1.addToBench((IPokemon) sceptile);
        assertEquals(1, trainer1.getBenchPokemon().size());
        trainer1.addToBench((IPokemon) alakazam);
        trainer1.addToBench((IPokemon) raikou);
        trainer1.addToBench((IPokemon) blaziken);
        trainer1.addToBench((IPokemon) garchomp);
        assertEquals(5, trainer1.getBenchPokemon().size());
        trainer1.addToBench((IPokemon) swampert);
        assertEquals(5, trainer1.getBenchPokemon().size());
        assertEquals("Garchomp", trainer1.getBenchPokemon().get(4).getName());
    }

    @Test
    public void replaceDeadPokemonTest() {
        IAttack attack = new DirectAttack(80, "Struggle", null, "Test Attack");
        controller.selectCard(sceptile);
        controller.playCard();
        trainer1.getActivePokemon().receiveDamage(attack);
        trainer1.replaceDeadPokemon();
        assertNotNull(trainer1.getActivePokemon());
        trainer1.getActivePokemon().receiveDamage(attack);
        trainer1.replaceDeadPokemon();
        assertNull(trainer1.getActivePokemon());
        controller.selectCard(alakazam);
        controller.playCard();
        controller.selectCard(raikou);
        controller.playCard();
        assertEquals("Alakazam", trainer1.getActivePokemon().getName());
        trainer1.getActivePokemon().receiveDamage(attack);
        trainer1.getActivePokemon().receiveDamage(attack);
        trainer1.replaceDeadPokemon();
        assertEquals("Raikou", trainer1.getActivePokemon().getName());
        assertEquals(0, trainer1.getBenchPokemon().size());
    }

    @Test
    public void selectAttackTest() {
        List<IAttack> attackList = new ArrayList<>();
        IAttack attack1 = new DirectAttack(80, "Struggle", null, "Test Attack");
        IAttack attack2 = new DirectAttack(70, "Splash", null, "Test Attack");
        attackList.add(attack1);
        attackList.add(attack2);
        sceptile = new GrassPokemon(254, 120, "Sceptile", attackList, 2, trainer1, 0, null);
        controller.selectCard(sceptile);
        controller.playCard();
        assertNull(trainer1.getActivePokemon().getSelectedAttack());
        trainer1.selectAttack(0);
        assertEquals("Struggle", trainer1.getActivePokemon().getSelectedAttack().getName());
        trainer1.selectAttack(1);
        assertEquals("Splash", trainer1.getActivePokemon().getSelectedAttack().getName());
        trainer1.selectAttack(2);
        assertNull(trainer1.getActivePokemon().getSelectedAttack());
    }
}
