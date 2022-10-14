package com.medieval.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {
	protected double lattitude;
	protected double longitude;
	
	public Location(double lattitude,  double longitude) {
		this.lattitude = lattitude;
		this.longitude = longitude;
	}
}
