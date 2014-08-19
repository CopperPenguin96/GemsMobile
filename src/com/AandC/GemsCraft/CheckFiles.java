package com.AandC.GemsCraft;

import java.io.*;

public class CheckFiles
{
	public static boolean check(File file) {
		if (!file.exists()) return false;
		else if (file == null) return false;
		else if (!file.canRead()) return false;
		else if (!file.canWrite()) return false;
		else return true;
	}
}
