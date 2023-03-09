package com.shivamrathi.bikeservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shivamrathi.bikeservice.dto.BikeServiceDto;
import com.shivamrathi.bikeservice.model.BikeServiceEntity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@RestController
public interface IBikeServiceController {
	@PostMapping(value = "/create")
	public ResponseEntity<?> createBikeServiceEntity(@Valid @RequestBody BikeServiceDto bikeServiceDto);

	@GetMapping(value = "/read/{id}")
	@ResponseBody
	public ResponseEntity<BikeServiceEntity> readBikeService(
			@PathVariable("id") @Min(value = 0L, message = "Id can not be negative") Long id);

	@GetMapping(value = "/read", params = "phoneNumber")
	@ResponseBody
	public ResponseEntity<BikeServiceEntity> readByBikeServiceByPhoneNumber(
			@RequestParam(value = "phoneNumber") @Pattern(regexp = "^[0-9]{10}$", message = "Phone number should be of 10 digits") String phoneNumber);

	@GetMapping(value = "/read", params = "bikeChassisNumber")
	@ResponseBody
	public ResponseEntity<BikeServiceEntity> readByBikeServiceByChassisNumber(
			@RequestParam("bikeChassisNumber") @NotBlank(message = "Bike ChassisNumber cant not be blank") String bikeChassisNumber);

	@GetMapping(value = "/read", params = "bikeRegistrationNumber")
	@ResponseBody
	public ResponseEntity<BikeServiceEntity> readByBikeRegistrationNumber(
			@RequestParam("bikeRegistrationNumber") @NotBlank(message = "Bike Registeration Number cant not be blank") String bikeRegistrationNumber);

	@GetMapping(value = "/read", params = "bikeMake")
	@ResponseBody
	public ResponseEntity<List<BikeServiceEntity>> readByBikeMake(
			@RequestParam("bikeMake") @NotBlank(message = "Bike Make can not be blank") String bikeMake);

	@GetMapping(value = "/read", params = "modelName")
	@ResponseBody
	public ResponseEntity<List<BikeServiceEntity>> readByModelName(
			@RequestParam("modelName") @NotBlank(message = "Model Name can not be blank") String modelName);

	@PutMapping(value = "/update/{id}")
	@ResponseBody
	public ResponseEntity<BikeServiceEntity> updateBikeServiceEntity(
			@PathVariable("id") @Min(value = 0L, message = "Id can not be negative") Long id,
			@Valid @RequestBody BikeServiceDto bikeServiceDto);

	@DeleteMapping(value = "/delete/{id}")
	@ResponseBody
	public ResponseEntity<String> deleteBikeServiceEntity(
			@PathVariable("id") @Min(value = 0L, message = "Id can not be negative") Long id);
}
