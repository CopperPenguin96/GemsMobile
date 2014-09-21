package com.AandC.GemsCraft.Commands;
import com.AandC.GemsCraft.Console.*;
import com.AandC.GemsCraft.Exceptions.*;
import com.AandC.GemsCraft.Players.*;

public class Command
{
	//When creating a new command, each method and
	//function needs and Override before it
	
	//What users see and enter
	private String name = "Default";
	public String getName() {
		return name;
	}
	
	//The player running the command
	public Player p;
	
	//other keys to entering the command
	private String[] alliases = new String[]{
		"df","cmd"
	};
	public String[] getAlliases() {
		return alliases;
	}
	
	//Will this appear in /Commands?
	private boolean isVisible = false;
	public boolean getVisibility() {
		return isVisible;
	}
	
	//This is where you actually code for the command
	public void run() {
		try
		{
			Log thisLog = new Log("Default Command Template was run" +
				" by " + p.userName);
		} catch (InvalidLogException e) {
			e.printStackTrace();
		}
	}
}
