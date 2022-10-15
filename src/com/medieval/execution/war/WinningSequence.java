package com.medieval.execution.war;

import com.medieval.models.war.War;

public interface WinningSequence {
	War generateKingWarWinSequence(War inputWar, WarExecution warExecution);
}
