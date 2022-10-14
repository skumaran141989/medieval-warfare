package com.medieval.models.war.battle;

import com.medieval.execution.war.battle.attacks.AttackExecution;
import com.medieval.models.Result;
import com.medieval.models.war.battle.attacks.Attack;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Battle {
    private Attack king;
    private Attack opponent;
    private Result result;
    
	public Battle(Attack hero,  Attack opponent) {
		this.king = hero;
		this.opponent = opponent;
	}
	
	public void ExecuteBattle(AttackExecution attackExecutionStrategy) {
		this.result = king.fight(opponent, attackExecutionStrategy);
	}
}
