package com.AandC.GemsCraft;
import android.widget.*;
import android.text.*;

public class Console
{
	public static TextView consoleBox;
	public static void writeToConsole(Log log) {
		consoleBox.setText(Html.fromHtml(log.myMessage));
	}
}
