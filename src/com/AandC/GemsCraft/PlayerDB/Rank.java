package com.AandC.GemsCraft.PlayerDB;
import com.AandC.GemsCraft.Commands.*;

public class Rank
{
	public String title;
	public int power;
	public void setRankPower() {
		/*
			TODO
			
			Setup rank power
		*/
	}
	public boolean playerHasPermission(Player player, Command command) {
		/*if (player.rank.power < command.RequiredPower) {
			return false;
		} else return true;*/
		return false;
	}
}
