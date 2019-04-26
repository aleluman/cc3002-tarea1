package cc3002.tarea1.Attacks;

import cc3002.tarea1.AbstractAttack;

import java.util.List;
import java.util.Map;

public class DirectAttack extends AbstractAttack {
    public DirectAttack(int damage, String name, Map<String, Integer> energies, String description) {
        super(damage, name, energies, description);
    }
}
