package com.shivamrathi.bikeservice.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "bikeserviceentity")
@Table(name = "bikeserviceentity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BikeServiceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "address", nullable = false, unique = false)
	private String address;

	@Column(name = "phone_number", nullable = false, unique = true)
	@NotBlank
	private String phoneNumber;

	@Column(name = "given_date", nullable = false, unique = false)
	@NotNull
	private LocalDate givenDate;

	@Column(name = "expected_delivery_date", nullable = false, unique = false)
	@NotNull
	private LocalDate expectedDeliveryDate;

	@Column(name = "created_date", nullable = false, unique = false)
	@NotNull
	private LocalDateTime createdDate;

	@Column(name = "updated_date", nullable = false, unique = false)
	@NotNull
	private LocalDateTime updatedDate;

	@Column(name = "bike_make", nullable = false, unique = false)
	@NotBlank
	private String bikeMake;

	@Column(name = "model_name", nullable = false, unique = false)
	@NotBlank
	private String modelName;

	@Column(name = "bike_registration_number", nullable = false, unique = true)
	@NotBlank
	private String bikeRegistrationNumber;

	@Column(name = "bike_chassis_number", nullable = false, unique = true)
	@NotBlank
	private String bikeChassisNumber;

	@Column(name = "known_issues", nullable = true, unique = false)
	@Nullable
	private String knownIssues;

	@Column(name = "cost", nullable = true, unique = false)
	@Nullable
	private double cost;
}
