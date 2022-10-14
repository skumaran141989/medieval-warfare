package com.medieval.models.war;

import java.util.ArrayList;
import java.util.List;

import com.medieval.execution.war.WarExecution;
import com.medieval.models.Result;
import com.medieval.models.war.battle.BattleField;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class War {
	private List<BattleField> battleFields;
	private Result result;
	
	public War() {
		this.battleFields = new ArrayList<BattleField>();
		this.result = Result.NR;
	}
	
	public void addBattleField(BattleField battleField) {
		battleFields.add(battleField);
	}
	
	public void setWarWinnner(WarExecution execution) {
		execution.ExecuteWar(this);
	}
	
	@Override
	public War clone() {
		War war = new War();
		war.setBattleFields(new ArrayList<BattleField>(this.battleFields));
		return war;
	}
}
