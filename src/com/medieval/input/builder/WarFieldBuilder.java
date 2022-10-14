package com.medieval.input.builder;

import java.io.InputStreamReader;

import com.medieval.models.war.War;


public abstract class WarFieldBuilder {

	static long sevenDaysMilliSeconds = 67800;
	
	public abstract War Build(InputStreamReader inpustreamReader);
}
