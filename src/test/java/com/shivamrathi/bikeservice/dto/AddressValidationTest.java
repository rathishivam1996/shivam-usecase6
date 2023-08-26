package com.shivamrathi.bikeservice.dto;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class AddressValidationTest {
	private static ValidatorFactory validatorFactory;
	private static Validator validator;

	private static BikeServiceDto bikeServiceDto;

	@BeforeAll
	public static void createValidator() {
		System.out.println("@BeforeAll ->>>");
		validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
		LocalDate date = LocalDate.parse("31/05/1996", formatter);
		bikeServiceDto = BikeServiceDto.builder().id((long) 1).phoneNumber("0123456789").givenDate(date)
				.expectedDeliveryDate(date).bikeChassisNumber("cha1").bikeRegistrationNumber("reg1").bikeMake("Honda")
				.modelName("R15").knownIssues("issues1").cost(1000).build();
	}

	@AfterAll
	public static void close() {
		System.out.println("@AfterAll ->>>");
		validatorFactory.close();
	}

	@Test
	public void addressLengthShouldPass() {
		log.info("@Test ->>>");
		bikeServiceDto.setAddress("goa");
		Set<ConstraintViolation<BikeServiceDto>> violations = validator.validate(bikeServiceDto);
		System.out.println("testing address with alpha");
		System.out.println(violations.toString());
		assertTrue(violations.isEmpty());
	}

	@Test
	public void addressContainsAlphaNumericShouldPass() {
		log.info("@Test ->>>");
		bikeServiceDto.setAddress("goa65");

		Set<ConstraintViolation<BikeServiceDto>> violations = validator.validate(bikeServiceDto);
		System.out.println("testing address with alpha-numeric");
		assertTrue(violations.isEmpty());
	}

	@Test
	public void addressContainsHyphenShouldPass() {
		log.info("@Test ->>>");
		bikeServiceDto.setAddress("goa-");

		Set<ConstraintViolation<BikeServiceDto>> violations = validator.validate(bikeServiceDto);
		System.out.println("testing address with hyphen");
		assertTrue(violations.isEmpty());
	}

	@Test
	public void addressContainsSlashShouldPass() {
		log.info("@Test ->>>");
		bikeServiceDto.setAddress("goa/");

		Set<ConstraintViolation<BikeServiceDto>> violations = validator.validate(bikeServiceDto);
		System.out.println("testing address with slash");
		assertTrue(violations.isEmpty());
	}

	@Test
	public void addressContainsSpaceShouldPass() {
		log.info("@Test ->>>");
		bikeServiceDto.setAddress("goa ");

		Set<ConstraintViolation<BikeServiceDto>> violations = validator.validate(bikeServiceDto);
		System.out.println("testing address with space");
		assertTrue(violations.isEmpty());
	}

	@Test
	public void addressContainsCommaShouldPass() {
		log.info("@Test ->>>");
		bikeServiceDto.setAddress("goa,");

		Set<ConstraintViolation<BikeServiceDto>> violations = validator.validate(bikeServiceDto);
		System.out.println("testing address with comma");
		assertTrue(violations.isEmpty());
	}

	@Test
	public void addressShouldPass() {
		log.info("@Test ->>>");
		bikeServiceDto.setAddress("Wz-65, Phase-2, Om Vihar, Uttam Nagar, New Delhi, Delhi - 110059");

		Set<ConstraintViolation<BikeServiceDto>> violations = validator.validate(bikeServiceDto);
		System.out.println("testing address");
		assertTrue(violations.isEmpty());
	}

	// negative test cases

	@Test
	public void addressLengthShouldFail() {
		log.info("@Test ->>>");
		bikeServiceDto.setAddress("a");

		Set<ConstraintViolation<BikeServiceDto>> violations = validator.validate(bikeServiceDto);
		System.out.println("testing address");
		assertFalse(violations.isEmpty());
	}

	@Test
	public void addressLessThenThreeAlphaShouldFail() {
		log.info("@Test ->>>");
		bikeServiceDto.setAddress("123a");

		Set<ConstraintViolation<BikeServiceDto>> violations = validator.validate(bikeServiceDto);
		System.out.println("testing address");
		assertFalse(violations.isEmpty());
	}

	@Test
	public void addressOnlyNumericShouldFail() {
		log.info("@Test ->>>");
		bikeServiceDto.setAddress("1234");

		Set<ConstraintViolation<BikeServiceDto>> violations = validator.validate(bikeServiceDto);
		System.out.println("testing address");
		assertFalse(violations.isEmpty());
	}

	@Test
	public void addressOnlySpecialCharsShouldFail() {
		log.info("@Test ->>>");
		bikeServiceDto.setAddress("-/ -/");

		Set<ConstraintViolation<BikeServiceDto>> violations = validator.validate(bikeServiceDto);
		System.out.println("testing address");
		assertFalse(violations.isEmpty());
	}

	@Test
	public void addressOnlySpacesShouldFail() {
		log.info("@Test ->>>");
		bikeServiceDto.setAddress("     ");

		Set<ConstraintViolation<BikeServiceDto>> violations = validator.validate(bikeServiceDto);
		System.out.println("testing address");
		assertFalse(violations.isEmpty());
	}

	@Test
	public void addressBlankShouldFail() {
		log.info("@Test ->>>");
		bikeServiceDto.setAddress(" ");

		Set<ConstraintViolation<BikeServiceDto>> violations = validator.validate(bikeServiceDto);
		System.out.println("testing address");
		assertFalse(violations.isEmpty());
	}

	@Test
	public void addressContainsSpecialCharsShouldFail() {
		log.info("@Test ->>>");
		bikeServiceDto.setAddress("Wz-65 @");

		Set<ConstraintViolation<BikeServiceDto>> violations = validator.validate(bikeServiceDto);
		System.out.println("testing address with special chars");
		assertFalse(violations.isEmpty());
	}

	@Test
	public void addressContainsSpecialCharsShouldFail1() {
		log.info("@Test ->>>");
		BikeServiceDto bikeServiceDto = new BikeServiceDto();
		bikeServiceDto.setAddress("Wz-65 #");

		Set<ConstraintViolation<BikeServiceDto>> violations = validator.validate(bikeServiceDto);
		System.out.println("testing address with special chars");
		assertFalse(violations.isEmpty());
	}

	@Test
	public void addressContainsSpecialCharsShouldFail2() {
		log.info("@Test ->>>");
		bikeServiceDto.setAddress("Wz-65 :");

		Set<ConstraintViolation<BikeServiceDto>> violations = validator.validate(bikeServiceDto);
		System.out.println("testing address with special chars");
		assertFalse(violations.isEmpty());
	}
}
