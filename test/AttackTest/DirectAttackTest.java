package AttackTest;

import cc3002.tarea1.Attacks.DirectAttack;
import cc3002.tarea1.Energies.GrassEnergy;
import cc3002.tarea1.Energies.WaterEnergy;
import cc3002.tarea1.IAttack;
import cc3002.tarea1.IEnergy;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.Pokemon.GrassPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class DirectAttackTest {
    private IAttack attack1,
            attack2,
            attack3;
    private IPokemon sceptile;
    private IEnergy grassEnergy,
            waterEnergy;

    @Before
    public void setUp() {
        Map<String, Integer> cost1 = new HashMap<>();
        cost1.put("Grass", 2);
        attack1 = new DirectAttack(50, "Leaf Blade", cost1, "Grass Attack");
        Map<String, Integer> cost2 = new HashMap<>();
        cost2.put("Any", 3);
        attack2 = new DirectAttack(70, "Focus Blast", cost2, "Fighting Attack");
        Map<String, Integer> cost3 = new HashMap<>();
        cost3.put("Grass", 1);
        cost3.put("Any", 2);
        attack3 = new DirectAttack(30, "Thunder Punch", cost3, "Lightning Attack");
        List<IAttack> attackList = new ArrayList<>();
        attackList.add(attack1);
        attackList.add(attack2);
        attackList.add(attack3);
        sceptile = new GrassPokemon(254, 120, "Sceptile", attackList);
        grassEnergy = new GrassEnergy();
        waterEnergy = new WaterEnergy();
    }

    @Test
    public void constructorTest() {
        assertEquals(50, attack1.getDamage());
        assertEquals("Leaf Blade", attack1.getName());
        assertEquals("Grass Attack", attack1.getDescription());
        Map<String, Integer> cost1 = new HashMap<>();
        cost1.put("Grass", 2);
        assertEquals(cost1, attack1.getEnergiesNeeded());
    }

    @Test
    public void hasEnergyTest() {
        assertFalse(attack1.hasEnergy(sceptile));
        sceptile.addEnergy(grassEnergy);
        assertFalse(attack1.hasEnergy(sceptile));
        sceptile.addEnergy(waterEnergy);
        assertFalse(attack1.hasEnergy(sceptile));
        assertFalse(attack2.hasEnergy(sceptile));
        assertTrue(attack3.hasEnergy(sceptile));
        sceptile.addEnergy(grassEnergy);
        assertTrue(attack1.hasEnergy(sceptile));
        assertTrue(attack2.hasEnergy(sceptile));
    }
}
