package com.shivamrathi.bikeservice.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ResponseDto {

	@Min(value = 0L, message = "Id can not be negative")
	private Long id;

	@Min(value = 0L, message = "Cost can not be negative")
	private double cost;

	@Pattern(regexp = "^[0-9a-zA-Z-/_\\s,]*[a-zA-Z]{3}[0-9a-zA-Z-/_\\s,]*$", message = "Invalid address format.")
	@NotBlank
	private String address;

	@Pattern(regexp = "^[0-9]{10}$", message = "Phone number should be of 10 digits")
	@NotBlank
	private String phoneNumber;

	@NotNull(message = "Given Date can not be null")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate givenDate;

	@NotNull(message = "Expected Delivery Date can not be null")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate expectedDeliveryDate;

//	@NotNull(message = "Created Date can not be null")
	@JsonFormat(pattern = "yyyy-MM-dd-HH-mm-ss")
	private LocalDateTime createdDate;

//	@NotNull(message = "Updated Date can not be null")
	@JsonFormat(pattern = "yyyy-MM-dd-HH-mm-ss")
	private LocalDateTime updatedDate;

	@NotBlank(message = "Bike Make can not be blank")
	private String bikeMake;

	@NotBlank(message = "Model Name can not be blank")
	private String modelName;

	@NotBlank(message = "Bike Registeration Number can not be blank")
	private String bikeRegistrationNumber;

	@NotBlank(message = "Bike Chassis Number can not be blank")
	private String bikeChassisNumber;

	private String knownIssues;

	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	private final DateTimeFormatter localDateFormatter = DateTimeFormatter.ofPattern("uuuu-MM-dd")
			.withResolverStyle(ResolverStyle.STRICT);

	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	private final DateTimeFormatter localDateTimeFormatter = DateTimeFormatter.ofPattern("uuuu-MM-dd-HH-mm-ss")
			.withResolverStyle(ResolverStyle.STRICT);

	public void setGivenDate(String givenDate) {
		this.givenDate = LocalDate.parse(givenDate, localDateFormatter);
	}

	public void setExpectedDeliveryDate(String expectedDeliveryDate) {
		this.expectedDeliveryDate = LocalDate.parse(expectedDeliveryDate, localDateFormatter);
	}
}