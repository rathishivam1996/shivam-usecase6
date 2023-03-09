package com.shivamrathi.bikeservice.dto;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.format.DateTimeParseException;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

import com.shivamrathi.bikeservice.dto.BikeServiceDto;
import com.shivamrathi.bikeservice.dto.BikeServiceMapper;

@SpringBootTest
public class DateValidationTest {

	BikeServiceMapper mapper = Mappers.getMapper(BikeServiceMapper.class);

	@Test
	public void invalidDateShouldThrowDateTimeParseException() {
		String strDate = "31/02/1996";
		BikeServiceDto dto = new BikeServiceDto();
		DateTimeParseException thrown = assertThrows(DateTimeParseException.class, () -> dto.setCreatedDate(strDate),
				"Expected doThing() to throw, but it didn't");
		assertTrue(
				thrown.getMessage().contentEquals("Text '31/02/1996' could not be parsed: Invalid date 'FEBRUARY 31'"));
	}

	@Test
	public void invalidFormatShouldThrowDateTimeParseException() {
		String strDate = "01/02/96";
		BikeServiceDto dto = new BikeServiceDto();
		DateTimeParseException thrown = assertThrows(DateTimeParseException.class, () -> dto.setCreatedDate(strDate),
				"Expected doThing() to throw, but it didn't");
		System.out.println(thrown.getMessage());
		assertTrue(thrown.getMessage().contentEquals("Text '01/02/96' could not be parsed at index 6"));
	}

	@Test
	public void invalidFormatShouldThrowDateTimeParseException1() {
		String strDate = "01-02-96";
		BikeServiceDto dto = new BikeServiceDto();
		DateTimeParseException thrown = assertThrows(DateTimeParseException.class, () -> dto.setCreatedDate(strDate),
				"Expected doThing() to throw, but it didn't");
		System.out.println(thrown.getMessage());
		System.out.println(thrown.getCause());
		System.out.println(thrown);
		assertTrue(thrown.getMessage().contentEquals("Text '01-02-96' could not be parsed at index 2"));
	}

}
