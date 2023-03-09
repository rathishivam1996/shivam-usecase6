package com.shivamrathi.bikeservice.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateValidator implements ConstraintValidator<ValidateDate, String> {

	@Override
	public boolean isValid(String inputDate, ConstraintValidatorContext context) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		try {
			LocalDate.parse(inputDate, formatter);
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}
}
