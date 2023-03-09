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
import com.shivamrathi.bikeservice.dto.BikeServiceMapper;
import com.shivamrathi.bikeservice.model.BikeServiceEntity;
import com.shivamrathi.bikeservice.service.BikeService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.extern.slf4j.Slf4j;

@RestController
@Validated
@Slf4j
public class BikeServiceController implements IBikeServiceController {
	@Autowired
	private BikeService bikeService;
	@Autowired
	private BikeServiceMapper mapper;

	@Override
	public ResponseEntity<?> createBikeServiceEntity(BikeServiceDto bikeServiceDto) {

		log.debug("/create ->>>");

		log.debug("saving entity");
		BikeServiceEntity savedEntity = bikeService
				.saveBikeServiceEntity(mapper.bikeServiceDtoToBikeServiceEntity(bikeServiceDto));

		log.debug("saved entity");
		System.out.println(savedEntity);

		if (savedEntity != null) {
			return new ResponseEntity<BikeServiceEntity>(savedEntity, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<BikeServiceEntity> readBikeService(Long id) {

		log.debug("/read/{id} ->>>");

		log.debug("Finding entity");
		BikeServiceEntity bikeServiceEntity = bikeService.findById(id);

		log.debug("Found entity");
		System.out.println(bikeServiceEntity);

		return new ResponseEntity<BikeServiceEntity>(bikeServiceEntity, HttpStatus.OK);
	}

	public ResponseEntity<BikeServiceEntity> readByBikeServiceByPhoneNumber(String phoneNumber) {

		log.debug("/read?phoneNumber=" + phoneNumber + " ->>>");
		BikeServiceEntity bikeServiceEntity = bikeService.findByPhoneNumber(phoneNumber);

		log.debug("Found entity");
		System.out.println(bikeServiceEntity);

		return new ResponseEntity<BikeServiceEntity>(bikeServiceEntity, HttpStatus.OK);
	}

	public ResponseEntity<BikeServiceEntity> readByBikeServiceByChassisNumber(String bikeChassisNumber) {

		log.debug("/read?bikeChassisNumber=" + bikeChassisNumber + " ->>>");
		BikeServiceEntity bikeServiceEntity = bikeService.findByBikeChassisNumber(bikeChassisNumber);

		log.debug("Found entity");
		System.out.println(bikeServiceEntity);

		return new ResponseEntity<BikeServiceEntity>(bikeServiceEntity, HttpStatus.OK);
	}

	public ResponseEntity<BikeServiceEntity> readByBikeRegistrationNumber(String bikeRegistrationNumber) {

		log.debug("/read?bikeRegistrationNumber=" + bikeRegistrationNumber + " ->>>");
		BikeServiceEntity bikeServiceEntity = bikeService.findByBikeRegistrationNumber(bikeRegistrationNumber);

		log.debug("Found entity");
		System.out.println(bikeServiceEntity);

		return new ResponseEntity<BikeServiceEntity>(bikeServiceEntity, HttpStatus.OK);
	}

	public ResponseEntity<List<BikeServiceEntity>> readByBikeMake(String bikeMake) {

		log.debug("/read?bikeMake=" + bikeMake + " ->>>");
		List<BikeServiceEntity> bikeServiceEntityList = bikeService.findByBikeMake(bikeMake);

		log.debug("Found entity List");
		System.out.println(bikeServiceEntityList);

		return new ResponseEntity<List<BikeServiceEntity>>(bikeServiceEntityList, HttpStatus.OK);
	}

	public ResponseEntity<List<BikeServiceEntity>> readByModelName(String modelName) {

		log.debug("/read?modelName=" + modelName + " ->>>");
		List<BikeServiceEntity> bikeServiceEntityList = bikeService.findByModelName(modelName);

		log.debug("Found entity List");
		System.out.println(bikeServiceEntityList);

		return new ResponseEntity<List<BikeServiceEntity>>(bikeServiceEntityList, HttpStatus.OK);
	}

	public ResponseEntity<BikeServiceEntity> updateBikeServiceEntity(Long id, BikeServiceDto bikeServiceDto) {

		log.debug("/update/{id} ->>>");
		BikeServiceEntity bikeServiceEntity = bikeService.updateBikeServiceEntity(id,
				mapper.bikeServiceDtoToBikeServiceEntity(bikeServiceDto));

		log.debug("Updated entity");
		System.out.println(bikeServiceEntity);

		return new ResponseEntity<BikeServiceEntity>(bikeServiceEntity, HttpStatus.CREATED);
	}

	public ResponseEntity<String> deleteBikeServiceEntity(Long id) {

		log.debug("/delete/{id} ->>>");
		bikeService.deleteBikeServiceEntity(id);

		log.debug("Deleted entity");

		return new ResponseEntity<String>("Deleted", HttpStatus.ACCEPTED);
	}
}
