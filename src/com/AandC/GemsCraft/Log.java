package com.AandC.GemsCraft;
import android.graphics.*;
import com.AandC.GemsCraft.Exceptions.*;
import android.text.format.*;
import com.AandC.GemsCraft.Constants.*;

public class Log
{
	Time time = new Time();
	public String myMessage;
	public Color thisColor = new Color();
	String messageString() {
		time.setToNow();
		return "<" + time.hour + ":" + 
			time.minute + ":" + 
			time.second + ">";
	}
	public Log(String message) {
		String hex = getHex("Normal");
		myMessage = getHtml(message, hex, false);
	}
	public Log(String message, boolean isSerious) {
		String hex = getHex("Normal");
		myMessage = getHtml(message, hex, true);
	}
	public Log(String message, String logType) throws UnknownLogTypeException {
		if (isValidLog(logType)) {
			String hex = getHex(logType);
			myMessage = getHtml(message, hex, false);
		} else {
			throw new UnknownLogTypeException();
		}
	}
	public Log(String message, String logType, boolean isSerious) throws UnknownLogTypeException {
		if (isValidLog(logType)) {
			String hex = getHex(logType);
			myMessage = getHtml(message, hex, true);
		} else {
			throw new UnknownLogTypeException();
		}
	}
	boolean isValidLog(String logOf) {
		boolean isFound = false;
		for (String x:possibleLogs) {
			if (x.equals(logOf)) {
				isFound = true;
			}
		}
		return isFound;
	}
	String[] possibleLogs = new String[] {
		"Normal", "Attention", "SpecialChat", "Warning",
		"Serious", "CommandInput"
	};
	String getHex(String logType) {
		ConsoleColor cColor = new ConsoleColor();
		if (logType.equals("Normal")) {
			return cColor.toHex(ConsoleSet.colorWhite[0],ConsoleSet.colorWhite[1],
				ConsoleSet.colorWhite[2]);
		} else if (logType.equals("Attention")) {
			return cColor.toHex(ConsoleSet.colorYellow[0],ConsoleSet.colorYellow[1],
								ConsoleSet.colorYellow[2]);
		} else if (logType.equals("SpecialChat")) {
			return cColor.toHex(ConsoleSet.colorPurple[0],ConsoleSet.colorPurple[1],
								ConsoleSet.colorPurple[2]);
		} else if (logType.equals("Warning")) {
			return cColor.toHex(ConsoleSet.colorTomato[0],ConsoleSet.colorTomato[1],
								ConsoleSet.colorTomato[2]);
		} else if (logType.equals("Serious")) {
			return cColor.toHex(ConsoleSet.colorFirebrick[0],ConsoleSet.colorFirebrick[1],
								ConsoleSet.colorFirebrick[2]);
		} else if (logType.equals("CommandInput")) {
			return cColor.toHex(ConsoleSet.colorCyan[0],ConsoleSet.colorCyan[1],
								ConsoleSet.colorCyan[2]);
		}
		else return getHex(logType);
	}
	String getHtml(String message, String hexCode, Boolean isSerious) {
		Time time = new Time();
		time.setToNow();
		String myNew = "<" + String.valueOf(time.hour) + 
			String.valueOf(time.minute) + 
			String.valueOf(time.second) + "> " + message;
		if (message.equals(null) || hexCode.equals(null)) {
			getHtml(message,hexCode,isSerious);
		} else {
			if (isSerious) {
				myNew = "(WARNING)" + myNew;
			}
			return "<font color='" + hexCode + "'>" + myNew + "</font>";
		}
		return null;
	}
}
