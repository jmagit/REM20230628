package com.example.exceptions;

public class GraficosException extends Exception {
	private static final long serialVersionUID = 1L;

	public GraficosException(String message) {
		super(message);
	}

	public GraficosException(String message, Throwable cause) {
		super(message, cause);
	}

	public GraficosException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
