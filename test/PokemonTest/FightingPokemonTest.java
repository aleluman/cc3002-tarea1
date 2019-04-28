package PokemonTest;

import java.util.*;

import cc3002.tarea1.*;
import cc3002.tarea1.Attacks.DirectAttack;
import cc3002.tarea1.Energies.GrassEnergy;
import cc3002.tarea1.Pokemon.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FightingPokemonTest {
    private IPokemon
            sceptile,
            alakazam,
            raikou,
            blaziken,
            garchomp,
            swampert;
    private IAttack testAttack;
    private ITrainer trainer;
    private IEnergy energy;


    @Before
    public void setUp() {
        Map<String, Integer> cost = new HashMap<>();
        cost.put("Any", 2);
        testAttack = new DirectAttack(50, "Struggle", cost, "Test attack");
        sceptile = new GrassPokemon(254, 120, "Sceptile",
                new ArrayList<>(Collections.singleton(testAttack)));
        alakazam = new PsychicPokemon(65, 110, "Alakazam",
                new ArrayList<>(Collections.singleton(testAttack)));
        raikou = new LightningPokemon(243, 150, "Raikou",
                new ArrayList<>(Collections.singleton(testAttack)));
        blaziken = new FirePokemon(257, 120, "Blaziken",
                new ArrayList<>(Collections.singleton(testAttack)));
        garchomp = new FightingPokemon(445, 140, "Garchomp",
                new ArrayList<>(Collections.singleton(testAttack)));
        swampert = new WaterPokemon(260, 120, "Swampert",
                new ArrayList<>(Collections.singleton(testAttack)));
        trainer = new Trainer("Alejandro");
        energy = new GrassEnergy() ;
    }

    @Test
    public void constructorTest() {
        assertEquals(445, garchomp.getID());
        assertEquals(140, garchomp.getHP());
        assertEquals("Garchomp", garchomp.getName());
        assertEquals("Struggle", garchomp.getAttacks().get(0).getName());
        List<IAttack> attackList = new ArrayList<>();
        attackList.add(testAttack);
        attackList.add(testAttack);
        attackList.add(testAttack);
        attackList.add(testAttack);
        garchomp = new GrassPokemon(445, 140, "Garchomp", attackList);
        assertEquals(4, garchomp.getAttacks().size());
        attackList.add(testAttack);
        garchomp = new GrassPokemon(445, 140, "Garchomp", attackList);
        assertEquals(4, garchomp.getAttacks().size());
    }

    @Test
    public void isDeadTest() {
        assertFalse(garchomp.isDead());
        sceptile.selectAttack(testAttack);
        sceptile.attack(garchomp);
        assertFalse(garchomp.isDead());
        sceptile.attack(garchomp);
        assertTrue(garchomp.isDead());
    }

    @Test
    public void hasEnergyForAttackTest() {
        garchomp.selectAttack(testAttack);
        assertFalse(garchomp.hasEnergyForAttack());
        energy.addToPokemon(garchomp);
        assertFalse(garchomp.hasEnergyForAttack());
        energy.addToPokemon(garchomp);
        assertTrue(garchomp.hasEnergyForAttack());
    }

    @Test
    public void attackAndDamageTest() {
        sceptile.selectAttack(testAttack);
        alakazam.selectAttack(testAttack);
        raikou.selectAttack(testAttack);
        blaziken.selectAttack(testAttack);
        garchomp.selectAttack(testAttack);
        swampert.selectAttack(testAttack);
        sceptile.attack(garchomp);
        assertEquals(100, garchomp.getReceivedDamage());
        alakazam.attack(garchomp);
        assertEquals(200, garchomp.getReceivedDamage());
        raikou.attack(garchomp);
        assertEquals(250, garchomp.getReceivedDamage());
        blaziken.attack(garchomp);
        assertEquals(300, garchomp.getReceivedDamage());
        garchomp.attack(garchomp);
        assertEquals(350, garchomp.getReceivedDamage());
        swampert.attack(garchomp);
        assertEquals(400, garchomp.getReceivedDamage());
    }
}
