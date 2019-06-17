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
    private ITrainer trainer;
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
        trainer = new Trainer("Alejandro");
        sceptile = new GrassPokemon(254, 120, "Sceptile", null);
        alakazam = new PsychicPokemon(65, 110, "Alakazam", null);
        raikou = new LightningPokemon(243, 150, "Raikou", null);
        blaziken = new FirePokemon(257, 120, "Blaziken", null);
        garchomp = new FightingPokemon(445, 140, "Garchomp", null);
        swampert = new WaterPokemon(260, 120, "Swampert", null);
        pikachu = new LightningPokemon(25, 60, "Pikachu", null);
        grassEnergyCard = new GrassEnergy();
    }

    @Test
    public void constructorTest() {
        assertEquals("Alejandro", trainer.getName());
        assertTrue(trainer.getHand().isEmpty());
        assertTrue(trainer.getBenchPokemon().isEmpty());
        assertNull(trainer.getActivePokemon());
    }

    @Test
    public void playCardTest() {
        trainer.playCard(sceptile);
        assertEquals("Sceptile", trainer.getActivePokemon().getName());
        assertEquals(0, trainer.getBenchPokemon().size());
        trainer.playCard(alakazam);
        assertEquals("Sceptile", trainer.getActivePokemon().getName());
        trainer.playCard(raikou);
        assertEquals(2, trainer.getBenchPokemon().size());
        trainer.playCard(blaziken);
        assertEquals(3, trainer.getBenchPokemon().size());
        trainer.playCard(garchomp);
        assertEquals(4, trainer.getBenchPokemon().size());
        trainer.playCard(swampert);
        assertEquals(5, trainer.getBenchPokemon().size());
        trainer.playCard(pikachu);
        assertEquals(5, trainer.getBenchPokemon().size());
        trainer.playCard(grassEnergyCard);
        Map<String, Integer> energies = new HashMap<>();
        energies.put("Grass", 1);
        energies.put("Any", 1);
        assertEquals(energies, trainer.getActivePokemon().getEnergies());
    }

    @Test
    public void addToBenchTest() {
        assertEquals(0, trainer.getBenchPokemon().size());
        trainer.addToBench((IPokemon) sceptile);
        assertEquals(1, trainer.getBenchPokemon().size());
        trainer.addToBench((IPokemon) alakazam);
        trainer.addToBench((IPokemon) raikou);
        trainer.addToBench((IPokemon) blaziken);
        trainer.addToBench((IPokemon) garchomp);
        assertEquals(5, trainer.getBenchPokemon().size());
        trainer.addToBench((IPokemon) swampert);
        assertEquals(5, trainer.getBenchPokemon().size());
        assertEquals("Garchomp", trainer.getBenchPokemon().get(4).getName());
    }

    @Test
    public void replaceDeadPokemonTest() {
        IAttack attack = new DirectAttack(80, "Struggle", null, "Test Attack");
        trainer.playCard(sceptile);
        trainer.getActivePokemon().receiveDamage(attack);
        trainer.replaceDeadPokemon();
        assertNotNull(trainer.getActivePokemon());
        trainer.getActivePokemon().receiveDamage(attack);
        trainer.replaceDeadPokemon();
        assertNull(trainer.getActivePokemon());
        trainer.playCard(alakazam);
        trainer.playCard(raikou);
        assertEquals("Alakazam", trainer.getActivePokemon().getName());
        trainer.getActivePokemon().receiveDamage(attack);
        trainer.getActivePokemon().receiveDamage(attack);
        trainer.replaceDeadPokemon();
        assertEquals("Raikou", trainer.getActivePokemon().getName());
        assertEquals(0, trainer.getBenchPokemon().size());
    }

    @Test
    public void selectAttackTest() {
        List<IAttack> attackList = new ArrayList<>();
        IAttack attack1 = new DirectAttack(80, "Struggle", null, "Test Attack");
        IAttack attack2 = new DirectAttack(70, "Splash", null, "Test Attack");
        attackList.add(attack1);
        attackList.add(attack2);
        sceptile = new GrassPokemon(254, 120, "Sceptile", attackList);
        trainer.playCard(sceptile);
        assertNull(trainer.getActivePokemon().getSelectedAttack());
        trainer.selectAttack(0);
        assertEquals("Struggle", trainer.getActivePokemon().getSelectedAttack().getName());
        trainer.selectAttack(1);
        assertEquals("Splash", trainer.getActivePokemon().getSelectedAttack().getName());
        trainer.selectAttack(2);
        assertNull(trainer.getActivePokemon().getSelectedAttack());
    }
}
