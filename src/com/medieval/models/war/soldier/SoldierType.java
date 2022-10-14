package com.medieval.models.war.soldier;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class SoldierType {
	private Set<SoldierType> overridingSoldierTypes;
	private String name;
	
	public SoldierType() {
		this.overridingSoldierTypes = new HashSet<SoldierType>();
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	
	@Override
	public boolean equals(Object input) {
		SoldierType inputObject = (SoldierType)input;
		return this.name.equals(inputObject.name);
	}
	
	public boolean isOverrides(SoldierType inputSoldierTypes) {
		return overridingSoldierTypes.contains(inputSoldierTypes);
	}
}


