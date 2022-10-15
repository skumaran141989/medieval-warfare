package com.medieval.execution.war;

import java.util.ArrayList;
import java.util.List;

import com.medieval.models.Result;
import com.medieval.models.war.War;
import com.medieval.models.war.battle.BattleField;
import com.medieval.models.war.battle.attacks.Attack;

public class KingWinningSequence implements WinningSequence {
	
	public War generateKingWarWinSequence(War inputWar, WarExecution warExecution) {
		
		List<Attack>  kingAttackList= new ArrayList<Attack>();
		List<BattleField> kingBattleFields = inputWar.getBattleFields();
		
		for(BattleField battleField : kingBattleFields) {
			kingAttackList.add(battleField.getBattle().getKing());
		}
		
		War war = findKingWinningSequence(kingAttackList, inputWar.clone(), warExecution, 0, 0, kingBattleFields.size());

		return war;
	}
	
	 private War findKingWinningSequence(List<Attack> kingAttackList, War newWar, WarExecution warExecution, int currentIndex, int currentLevel, int expectedSequenceSize) {
		 
		if(currentLevel == expectedSequenceSize) {
			newWar.setWarWinnner(warExecution);
			
			if (newWar.getResult() == Result.WIN)
				return newWar;
		}
		
		if(currentIndex < expectedSequenceSize) {
			War updatedWar = newWar.clone();
			BattleField newWarBattleField = updatedWar.getBattleFields().get(currentLevel);
			newWarBattleField.getBattle().setKing(kingAttackList.get(currentIndex));
			
			for(int i = 0; i < kingAttackList.size(); i++) {
				if(i != currentIndex) {
					findKingWinningSequence(kingAttackList, updatedWar, warExecution, i, currentLevel+1, expectedSequenceSize);
				}
			}
		}
		
		findKingWinningSequence(kingAttackList, newWar, warExecution, currentIndex+1, currentLevel, expectedSequenceSize);
		
		return null;
	 }
	
}
