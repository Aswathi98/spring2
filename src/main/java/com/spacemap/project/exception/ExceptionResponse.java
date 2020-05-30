package com.spacemap.project.exception;

public class ExceptionResponse {
	public ExceptionResponse(String errorMessage, String requestedURI) {
		//super();
		this.errorMessage = errorMessage;
		this.requestedURI = requestedURI;
	}

	public ExceptionResponse() {
		//super();
	}

	private String errorMessage;
	private String requestedURI;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getRequestedURI() {
		return requestedURI;
	}

	public void callerURL(final String requestedURI) {
		this.requestedURI = requestedURI;
	}

	@Override
	public String toString() {
		return "ExceptionResponse [errorMessage=" + errorMessage + ", requestedURI=" + requestedURI + "]";
	}
}
