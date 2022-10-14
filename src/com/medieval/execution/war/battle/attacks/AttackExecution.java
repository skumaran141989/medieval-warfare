package com.medieval.execution.war.battle.attacks;

import com.medieval.models.Result;
import com.medieval.models.war.battle.attacks.Attack;

public interface AttackExecution {
	abstract Result ExecuteAttack(Attack opponentOne, Attack opponentTwo);
}
