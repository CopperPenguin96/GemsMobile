package com.AandC.GemsCraft.PlayerDB;
import com.AandC.GemsCraft.Commands.*;
import com.AandC.GemsCraft.Exceptions.*;

public class Player
{
	public int ID;
	public String name;
	public String nick;
	public double hours;
	public int joinMonth;
	public int joinDay;
	public int joinYear;
	public boolean isBanned;
	public int kicks;
	public boolean isWarned;
	public boolean isDonator;  
	public String currentIP;
	public String[] allIP;
	public void setIP(String IP){
		int arrayCount = 0;
		for (String array:allIP) {
			arrayCount++;
			System.out.println(array.toString());
		}
		arrayCount++;
		allIP[arrayCount] = IP;
	}
	public Rank rank = new Rank();
	public boolean isOnline(Player player) {
		for (Player setPlayer:Players.players) {
			if (setPlayer.equals(player)) {
				return true;
			}
		}
		return false;
	}
	
	public void runCommand(Command cmd) throws NullCommandException{
		if (cmd.equals(null)) {
			throw new NullCommandException();
		} else {
			
		}
	}
}
