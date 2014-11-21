package com.AandC.GemsCraft.Exceptions;
import com.AandC.GemsCraft.Console.*;

public class Logs
{
	public Logs(Exception e) {
		String x = "Error! ";
		for (StackTraceElement s:e.getStackTrace()) {
			x += s.toString() + "\n";
		}
		try
		{
			Log log = new Log(x);
			log.Send();
		}
		catch (InvalidLogException ex) {
			new Logs(ex);
		}
	}
}
