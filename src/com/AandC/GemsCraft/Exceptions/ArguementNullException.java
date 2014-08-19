package com.AandC.GemsCraft.Exceptions;

public class ArguementNullException extends Exception
{
	public ArguementNullException() { super(); }
	public ArguementNullException(String message) { super(message); }
	public ArguementNullException(String message, Throwable cause) { super(message, cause); }
	public ArguementNullException(Throwable cause) { super(cause); }
}
