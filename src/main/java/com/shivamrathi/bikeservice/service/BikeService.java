package com.shivamrathi.bikeservice.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivamrathi.bikeservice.dto.BikeServiceDto;
import com.shivamrathi.bikeservice.dto.BikeServiceMapper;
import com.shivamrathi.bikeservice.repository.BikeServiceRepository;

@Service
public class BikeService implements IBikeService {

	@Autowired
	BikeServiceRepository repository;

	@Autowired
	BikeServiceMapper mapper;

	@Override
	public BikeServiceDto saveBikeServiceEntity(BikeServiceDto bikeServiceDto) {
		bikeServiceDto.setCreatedDate(LocalDateTime.now());
		bikeServiceDto.setUpdatedDate(LocalDateTime.now());
		return mapper.entityToDto(repository.save(mapper.dtoToEntity(bikeServiceDto)));
	}

	@Override
	public BikeServiceDto findById(Long id) {
		return mapper.entityToDto(repository.findById(id).get());
	}

	@Override
	public BikeServiceDto findByPhoneNumber(String phoneNumber) {
		return mapper.entityToDto(repository.findByPhoneNumber(phoneNumber).get());
	}

	@Override
	public BikeServiceDto findByBikeChassisNumber(String bikeChassisNumber) {
		return mapper.entityToDto(repository.findByBikeChassisNumber(bikeChassisNumber).get());
	}

	@Override
	public BikeServiceDto findByBikeRegistrationNumber(String bikeRegisterationNumber) {
		return mapper.entityToDto(repository.findByBikeRegistrationNumber(bikeRegisterationNumber).get());
	}

	@Override
	public List<BikeServiceDto> findByBikeMake(String bikeMake) {
		return repository.findByBikeMake(bikeMake).get().stream().map((entity) -> mapper.entityToDto(entity)).toList();
	}

	@Override
	public List<BikeServiceDto> findByModelName(String modelName) {
		return repository.findByModelName(modelName).get().stream().map((entity) -> mapper.entityToDto(entity))
				.toList();
	}

	@Override
	public BikeServiceDto updateBikeServiceEntity(Long id, BikeServiceDto bikeServiceDto) {
//		BikeServiceDto savedDto = findById(id);
//		savedDto.setAddress(bikeServiceDto.getAddress());
//		savedDto.setPhoneNumber(bikeServiceDto.getPhoneNumber());
//		savedDto.setGivenDate(bikeServiceDto.getGivenDate().toString());
//		savedDto.setExpectedDeliveryDate(bikeServiceDto.getExpectedDeliveryDate().toString());
//		savedDto.setCreatedDate(bikeServiceDto.getCreatedDate().toString());
//		savedDto.setUpdatedDate(bikeServiceDto.getUpdatedDate().toString());
//		savedDto.setBikeMake(bikeServiceDto.getBikeMake());
//		savedDto.setModelName(bikeServiceDto.getModelName());
//		savedDto.setBikeRegistrationNumber(bikeServiceDto.getBikeRegistrationNumber());
//		savedDto.setBikeChassisNumber(bikeServiceDto.getBikeChassisNumber());
//		savedDto.setKnownIssues(bikeServiceDto.getKnownIssues());
//		savedDto.setCost(bikeServiceDto.getCost());

		return mapper.entityToDto(repository.save(mapper.dtoToEntity(bikeServiceDto)));
	}

	@Override
	public void deleteBikeServiceEntity(Long id) {
		repository.deleteById(id);
	}

}
