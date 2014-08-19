package com.AandC.GemsCraft.Exceptions;

public class ArgumentException extends Exception
{
	public ArgumentException() { super(); }
	public ArgumentException(String message) { super(message); }
	public ArgumentException(String message, Throwable cause) { super(message, cause); }
	public ArgumentException(Throwable cause) { super(cause); }
}
