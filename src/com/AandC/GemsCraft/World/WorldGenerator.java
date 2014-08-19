package com.AandC.GemsCraft.World;
import com.AandC.GemsCraft.PlayerDB.*;
import java.io.File;
import com.AandC.GemsCraft.*;
import com.AandC.GemsCraft.Exceptions.*;

public final class WorldGenerator
{
	static String supFile = "/sdcard/GemsCraft/Worlds/";
	public static File worldDirectory = new File(supFile);
	static String fileExt = ".gcWorld";
	public static void createWorld(Player player, String worldName) {
		if (player.equals(null) || worldName.equals(null)) {
			throw new NullPointerException();
		} else {
			if (!worldDirectory.exists()) {
				worldDirectory.mkdirs();
			} else {
				File worldFile = new File(supFile + worldName + 
					fileExt);
				if (worldFile.exists()) {
					try
					{
						Log writerLog = new Log(player.name + 
												" to create a world that already exists!", "Warning", true);
						Console.writeToConsole(writerLog);
					} catch (UnknownLogTypeException e) {
						
					}
				}
			}
		}
	}
}
