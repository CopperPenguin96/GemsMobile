package com.AandC.GemsCraft.Commands;
import com.AandC.GemsCraft.Console.*;
import com.AandC.GemsCraft.Exceptions.*;
import com.AandC.GemsCraft.Players.*;

public class Command
{
	public String name = "Default";
	public String[] alliases = new String[]{
		"df","cmd"
	};
	public boolean isVisible = false;
	public void run(Player player) {
		try
		{
			Log thisLog = new Log("Default Command Template was run" +
				"by " + player.userName);
		} catch (InvalidLogException e) {
			
		}
	}
}
