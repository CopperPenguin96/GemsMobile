package com.AandC.GemsCraft.Exceptions;

public class Checks
{
	public static boolean isNull(Object o) {
		if (o.equals(null)) {
			return true;
		} else {
			return false;
		}
	}
}
