package com.medieval.models.war.battle.attacks;

import java.util.Date;

import com.medieval.execution.war.battle.attacks.AttackExecution;
import com.medieval.models.Result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Attack {
	private Date startTime;
	private Date endTime;
	
	public Attack(Date startTime, Date endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public abstract Result fight(Attack attack, AttackExecution attackExecutionStrategy);
}
