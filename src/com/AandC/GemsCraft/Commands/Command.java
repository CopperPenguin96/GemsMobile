package com.AandC.GemsCraft.Commands;
import com.AandC.GemsCraft.PlayerDB.*;
import org.jetbrains.annotations.*;

public interface Command {
    public void handle(Player player, CommandReader reader);

    // Since you'll need 1-class-per-command anyway, you might as well put
    // all the other stuff from fCraft's CommandDescriptor here.
    // Since Java has no properties, use getter methods!
	public String getName();
	public void setName(String name);
    // etc.
	//Aliases
	public String[] getAliases();
	public void setAliases(String[] aliases);
	//CommandCategory
	public CommandCategory getCommandCategory();
	public void setCommandCategory(CommandCategory commandCategory);
	//Is Console Allowed to Use It?
	public boolean getIsConsoleSafe();
	public void setIsConsoleSafe(boolean isConsoleSafe);
	//The Command Handler!!!
	public CommandHandler getCommandHandler();
	public void setCommandHandler(CommandHandler command);
	//Help
	@NotNull
	public String getHelp();
	public void setHelp(String help);
	//Is it Hidden?
	public boolean getIsHidden();
	public void setIsHidden();
}
