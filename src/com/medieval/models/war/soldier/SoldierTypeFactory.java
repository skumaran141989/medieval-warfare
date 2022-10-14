package com.medieval.models.war.soldier;

public class SoldierTypeFactory {
	
	public static SoldierType getSoldierType(String type) {
		Militias militias = new Militias();
		Cavalry cavalry = new Cavalry();
		type = type.toLowerCase();
		
		if (militias.getName().equals(type))
			return militias;
		else if (cavalry.getName().equals(type))
			return cavalry;
		
		return null;
	}
	
}
