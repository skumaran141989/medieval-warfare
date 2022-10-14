package com.medieval.models.war.battle;

import com.medieval.models.Location;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BattleField extends Location {
	private Battle battle;
	
	public BattleField(double lattitude,  double longitude, Battle battle) {
		super(lattitude, longitude);
		this.battle = battle;
	}
}
