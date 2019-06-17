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

public class PsychicPokemonTest {
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
        assertEquals(65, alakazam.getID());
        assertEquals(110, alakazam.getHP());
        assertEquals("Alakazam", alakazam.getName());
        assertEquals("Struggle", alakazam.getAttacks().get(0).getName());
        List<IAttack> attackList = new ArrayList<>();
        attackList.add(testAttack);
        attackList.add(testAttack);
        attackList.add(testAttack);
        attackList.add(testAttack);
        alakazam = new GrassPokemon(254, 110, "Alakazam", attackList);
        assertEquals(4, alakazam.getAttacks().size());
        attackList.add(testAttack);
        alakazam = new GrassPokemon(254, 110, "Alakazam", attackList);
        assertEquals(4, alakazam.getAttacks().size());
    }

    @Test
    public void isDeadTest() {
        assertFalse(alakazam.isDead());
        alakazam.selectAttack(testAttack);
        alakazam.attack(alakazam);
        assertFalse(alakazam.isDead());
        alakazam.attack(alakazam);
        assertTrue(alakazam.isDead());
    }

    @Test
    public void hasEnergyForAttackTest() {
        alakazam.selectAttack(testAttack);
        assertFalse(alakazam.hasEnergyForAttack());
        energy.addToPokemon(alakazam);
        assertFalse(alakazam.hasEnergyForAttack());
        energy.addToPokemon(alakazam);
        assertTrue(alakazam.hasEnergyForAttack());
    }

    @Test
    public void attackAndDamageTest() {
        sceptile.selectAttack(testAttack);
        alakazam.selectAttack(testAttack);
        raikou.selectAttack(testAttack);
        blaziken.selectAttack(testAttack);
        garchomp.selectAttack(testAttack);
        swampert.selectAttack(testAttack);
        sceptile.attack(alakazam);
        assertEquals(50, alakazam.getReceivedDamage());
        alakazam.attack(alakazam);
        assertEquals(150, alakazam.getReceivedDamage());
        raikou.attack(alakazam);
        assertEquals(200, alakazam.getReceivedDamage());
        blaziken.attack(alakazam);
        assertEquals(250, alakazam.getReceivedDamage());
        garchomp.attack(alakazam);
        assertEquals(270, alakazam.getReceivedDamage());
        swampert.attack(alakazam);
        assertEquals(320, alakazam.getReceivedDamage());
        testAttack = new DirectAttack(20, "Struggle", null, "Test attack");
        garchomp.selectAttack(testAttack);
        garchomp.attack(alakazam);
        assertEquals(320, alakazam.getReceivedDamage());
    }
}
