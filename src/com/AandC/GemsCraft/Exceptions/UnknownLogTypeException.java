package com.AandC.GemsCraft.Exceptions;

public class UnknownLogTypeException extends Exception
{
	public UnknownLogTypeException() { 
		super(); 
	}
	public UnknownLogTypeException(String message) { 
		super(message); 
	}
	public UnknownLogTypeException(String message, Throwable cause) { 
		super(message, cause); 
	}
	public UnknownLogTypeException(Throwable cause) { 
		super(cause); 
	}
}
