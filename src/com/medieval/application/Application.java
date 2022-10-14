package com.medieval.application;

import java.io.InputStreamReader;
import java.util.regex.Pattern;

import com.medieval.execution.war.ThresholdBasedWarExecution;
import com.medieval.execution.war.WarExecution;
import com.medieval.execution.war.battle.attacks.OverrideMultiplierBasedPlantoonAttackExecutionStartegy;
import com.medieval.input.builder.PatternBasedWarBuilder;
import com.medieval.models.Result;
import com.medieval.models.war.War;

public class Application {
	
	public static void main(String[] args) {
		Application application = new Application();
		
		OverrideMultiplierBasedPlantoonAttackExecutionStartegy overrideMultiplierBasedPlantoonAttackExecutionStartegy = new OverrideMultiplierBasedPlantoonAttackExecutionStartegy();
		overrideMultiplierBasedPlantoonAttackExecutionStartegy.setOverrideMultiplier(2);
		
		ThresholdBasedWarExecution warExecution = new ThresholdBasedWarExecution();
		warExecution.setAttackExecution(overrideMultiplierBasedPlantoonAttackExecutionStartegy);
		warExecution.setVictorythershold(3);
		
		PatternBasedWarBuilder patternBasedWarBuilder = new PatternBasedWarBuilder();
		patternBasedWarBuilder.setBattleMatcherPattern(Pattern.compile("#"));
		patternBasedWarBuilder.setPlatoonMatcherPattern(Pattern.compile("-"));
		
		War inputWar = patternBasedWarBuilder.Build(new InputStreamReader(System.in));
		if(inputWar == null) {
			System.out.println("Unable to create war from input");
		}
		
		War newWar = new War();
		
		if(application.checkKingWin(inputWar, newWar, 0, 0, warExecution)) {
			System.out.println("King winning sequence: ");
			System.out.print(newWar);
		}
		else {
			System.out.println("King can never Win!");
		}
	}
	
	public boolean checkKingWin(War inputWar, War newWar, int currentIndex, int currentLevel, WarExecution warExecution) {
		
		if(currentLevel == inputWar.getBattleFields().size()) {
			newWar.setWarWinnner(warExecution);
			
			return newWar.getResult() == Result.WIN;
		}
			
		if(currentIndex < inputWar.getBattleFields().size()) {
			War updatedWar = newWar.clone();
			updatedWar.addBattleField(inputWar.getBattleFields().get(currentIndex));
			
			checkKingWin(inputWar, updatedWar, currentIndex+1, currentLevel, warExecution);
		}
			
		checkKingWin(inputWar, newWar, currentIndex, currentLevel+1, warExecution);
		
		return false;
	}
}
