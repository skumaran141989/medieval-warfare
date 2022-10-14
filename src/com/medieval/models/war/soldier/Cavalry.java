package com.medieval.models.war.soldier;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cavalry extends SoldierType {
	
	public Cavalry() {
		super(); 
		this.setName(this.getClass().toString().toLowerCase());
	}
}
