package com.AandC.GemsCraft.PlayerDB;
import com.AandC.GemsCraft.Commands.*;

public class Players
{
	public static Player[] players;
	public static void assignPlayers(Player player, int playerAmount) {
		int minStart = 1;
		for (minStart = 1; minStart <= playerAmount; minStart++) {
			players[minStart] = player;
		}
	}
	
}
