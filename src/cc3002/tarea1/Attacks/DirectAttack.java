package cc3002.tarea1.Attacks;

import java.util.List;

public class DirectAttack extends AbstractAttack {
    protected DirectAttack(int damage, String name, List<String> energies, String description) {
        super(damage, name, energies, description);
    }
}