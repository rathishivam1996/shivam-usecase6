package com.shivamrathi.bikeservice.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivamrathi.bikeservice.dto.BikeServiceDto;
import com.shivamrathi.bikeservice.dto.BikeServiceMapper;
import com.shivamrathi.bikeservice.dto.RequestDto;
import com.shivamrathi.bikeservice.dto.ResponseDto;
import com.shivamrathi.bikeservice.repository.BikeServiceRepository;

@Service
public class BikeService implements IBikeService {

	@Autowired
	BikeServiceRepository repository;

	@Autowired
	BikeServiceMapper mapper;

	@Override
	public ResponseDto saveBikeServiceEntity(RequestDto requestDto) {
		requestDto.setCreatedDate(LocalDateTime.now());
		requestDto.setUpdatedDate(LocalDateTime.now());
		return mapper.entityToResp(repository.save(mapper.reqToEntity(requestDto)));
	}

	@Override
	public ResponseDto findById(Long id) {
		return mapper.entityToResp(repository.findById(id).get());
	}

	@Override
	public ResponseDto findByPhoneNumber(String phoneNumber) {
		return mapper.entityToResp(repository.findByPhoneNumber(phoneNumber).get());
	}

	@Override
	public ResponseDto findByBikeChassisNumber(String bikeChassisNumber) {
		return mapper.entityToResp(repository.findByBikeChassisNumber(bikeChassisNumber).get());
	}

	@Override
	public ResponseDto findByBikeRegistrationNumber(String bikeRegisterationNumber) {
		return mapper.entityToResp(repository.findByBikeRegistrationNumber(bikeRegisterationNumber).get());
	}

	@Override
	public List<ResponseDto> findByBikeMake(String bikeMake) {
		return repository.findByBikeMake(bikeMake).get().stream().map((entity) -> mapper.entityToResp(entity)).toList();
	}

	@Override
	public List<ResponseDto> findByModelName(String modelName) {
		return repository.findByModelName(modelName).get().stream().map((entity) -> mapper.entityToResp(entity))
				.toList();
	}

	@Override
	public ResponseDto updateBikeServiceEntity(Long id, RequestDto reqDto) {
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

		return mapper.entityToResp(repository.save(mapper.reqToEntity(bikeServiceDto)));
	}

	@Override
	public void deleteBikeServiceEntity(Long id) {
		repository.deleteById(id);
	}

}
