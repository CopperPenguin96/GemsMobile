package com.AandC.GemsCraft.Constants;
import android.graphics.*;

public class ConsoleColor extends Color
{
	public String toHex(int Red, int Green, int Blue) {
		return String.format("#%02x%02x%02x", Red, Green, Blue);
	}
}
