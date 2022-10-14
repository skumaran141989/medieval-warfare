package com.medieval.models.war.soldier;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Militias extends SoldierType {
	
	public Militias() {
		super(); 
		this.setName(this.getClass().toString().toLowerCase());
	}
}
