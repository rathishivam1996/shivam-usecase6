package com.shivamrathi.bikeservice.dto;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.format.DateTimeParseException;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DateValidationTest {

	BikeServiceMapper mapper = Mappers.getMapper(BikeServiceMapper.class);

	@Test
	public void invalidDateShouldThrowDateTimeParseException() {
		String strDate = "1996-02-31";
		BikeServiceDto dto = new BikeServiceDto();
		DateTimeParseException thrown = assertThrows(DateTimeParseException.class, () -> dto.setGivenDate(strDate),
				"Expected doThing() to throw, but it didn't");
//		assertTrue(
//				thrown.getMessage().contentEquals("Text '31/02/1996' could not be parsed: Invalid date 'FEBRUARY 31'"));
	}

	@Test
	public void invalidFormatShouldThrowDateTimeParseException() {
		String strDate = "96/02/01";
		BikeServiceDto dto = new BikeServiceDto();
		DateTimeParseException thrown = assertThrows(DateTimeParseException.class, () -> dto.setGivenDate(strDate),
				"Expected doThing() to throw, but it didn't");
//		assertTrue(thrown.getMessage().contentEquals("Text '01/02/96' could not be parsed at index 6"));
	}

	@Test
	public void invalidFormatShouldThrowDateTimeParseException1() {
		String strDate = "96-02-01";
		BikeServiceDto dto = new BikeServiceDto();
		DateTimeParseException thrown = assertThrows(DateTimeParseException.class, () -> dto.setGivenDate(strDate),
				"Expected doThing() to throw, but it didn't");
//		assertTrue(thrown.getMessage().contentEquals("Text '01-02-96' could not be parsed at index 2"));
	}

}
