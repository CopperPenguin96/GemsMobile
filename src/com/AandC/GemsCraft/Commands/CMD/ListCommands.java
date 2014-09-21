package com.AandC.GemsCraft.Commands.CMD;
import com.AandC.GemsCraft.Commands.*;
import com.AandC.GemsCraft.Network.*;
import com.AandC.GemsCraft.Console.*;
import com.AandC.GemsCraft.Exceptions.*;

public class ListCommands extends Command
{
	private String name = "ListCommands";
	@Override
	public String getName()
	{
		return this.name;
	}

	private String[] alliases = new String[] {
		"list"
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
		String cmdList = "Available commands are: ";
		int arrayLength = Commands.cmdList.length;
		int fountainLength = 0;
		for (Command list:Commands.cmdList) {
			if (list.getVisibility()) {
				if (fountainLength < arrayLength) cmdList += list.getName() + ", ";
				else cmdList += list.getName();
			}
			fountainLength++;
		}
		try
		{
			Log cmdListLog = new Log(cmdList);
		} catch (InvalidLogException e) {
			new Logs(e);
		}
	}
}
