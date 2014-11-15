package com.AandC.GemsCraft.System;
import java.io.*;

public class Files
{
	public static String mainPath = "/sdcard/GemsCraft/";
	public static File[] appFiles = new File[] {
		new File(mainPath + "config.xml"),
		new File(mainPath + "externalurl.txt")
	};
	public static void createNeccessary() {
		if (!new File(mainPath).exists()) new File(mainPath).mkdirs();
		for (File f:appFiles) {
			if (!f.exists())
			{
				try
				{
					f.createNewFile();
				}
				catch (IOException e)
				{}
			}
		}
	}
}
