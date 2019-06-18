package PokemonTest;

import java.util.*;

import cc3002.tarea1.Attacks.DirectAttack;
import cc3002.tarea1.Attacks.IAttack;
import cc3002.tarea1.Energies.GrassEnergy;
import cc3002.tarea1.Energies.IEnergy;
import cc3002.tarea1.ITrainer;
import cc3002.tarea1.Pokemon.*;
import cc3002.tarea1.Trainer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GrassPokemonTest {
    private IPokemon
            sceptile,
            alakazam,
            raikou,
            blaziken,
            garchomp,
            swampert;
    private IAttack testAttack;
    private IEnergy energy;
    private ITrainer trainer;

    @Before
    public void setUp() {
        trainer = new Trainer("Alejandro");
        Map<String, Integer> cost = new HashMap<>();
        cost.put("Any", 2);
        testAttack = new DirectAttack(50, "Struggle", cost, "Test attack");
        sceptile = new GrassPokemon(254, 120, "Sceptile",
                new ArrayList<>(Collections.singleton(testAttack)), 2, trainer, 0, null);
        alakazam = new PsychicPokemon(65, 110, "Alakazam",
                new ArrayList<>(Collections.singleton(testAttack)), 2, trainer, 0, null);
        raikou = new LightningPokemon(243, 150, "Raikou",
                new ArrayList<>(Collections.singleton(testAttack)), 2, trainer, 0, null);
        blaziken = new FirePokemon(257, 120, "Blaziken",
                new ArrayList<>(Collections.singleton(testAttack)), 2, trainer, 0, null);
        garchomp = new FightingPokemon(445, 140, "Garchomp",
                new ArrayList<>(Collections.singleton(testAttack)), 2, trainer, 0, null);
        swampert = new WaterPokemon(260, 120, "Swampert",
                new ArrayList<>(Collections.singleton(testAttack)), 2, trainer, 0, null);
        energy = new GrassEnergy() ;
    }

    @Test
    public void constructorTest() {
        assertEquals(254, sceptile.getID());
        assertEquals(120, sceptile.getHP());
        assertEquals("Sceptile", sceptile.getName());
        assertEquals("Struggle", sceptile.getAttacks().get(0).getName());
        List<IAttack> attackList = new ArrayList<>();
        attackList.add(testAttack);
        attackList.add(testAttack);
        attackList.add(testAttack);
        attackList.add(testAttack);
        sceptile = new GrassPokemon(254, 120, "Sceptile", attackList, 2, trainer, 0, null);
        assertEquals(4, sceptile.getAttacks().size());
        attackList.add(testAttack);
        sceptile = new GrassPokemon(254, 120, "Sceptile", attackList, 2, trainer, 0, null);
        assertEquals(4, sceptile.getAttacks().size());
    }

    @Test
    public void isDeadTest() {
        assertFalse(sceptile.isDead());
        blaziken.selectAttack(testAttack);
        blaziken.attack(sceptile);
        assertFalse(sceptile.isDead());
        blaziken.attack(sceptile);
        assertTrue(sceptile.isDead());
    }

    @Test
    public void hasEnergyForAttackTest() {
        sceptile.selectAttack(testAttack);
        assertFalse(sceptile.hasEnergyForAttack());
        energy.addToPokemon(sceptile);
        assertFalse(sceptile.hasEnergyForAttack());
        energy.addToPokemon(sceptile);
        assertTrue(sceptile.hasEnergyForAttack());
    }

    @Test
    public void attackAndDamageTest() {
        sceptile.selectAttack(testAttack);
        alakazam.selectAttack(testAttack);
        raikou.selectAttack(testAttack);
        blaziken.selectAttack(testAttack);
        garchomp.selectAttack(testAttack);
        swampert.selectAttack(testAttack);
        sceptile.attack(sceptile);
        assertEquals(50, sceptile.getReceivedDamage());
        alakazam.attack(sceptile);
        assertEquals(100, sceptile.getReceivedDamage());
        raikou.attack(sceptile);
        assertEquals(150, sceptile.getReceivedDamage());
        blaziken.attack(sceptile);
        assertEquals(250, sceptile.getReceivedDamage());
        garchomp.attack(sceptile);
        assertEquals(300, sceptile.getReceivedDamage());
        swampert.attack(sceptile);
        assertEquals(320, sceptile.getReceivedDamage());
        testAttack = new DirectAttack(20, "Struggle", null, "Test attack");
        swampert.selectAttack(testAttack);
        swampert.attack(sceptile);
        assertEquals(320, sceptile.getReceivedDamage());
    }
}
