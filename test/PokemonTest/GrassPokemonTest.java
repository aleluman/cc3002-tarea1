package PokemonTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import cc3002.tarea1.Attacks.DirectAttack;
import cc3002.tarea1.IAttack;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.Pokemon.*;
import org.junit.Before;
import org.junit.Test;

public class GrassPokemonTest {
    private IPokemon
            sceptile,
            alakazam,
            raikou,
            blaziken,
            garchomp,
            swampert;
    private IAttack
            blastburn,
            thunder,
            futureSight,
            muddyWater,
            dragonRush,
            leafBlade;
    int[] cost;


    @Before
    private void setUp() {
        cost = new int[]{2, 0, 0, 0, 0, 0, 0};
        blastburn = new DirectAttack(50, "Blast Burn", cost, "Fire Attack");
        thunder = new DirectAttack(50, "Thunder", cost, "Lightning Attack");
        futureSight = new DirectAttack(40, "Future Sight", cost, "Psychic Attack");
        muddyWater = new DirectAttack(30, "Muddy Water", cost, "Water Attack");
        dragonRush = new DirectAttack(20, "Dragon Rush", cost, "Fighting Attack");
        leafBlade = new DirectAttack(30, "Leaf Blade", cost, "Grass Attack");
        sceptile = new GrassPokemon(254, 120, "Sceptile",
                new ArrayList<>(Collections.singleton(leafBlade)));
        alakazam = new PsychicPokemon(65, 110, "Alakazam",
                new ArrayList<>(Collections.singleton(futureSight)));
        raikou = new LightningPokemon(243, 150, "Raikou",
                new ArrayList<>(Collections.singleton(thunder)));
        blaziken = new FirePokemon(257, 120, "Blaziken",
                new ArrayList<>(Collections.singleton(blastburn)));
        garchomp = new FightingPokemon(445, 140, "Garchomp",
                new ArrayList<>(Collections.singleton(dragonRush)));
        swampert = new WaterPokemon(260, 120, "Swampert",
                new ArrayList<>(Collections.singleton(muddyWater)));
    }
}
