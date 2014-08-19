package com.AandC.GemsCraft;

public class Int32
{
	public static boolean TryParse(String x, int y) {
		boolean didWork;
		try {
			Integer.parseInt(x, y );
		} catch (Exception ex) {
			didWork = false;
		} finally {
			didWork = true;
		}
		return didWork;
	}
}
