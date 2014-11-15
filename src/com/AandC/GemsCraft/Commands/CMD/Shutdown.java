package com.AandC.GemsCraft.Commands.CMD;
import com.AandC.GemsCraft.Commands.*;
import java.util.*;
import java.awt.*;
import com.AandC.GemsCraft.Console.*;
import com.AandC.GemsCraft.Exceptions.*;
import com.AandC.GemsCraft.System.*;
import com.AandC.GemsCraft.Console.LogTypes.*;

public class Shutdown extends Command
{
	private String name = "Shutdown";
	@Override
	public String getName()
	{
		return this.name;
	}

	private String[] alliases = new String[] {
		"sd"
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
	int secondsLeft = 5;
	@Override
	public void run()
	{
		
		if (secondsLeft > 0) {
			try
			{
				new Log("×××Server will be shutting down in " + secondsLeft +
						" seconds!×××", new Warning());
				Thread.sleep(1000);
				secondsLeft -= 1;
				if (!(secondsLeft > 0)) {
					System.exit(0);
				} else {
					this.run();
				}
			} catch (Exception e) {
				
			}
		}
	}
}
