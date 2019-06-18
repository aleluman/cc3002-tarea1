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

public class WaterPokemonTest {
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
        assertEquals(260, swampert.getID());
        assertEquals(120, swampert.getHP());
        assertEquals("Swampert", swampert.getName());
        assertEquals("Struggle", swampert.getAttacks().get(0).getName());
        List<IAttack> attackList = new ArrayList<>();
        attackList.add(testAttack);
        attackList.add(testAttack);
        attackList.add(testAttack);
        attackList.add(testAttack);
        swampert = new GrassPokemon(260, 120, "Swampert", attackList, 2, trainer, 0, null);
        assertEquals(4, swampert.getAttacks().size());
        attackList.add(testAttack);
        swampert = new GrassPokemon(260, 120, "Swampert", attackList, 2, trainer, 0, null);
        assertEquals(4, swampert.getAttacks().size());
    }

    @Test
    public void isDeadTest() {
        assertFalse(swampert.isDead());
        raikou.selectAttack(testAttack);
        raikou.attack(swampert);
        assertFalse(swampert.isDead());
        raikou.attack(swampert);
        assertTrue(swampert.isDead());
    }

    @Test
    public void hasEnergyForAttackTest() {
        swampert.selectAttack(testAttack);
        assertFalse(swampert.hasEnergyForAttack());
        energy.addToPokemon(swampert);
        assertFalse(swampert.hasEnergyForAttack());
        energy.addToPokemon(swampert);
        assertTrue(swampert.hasEnergyForAttack());
    }

    @Test
    public void attackAndDamageTest() {
        sceptile.selectAttack(testAttack);
        alakazam.selectAttack(testAttack);
        raikou.selectAttack(testAttack);
        blaziken.selectAttack(testAttack);
        garchomp.selectAttack(testAttack);
        swampert.selectAttack(testAttack);
        sceptile.attack(swampert);
        assertEquals(100, swampert.getReceivedDamage());
        alakazam.attack(swampert);
        assertEquals(150, swampert.getReceivedDamage());
        raikou.attack(swampert);
        assertEquals(250, swampert.getReceivedDamage());
        blaziken.attack(swampert);
        assertEquals(300, swampert.getReceivedDamage());
        garchomp.attack(swampert);
        assertEquals(320, swampert.getReceivedDamage());
        swampert.attack(swampert);
        assertEquals(370, swampert.getReceivedDamage());
        testAttack = new DirectAttack(20, "Struggle", null, "Test attack");
        garchomp.selectAttack(testAttack);
        garchomp.attack(swampert);
        assertEquals(370, swampert.getReceivedDamage());
    }
}
