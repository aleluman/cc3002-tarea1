package PokemonTest;

import java.util.*;

import cc3002.tarea1.Attacks.DirectAttack;
import cc3002.tarea1.Attacks.IAttack;
import cc3002.tarea1.Energies.GrassEnergy;
import cc3002.tarea1.Energies.IEnergy;
import cc3002.tarea1.Pokemon.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FirePokemonTest {
    private IPokemon
            sceptile,
            alakazam,
            raikou,
            blaziken,
            garchomp,
            swampert;
    private IAttack testAttack;
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
        energy = new GrassEnergy() ;
    }

    @Test
    public void constructorTest() {
        assertEquals(257, blaziken.getID());
        assertEquals(120, blaziken.getHP());
        assertEquals("Blaziken", blaziken.getName());
        assertEquals("Struggle", blaziken.getAttacks().get(0).getName());
        List<IAttack> attackList = new ArrayList<>();
        attackList.add(testAttack);
        attackList.add(testAttack);
        attackList.add(testAttack);
        attackList.add(testAttack);
        blaziken = new GrassPokemon(257, 120, "Blaziken", attackList);
        assertEquals(4, blaziken.getAttacks().size());
        attackList.add(testAttack);
        blaziken = new GrassPokemon(257, 120, "Blaziken", attackList);
        assertEquals(4, blaziken.getAttacks().size());
    }

    @Test
    public void isDeadTest() {
        assertFalse(blaziken.isDead());
        swampert.selectAttack(testAttack);
        swampert.attack(blaziken);
        assertFalse(blaziken.isDead());
        swampert.attack(blaziken);
        assertTrue(blaziken.isDead());
    }

    @Test
    public void hasEnergyForAttackTest() {
        blaziken.selectAttack(testAttack);
        assertFalse(blaziken.hasEnergyForAttack());
        energy.addToPokemon(blaziken);
        assertFalse(blaziken.hasEnergyForAttack());
        energy.addToPokemon(blaziken);
        assertTrue(blaziken.hasEnergyForAttack());
    }

    @Test
    public void attackAndDamageTest() {
        sceptile.selectAttack(testAttack);
        alakazam.selectAttack(testAttack);
        raikou.selectAttack(testAttack);
        blaziken.selectAttack(testAttack);
        garchomp.selectAttack(testAttack);
        swampert.selectAttack(testAttack);
        sceptile.attack(blaziken);
        assertEquals(50, blaziken.getReceivedDamage());
        alakazam.attack(blaziken);
        assertEquals(100, blaziken.getReceivedDamage());
        raikou.attack(blaziken);
        assertEquals(150, blaziken.getReceivedDamage());
        blaziken.attack(blaziken);
        assertEquals(200, blaziken.getReceivedDamage());
        garchomp.attack(blaziken);
        assertEquals(250, blaziken.getReceivedDamage());
        swampert.attack(blaziken);
        assertEquals(350, blaziken.getReceivedDamage());
    }
}
