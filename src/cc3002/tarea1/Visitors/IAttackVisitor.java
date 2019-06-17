package cc3002.tarea1.Visitors;

import cc3002.tarea1.Attacks.Ability;
import cc3002.tarea1.Attacks.DirectAttack;

public interface IAttackVisitor{
    void visitDirectAttack(DirectAttack attack);
    void visitAbility(Ability ability);
}
