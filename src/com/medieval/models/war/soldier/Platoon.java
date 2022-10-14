package com.medieval.models.war.soldier;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Platoon {
	protected SoldierType soldierType;
	protected int size;
	
	public Platoon(SoldierType soldierType, int size) {
		this.size = size;
		this.soldierType = soldierType;
	}
}
