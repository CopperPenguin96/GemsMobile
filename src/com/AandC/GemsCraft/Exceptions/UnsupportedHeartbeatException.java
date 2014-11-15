package com.AandC.GemsCraft.Exceptions;

public class UnsupportedHeartbeatException extends Exception {
	public UnsupportedHeartbeatException() {
		super();
	}
	public UnsupportedHeartbeatException(String message) {
		super(message);
	}
	public UnsupportedHeartbeatException(String message, Throwable cause) {
		super(message,cause);
	}
	public UnsupportedHeartbeatException(Throwable cause) {
		super(cause);
	}
}
