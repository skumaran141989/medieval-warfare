package com.medieval.models.war.battle.attacks;

import java.util.Date;

import com.medieval.execution.war.battle.attacks.AttackExecution;
import com.medieval.models.Result;
import com.medieval.models.war.soldier.Platoon;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlatoonAttack extends Attack {
	private Platoon platoon;
	
	public PlatoonAttack(Date startTime, Date endTime, Platoon platoon) {
		super(startTime, endTime);
		this.platoon = platoon;
	}
	
	@Override
	public Result fight(Attack attack, AttackExecution attackExecutionStrategy) {
		return attackExecutionStrategy.ExecuteAttack(this, attack);
	}
}
