package com.AandC.GemsCraft.PlayerDB;

import java.io.*;

public class Errors
{
	public static void saveCrashLog(Exception ex) {
		File file = new File("/sdcard/GemsCraft/Errors");
		if (!file.exists()) {
			file.mkdirs();
		}
		String crashReport = "GemsCraft has crashed with \"" + ex.toString() +
			"\n\n";
	}
}
