package com.shivamrathi.bikeservice.exceptionhandling;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.shivamrathi.bikeservice.errorhandling.ErrorMessage;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalControllerAdvice {

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ResponseEntity<ErrorMessage> integrityConstraintViolationException(
			SQLIntegrityConstraintViolationException ex) {

		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.CONFLICT, new Date(), "Duplicate Record.",
				"Data entered is already in use.");

		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<ErrorMessage> noSuchElementException(NoSuchElementException ex) {

		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, new Date(), "Record not found",
				"Data does not exist for the given entry.");

		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DateTimeParseException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorMessage> invalidDateException(DateTimeParseException ex) {

		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST, new Date(), "Invalid Date",
				"Please enter a valid date in the format dd/mm/yyyy");

		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorMessage> validationBindException(MethodArgumentNotValidException exception,
			HttpServletRequest request) {

		String bindException = exception.getBindingResult().getFieldErrors().stream().reduce("Invalid ",
				(x, fieldError) -> x + fieldError.getRejectedValue() + " value submitted for " + fieldError.getField()
						+ ", ",
				(a, b) -> a + b);

		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST, new Date(), "Data could not be validated.",
				bindException);

		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Set<String>> constraintViolationException(ConstraintViolationException exception,
			HttpServletRequest request) {

		Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();

		Set<String> messages = new HashSet<>(constraintViolations.size());
		messages.addAll(constraintViolations.stream()
				.map(constraintViolation -> String.format("%s value '%s' %s", constraintViolation.getPropertyPath(),
						constraintViolation.getInvalidValue(), constraintViolation.getMessage()))
				.collect(Collectors.toList()));

//		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST, new Date(),
//				"Constraint could not be validated", messages);

		return new ResponseEntity<>(messages, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorMessage> httpMessageParseException(HttpMessageNotReadableException exception,
			HttpServletRequest request) {

		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST, new Date(), "Data could not be parsed.",
				exception.getMessage());

		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
	}
}
