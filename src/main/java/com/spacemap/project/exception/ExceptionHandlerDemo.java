package com.spacemap.project.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerDemo {

	@ExceptionHandler(RecordNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ResponseEntity<ExceptionResponse> handleRecordNotFound(final RecordNotFoundException exception,
			final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse("FAiled",request.getRequestURI());
	error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());
		error.toString();
		return ResponseEntity.badRequest().body(error);
	}

	@ExceptionHandler(AccessDeniedException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ResponseEntity<ExceptionResponse> handleAccessDenied(final AccessDeniedException exception,
			final HttpServletRequest request) {
		ExceptionResponse error = new ExceptionResponse("FAiled",request.getRequestURI());
		error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());
		//return ResponseEntity.badRequest().body(error);
		return ResponseEntity.badRequest().body(error);
	}
	
	

	/*@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ResponseEntity<ExceptionResponse> handleException(final Exception exception,
			final HttpServletRequest request) {
		
		ExceptionResponse error = new ExceptionResponse("FAiled",request.getRequestURI());
		//ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());

		return ResponseEntity.badRequest().body(error);
	}*/
}
