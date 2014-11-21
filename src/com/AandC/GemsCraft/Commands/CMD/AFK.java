package com.AandC.GemsCraft.Commands.CMD;
import com.AandC.GemsCraft.Commands.*;
import com.AandC.GemsCraft.Players.*;
import com.AandC.GemsCraft.Network.*;

public class AFK extends Command
{
	private String name = "AFK";
	@Override
	public String getName()
	{
		return this.name;
	}
	
	private String[] alliases = new String[] {
		"away"
	};
	@Override
	public String[] getAlliases()
	{
		return this.alliases;
	}
	
	private boolean isVisible = true;
	@Override
	public boolean getVisibility() {
		return isVisible;
	}

	@Override
	public void run()
	{
		if (!p.isAFK) {
			p.isAFK = true;
			Server.message(p.Nick + " is now AFK", p);
		} else {
			p.message("You are already AFK!");
		}
	}
}
