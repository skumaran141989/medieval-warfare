package com.medieval.execution.war.battle.attacks;

import com.medieval.models.Result;
import com.medieval.models.war.battle.attacks.Attack;
import com.medieval.models.war.battle.attacks.PlatoonAttack;
import com.medieval.models.war.soldier.Platoon;
import com.medieval.models.war.soldier.SoldierType;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OverrideMultiplierBasedPlantoonAttackExecutionStartegy implements AttackExecution {
	public int overrideMultiplier;
	
	public Result ExecuteAttack(Attack opponentOne, Attack opponentTwo) {
		PlatoonAttack opponentTwoPlatoonAttack = (PlatoonAttack) opponentTwo;
		Platoon opponentTwoPlatoon = opponentTwoPlatoonAttack.getPlatoon();
		
		PlatoonAttack opponentOnePlatoonAttack = (PlatoonAttack) opponentOne;
		Platoon opponentOnePlatoon = opponentOnePlatoonAttack.getPlatoon();
		
		int thisSize = opponentOnePlatoon.getSize();
		SoldierType thisSoldierType = opponentOnePlatoon.getSoldierType();
		
		int opponentSize = opponentTwoPlatoon.getSize();
		SoldierType opponentSoldierType = opponentTwoPlatoon.getSoldierType();

		if (thisSoldierType.isOverrides(opponentSoldierType) && (overrideMultiplier*thisSize) > opponentSize) {
				return Result.WIN;
		}
		else if (thisSize > opponentSize && !(opponentSoldierType.isOverrides(thisSoldierType) && overrideMultiplier*opponentSize>thisSize)) {
				return Result.WIN;
		}
		if (thisSize == opponentSize || (thisSoldierType.isOverrides(opponentSoldierType) && (overrideMultiplier*thisSize) == opponentSize) || (opponentSoldierType.isOverrides(thisSoldierType) && overrideMultiplier*opponentSize == thisSize)) {
			return Result.NR;
		}
			
		return Result.LOSS;
	}
}
