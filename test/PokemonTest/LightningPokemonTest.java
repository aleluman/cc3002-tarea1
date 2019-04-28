package PokemonTest;

import java.util.*;

import cc3002.tarea1.*;
import cc3002.tarea1.Attacks.DirectAttack;
import cc3002.tarea1.Energies.GrassEnergy;
import cc3002.tarea1.Pokemon.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LightningPokemonTest {
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
        assertEquals(243, raikou.getID());
        assertEquals(150, raikou.getHP());
        assertEquals("Raikou", raikou.getName());
        assertEquals("Struggle", raikou.getAttacks().get(0).getName());
        List<IAttack> attackList = new ArrayList<>();
        attackList.add(testAttack);
        attackList.add(testAttack);
        attackList.add(testAttack);
        attackList.add(testAttack);
        raikou = new GrassPokemon(243, 150, "Raikou", attackList);
        assertEquals(4, raikou.getAttacks().size());
        attackList.add(testAttack);
        raikou = new GrassPokemon(243, 150, "Raikou", attackList);
        assertEquals(4, raikou.getAttacks().size());
    }

    @Test
    public void isDeadTest() {
        assertFalse(raikou.isDead());
        garchomp.selectAttack(testAttack);
        garchomp.attack(raikou);
        assertFalse(raikou.isDead());
        garchomp.attack(raikou);
        assertTrue(raikou.isDead());
    }

    @Test
    public void hasEnergyForAttackTest() {
        raikou.selectAttack(testAttack);
        assertFalse(raikou.hasEnergyForAttack());
        energy.addToPokemon(raikou);
        assertFalse(raikou.hasEnergyForAttack());
        energy.addToPokemon(raikou);
        assertTrue(raikou.hasEnergyForAttack());
    }

    @Test
    public void attackAndDamageTest() {
        sceptile.selectAttack(testAttack);
        alakazam.selectAttack(testAttack);
        raikou.selectAttack(testAttack);
        blaziken.selectAttack(testAttack);
        garchomp.selectAttack(testAttack);
        swampert.selectAttack(testAttack);
        sceptile.attack(raikou);
        assertEquals(50, raikou.getReceivedDamage());
        alakazam.attack(raikou);
        assertEquals(100, raikou.getReceivedDamage());
        raikou.attack(raikou);
        assertEquals(150, raikou.getReceivedDamage());
        blaziken.attack(raikou);
        assertEquals(200, raikou.getReceivedDamage());
        garchomp.attack(raikou);
        assertEquals(300, raikou.getReceivedDamage());
        swampert.attack(raikou);
        assertEquals(350, raikou.getReceivedDamage());
    }
}
