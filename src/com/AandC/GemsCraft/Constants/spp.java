package com.AandC.GemsCraft.Constants;
import android.widget.*;
import com.AandC.GemsCraft.*;
import android.graphics.*;
import com.AandC.GemsCraft.Network.*;
import java.io.*;

public class spp
{
	public static EditText[] userTexts = new EditText[2];
	public static String[] consoleLines = new String[1999];
	public static Color[] consoleColors = new Color[1999];
	public static int currentLines = 0;
	public static void writeLog(Log log) {
		consoleLines[currentLines] = log.myMessage;
	}
	public static String app_ver = null;
	public static boolean isCurrentVersion() {
		try
		{
			if (TitleExtractor.getPageTitle("http://gemscon.freeiz.com/index.html").equals(app_ver))
			{
				return true;
			} else {
				return false;
			}
		} catch (IOException e) {
			return false;
		}
	}
}
