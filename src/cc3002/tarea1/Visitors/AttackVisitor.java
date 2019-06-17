package cc3002.tarea1.Visitors;

import cc3002.tarea1.Attacks.Ability;
import cc3002.tarea1.Attacks.DirectAttack;
import cc3002.tarea1.Energies.IEnergy;
import cc3002.tarea1.Pokemon.IPokemon;

public class AttackVisitor implements IAttackVisitor{
    @Override
    public void visitDirectAttack(DirectAttack attack) {

    }

    @Override
    public void visitAbility(Ability ability) {

    }
}
