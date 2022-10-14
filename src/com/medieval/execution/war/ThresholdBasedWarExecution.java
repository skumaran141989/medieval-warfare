package com.medieval.execution.war;

import java.util.List;

import com.medieval.models.Result;
import com.medieval.models.war.War;
import com.medieval.models.war.battle.BattleField;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ThresholdBasedWarExecution extends WarExecution {
	private int victorythershold;
	
	@Override
	public void ExecuteWar(War war) {
		List<BattleField> battleFields = war.getBattleFields();
		int winningCounts = 0;
				
		for(BattleField battleField: battleFields) {
			battleField.getBattle().ExecuteBattle(getAttackExecution());
			if(battleField.getBattle().getResult() == Result.WIN)
				winningCounts++;
		}
		
		if (winningCounts > victorythershold) {
			war.setResult(Result.WIN);
		}
		else if (winningCounts < victorythershold) {
			war.setResult(Result.LOSS);
		}
	}
}
