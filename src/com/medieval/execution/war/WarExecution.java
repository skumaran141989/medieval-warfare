package com.medieval.execution.war;

import com.medieval.execution.war.battle.attacks.AttackExecution;
import com.medieval.models.war.War;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class WarExecution {
	private AttackExecution attackExecution;
	
	public abstract void ExecuteWar(War war);
}
