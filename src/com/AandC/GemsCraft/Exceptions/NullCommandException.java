package com.AandC.GemsCraft.Exceptions;

public class NullCommandException extends Exception
{
	public NullCommandException() { super(); }
	public NullCommandException(String message) { super(message); }
	public NullCommandException(String message, Throwable cause) { super(message, cause); }
	public NullCommandException(Throwable cause) { super(cause); }
}
