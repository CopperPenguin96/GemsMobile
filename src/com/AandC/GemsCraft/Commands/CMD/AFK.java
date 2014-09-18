package com.AandC.GemsCraft.Commands.CMD;
import com.AandC.GemsCraft.Commands.*;
import com.AandC.GemsCraft.Players.*;
import com.AandC.GemsCraft.Network.*;

public class AFK extends Command
{
	@Override
	public String name = "AFK";
	@Override
	public String[] alliases = new String[] {
		"away"
	};
	@Override
	public boolean isVisible = true;

	@Override
	public void run(Player player)
	{
		if (!player.isAFK) {
			player.isAFK = true;
			Server.message(player.Nick + "is now AFK");
		} else {
			player.message("You are already AFK!");
		}
	}
}
