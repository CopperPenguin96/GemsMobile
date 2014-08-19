package com.AandC.GemsCraft.Exceptions;

public class PlayerNotFoundException extends Exception
{
	public PlayerNotFoundException() { super(); }
	public PlayerNotFoundException(String message) { super(message); }
	public PlayerNotFoundException(String message, Throwable cause) { super(message, cause); }
	public PlayerNotFoundException(Throwable cause) { super(cause); }
}
