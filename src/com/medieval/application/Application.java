package com.medieval.application;

import java.io.InputStreamReader;
import java.util.regex.Pattern;

import com.medieval.execution.war.KingWinningSequence;
import com.medieval.execution.war.ThresholdBasedWarExecution;
import com.medieval.execution.war.WinningSequence;
import com.medieval.execution.war.battle.attacks.OverrideMultiplierBasedPlantoonAttackExecutionStartegy;
import com.medieval.input.builder.PatternBasedWarBuilder;
import com.medieval.models.war.War;

public class Application {
	
	public static void main(String[] args) {
		WinningSequence winningSequence = new KingWinningSequence();
		
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
		
		winningSequence.generateKingWarWinSequence(inputWar, warExecution);
	}
}
