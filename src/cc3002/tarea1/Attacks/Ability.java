package cc3002.tarea1.Attacks;

import cc3002.tarea1.Pokemon.IPokemon;
import cc3002.tarea1.Visitors.IAttackVisitor;

import java.util.HashMap;


public class Ability extends AbstractAttack {
    private String name;
    private String description;

    public Ability(String name, String description) {
        super(0, name, new HashMap<>(), description);
    }

    @Override
    public int getDamage() {
        return 0;
    }

    @Override
    public boolean hasEnergy(IPokemon pokemon) {
        return true;
    }

    @Override
    public void accept(IAttackVisitor v) {
        v.visitAbility(this);
    }
}
