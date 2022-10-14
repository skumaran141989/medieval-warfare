package com.medieval.input.builder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import com.medieval.models.war.War;
import com.medieval.models.war.battle.Battle;
import com.medieval.models.war.battle.BattleField;
import com.medieval.models.war.battle.attacks.PlatoonAttack;
import com.medieval.models.war.soldier.Platoon;
import com.medieval.models.war.soldier.SoldierTypeFactory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatternBasedWarBuilder extends WarFieldBuilder {
	private Pattern battleMatcherPattern;
	private Pattern platoonMatcherPattern;
	
	public War Build(InputStreamReader inpustreamReader) {
		
		try(BufferedReader reader = new BufferedReader(inpustreamReader)){
			
			List<String> inputBattles = new ArrayList<String>();
		
			inputBattles.add(reader.readLine());
			inputBattles.add(reader.readLine());
			
			return Build(inputBattles.get(0), inputBattles.get(1));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private War Build(String kingbattlefieldStrings, String opponentsbattlefieldStrings) {
		War war = new War();
		
		String[] kingbattlefields =  getBattleMatcherPattern().split(kingbattlefieldStrings);
		String[] opponentsbattlefields = getBattleMatcherPattern().split(opponentsbattlefieldStrings);
		
		if(kingbattlefields!=opponentsbattlefields)
			return null;
		
		for(int i = 0;i < kingbattlefields.length; i++) {
			Date startDate = new Date();
			Date endDate = new Date(startDate.getTime()+sevenDaysMilliSeconds);
			
			String[] kingAttackString = getPlatoonMatcherPattern().split(kingbattlefields[i]);
			Platoon kingPlatoon = new Platoon(SoldierTypeFactory.getSoldierType(kingAttackString[0]), Integer.parseInt(kingAttackString[1]));
			PlatoonAttack kingAttack = new PlatoonAttack(startDate, endDate,kingPlatoon);
			
			String[] opponentsAttackString = getPlatoonMatcherPattern().split(opponentsbattlefields[i]);
			Platoon opponentPlatoon = new Platoon(SoldierTypeFactory.getSoldierType(opponentsAttackString[0]), Integer.parseInt(opponentsAttackString[1]));
			PlatoonAttack opponentAttack = new PlatoonAttack(startDate, endDate, opponentPlatoon);
			
			Battle battle = new Battle(kingAttack, opponentAttack);
			
			war.addBattleField(new BattleField(i,i,battle));
		}
		
		return war;
	}
}
