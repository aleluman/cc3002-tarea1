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
    private IPokemon sceptile,
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
        grassEnergyCard = new GrassEnergy(trainer1);
        trainer1.selectActivePokemon(sceptile);
    }

    @Test
    public void constructorTest() {
        assertEquals("Alejandro", trainer1.getName());
        assertTrue(trainer1.getHand().isEmpty());
        assertTrue(trainer1.getBenchPokemon().isEmpty());
        assertNotNull(trainer1.getActivePokemon());
    }

    @Test
    public void addToBenchTest() {
        assertEquals(0, trainer1.getBenchPokemon().size());
        trainer1.addToBench(sceptile);
        assertEquals(1, trainer1.getBenchPokemon().size());
        trainer1.addToBench(alakazam);
        trainer1.addToBench(raikou);
        trainer1.addToBench(blaziken);
        trainer1.addToBench(garchomp);
        assertEquals(5, trainer1.getBenchPokemon().size());
        trainer1.addToBench(swampert);
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
    }

    @Test
    public void selectAttackTest() {
        List<IAttack> attackList = new ArrayList<>();
        IAttack attack1 = new DirectAttack(80, "Struggle", null, "Test Attack");
        IAttack attack2 = new DirectAttack(70, "Splash", null, "Test Attack");
        attackList.add(attack1);
        attackList.add(attack2);
        sceptile = new GrassPokemon(254, 120, "Sceptile", attackList, 2, trainer1, 0, null);
        trainer1.selectActivePokemon(sceptile);
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
