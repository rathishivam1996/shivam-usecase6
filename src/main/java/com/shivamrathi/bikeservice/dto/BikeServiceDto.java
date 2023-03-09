package com.shivamrathi.bikeservice.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.AccessLevel;

@Validated
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class BikeServiceDto {

	@Min(value = 0L, message = "Id can not be negative")
	private Long id;

	@Min(value = 0L, message = "Cost can not be negative")
	private double cost;

	@Pattern(regexp = "^[0-9a-zA-Z-/_\\s,]*[a-z]{3}[0-9a-zA-Z-/_\\s,]*$", message = "Invalid address format.")
	@NotBlank
	private String address;

	@Pattern(regexp = "^[0-9]{10}$", message = "Phone number should be of 10 digits")
	@NotBlank
	private String phoneNumber;

	@NotNull(message = "Given Date can not be null")
	private LocalDate givenDate;

	@NotNull(message = "Expected Delivery Date can not be null")
	private LocalDate expectedDeliveryDate;

	@NotNull(message = "Created Date can not be null")
	private LocalDate createdDate;

	@NotNull(message = "Updated Date can not be null")
	private LocalDate updatedDate;

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
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu")
			.withResolverStyle(ResolverStyle.STRICT);

	public void setGivenDate(String givenDate) {
		this.givenDate = LocalDate.parse(givenDate, formatter);
	}

	public void setExpectedDeliveryDate(String expectedDeliveryDate) {
		this.expectedDeliveryDate = LocalDate.parse(expectedDeliveryDate, formatter);
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = LocalDate.parse(createdDate, formatter);
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = LocalDate.parse(updatedDate, formatter);
	}
}
