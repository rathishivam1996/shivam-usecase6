package com.shivamrathi.bikeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
import com.shivamrathi.bikeservice.service.BikeService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.extern.slf4j.Slf4j;

@RestController
@Validated
@Slf4j
public class BikeServiceController {
	@Autowired
	private BikeService bikeService;

	@PostMapping(value = "/create")
	public ResponseEntity<?> createBikeServiceEntity(@Valid @RequestBody BikeServiceDto bikeServiceDto) {

		log.debug("/create ->>>");

		log.debug("saving entity");
		BikeServiceDto savedDto = bikeService.saveBikeServiceEntity(bikeServiceDto);

		log.debug("saved entity");
		System.out.println(savedDto);

		if (savedDto != null) {
			return new ResponseEntity<BikeServiceDto>(savedDto, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/read/{id}")
	@ResponseBody
	public ResponseEntity<BikeServiceDto> readBikeService(
			@PathVariable("id") @Min(value = 0L, message = "Id can not be negative") Long id) {

		log.debug("/read/{id} ->>>");

		log.debug("Finding entity");
		BikeServiceDto bikeServiceEntity = bikeService.findById(id);

		log.debug("Found entity");
		System.out.println(bikeServiceEntity);

		return new ResponseEntity<BikeServiceDto>(bikeServiceEntity, HttpStatus.OK);
	}

	@GetMapping(value = "/read", params = "phoneNumber")
	@ResponseBody
	public ResponseEntity<BikeServiceDto> readByBikeServiceByPhoneNumber(
			@RequestParam(value = "phoneNumber") @Pattern(regexp = "^[0-9]{10}$", message = "Phone number should be of 10 digits") String phoneNumber) {

		log.debug("/read?phoneNumber=" + phoneNumber + " ->>>");
		BikeServiceDto bikeServiceEntity = bikeService.findByPhoneNumber(phoneNumber);

		log.debug("Found entity");
		System.out.println(bikeServiceEntity);

		return new ResponseEntity<BikeServiceDto>(bikeServiceEntity, HttpStatus.OK);
	}

	@GetMapping(value = "/read", params = "bikeChassisNumber")
	@ResponseBody
	public ResponseEntity<BikeServiceDto> readByBikeServiceByChassisNumber(
			@RequestParam("bikeChassisNumber") @NotBlank(message = "Bike ChassisNumber cant not be blank") String bikeChassisNumber) {

		log.debug("/read?bikeChassisNumber=" + bikeChassisNumber + " ->>>");
		BikeServiceDto bikeServiceEntity = bikeService.findByBikeChassisNumber(bikeChassisNumber);

		log.debug("Found entity");
		System.out.println(bikeServiceEntity);

		return new ResponseEntity<BikeServiceDto>(bikeServiceEntity, HttpStatus.OK);
	}

	@GetMapping(value = "/read", params = "bikeRegistrationNumber")
	@ResponseBody
	public ResponseEntity<BikeServiceDto> readByBikeRegistrationNumber(
			@RequestParam("bikeRegistrationNumber") @NotBlank(message = "Bike Registeration Number cant not be blank") String bikeRegistrationNumber) {

		log.debug("/read?bikeRegistrationNumber=" + bikeRegistrationNumber + " ->>>");
		BikeServiceDto bikeServiceDto = bikeService.findByBikeRegistrationNumber(bikeRegistrationNumber);

		log.debug("Found entity");
		System.out.println(bikeServiceDto);

		return new ResponseEntity<BikeServiceDto>(bikeServiceDto, HttpStatus.OK);
	}

	@GetMapping(value = "/read", params = "bikeMake")
	@ResponseBody
	public ResponseEntity<List<BikeServiceDto>> readByBikeMake(
			@RequestParam("bikeMake") @NotBlank(message = "Bike Make can not be blank") String bikeMake) {

		log.debug("/read?bikeMake=" + bikeMake + " ->>>");
		List<BikeServiceDto> bikeServiceDtoList = bikeService.findByBikeMake(bikeMake);

		log.debug("Found entity List");
		System.out.println(bikeServiceDtoList);

		return new ResponseEntity<List<BikeServiceDto>>(bikeServiceDtoList, HttpStatus.OK);
	}

	@GetMapping(value = "/read", params = "modelName")
	@ResponseBody
	public ResponseEntity<List<BikeServiceDto>> readByModelName(
			@RequestParam("modelName") @NotBlank(message = "Model Name can not be blank") String modelName) {

		log.debug("/read?modelName=" + modelName + " ->>>");
		List<BikeServiceDto> bikeServiceDtoList = bikeService.findByModelName(modelName);

		log.debug("Found entity List");
		System.out.println(bikeServiceDtoList);

		return new ResponseEntity<List<BikeServiceDto>>(bikeServiceDtoList, HttpStatus.OK);
	}

	@PutMapping(value = "/update/{id}")
	@ResponseBody
	public ResponseEntity<BikeServiceDto> updateBikeServiceEntity(
			@PathVariable("id") @Min(value = 0L, message = "Id can not be negative") Long id,
			@Valid @RequestBody BikeServiceDto bikeServiceDto) {

		log.debug("/update/{id} ->>>");
		System.out.println("bikeServiceDto ->>>" + bikeServiceDto);
		BikeServiceDto updatedEntity = bikeService.updateBikeServiceEntity(id, bikeServiceDto);

		log.debug("Updated entity");
		System.out.println(updatedEntity);

		return new ResponseEntity<BikeServiceDto>(updatedEntity, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/delete/{id}")
	@ResponseBody
	public ResponseEntity<String> deleteBikeServiceEntity(
			@PathVariable("id") @Min(value = 0L, message = "Id can not be negative") Long id) {

		log.debug("/delete/{id} ->>>");
		bikeService.deleteBikeServiceEntity(id);

		log.debug("Deleted entity");

		return new ResponseEntity<String>("Deleted", HttpStatus.ACCEPTED);
	}
}
