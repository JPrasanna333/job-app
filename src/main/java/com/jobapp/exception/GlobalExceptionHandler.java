package com.jobapp.exception;

import java.time.LocalDateTime;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jobapp.model.ApiErrors;

/**
 * @author PrasannaJ
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	// Giving wrong http method name gives this exception
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "Method not allowed";
		ApiErrors apiError = new ApiErrors(timestamp, message, status.value(), error);
		return ResponseEntity.status(status.value()).body(apiError);
	}

	/*
	 * sending text data instead of sending json data to the http post() gives this
	 * exception
	 */
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "Invalid Media Type";
		ApiErrors apiError = new ApiErrors(timestamp, message, status.value(), error);
		return ResponseEntity.status(status).body(apiError);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "Missing Path Variables";
		ApiErrors apiError = new ApiErrors(timestamp, message, status.value(), error);
		return ResponseEntity.status(status).body(apiError);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "Type Mismatch";
		ApiErrors apiError = new ApiErrors(timestamp, message, status.value(), error);
		return ResponseEntity.status(status).body(apiError);
	}

	@ExceptionHandler(CompanyNotFoundException.class)
	protected ResponseEntity<Object> handleCompanyNotFoundException(CompanyNotFoundException ex) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "Company was not found";
		ApiErrors apiError = new ApiErrors(timestamp, message, HttpStatus.BAD_REQUEST.value(), error);
		return ResponseEntity.badRequest().body(apiError);
	}

	@ExceptionHandler(DescriptionNotFoundException.class)
	protected ResponseEntity<Object> handleDescriptionNotFoundException(DescriptionNotFoundException ex) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "Description was not found";
		ApiErrors apiError = new ApiErrors(timestamp, message, HttpStatus.BAD_REQUEST.value(), error);
		return ResponseEntity.badRequest().body(apiError);
	}

	@ExceptionHandler(JobNotFoundException.class)
	protected ResponseEntity<Object> handleJobNotFoundException(JobNotFoundException ex) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "Job was not found";
		ApiErrors apiError = new ApiErrors(timestamp, message, HttpStatus.BAD_REQUEST.value(), error);
		return ResponseEntity.badRequest().body(apiError);
	}

	@ExceptionHandler(SkillNotFoundException.class)
	protected ResponseEntity<Object> handleSkillNotFoundException(SkillNotFoundException ex) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "Skill was not found";
		ApiErrors apiError = new ApiErrors(timestamp, message, HttpStatus.BAD_REQUEST.value(), error);
		return ResponseEntity.badRequest().body(apiError);
	}

	@ExceptionHandler(RuntimeException.class)
	protected ResponseEntity<Object> handleException(RuntimeException ex) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "Other Exception";
		ApiErrors apiError = new ApiErrors(timestamp, message, HttpStatus.BAD_GATEWAY.value(), error);
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(apiError);
	}

}
