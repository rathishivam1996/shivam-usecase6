package com.shivamrathi.bikeservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shivamrathi.bikeservice.dto.BikeServiceDto;

@Service
public interface IBikeService {

	public BikeServiceDto saveBikeServiceEntity(BikeServiceDto bikeServiceDto);

	public BikeServiceDto findById(Long id);

	public BikeServiceDto findByPhoneNumber(String phoneNumber);

	public BikeServiceDto findByBikeChassisNumber(String bikeChassisNumber);

	public BikeServiceDto findByBikeRegistrationNumber(String bikeRegisterationNumber);

	public List<BikeServiceDto> findByBikeMake(String bikeMake);

	public List<BikeServiceDto> findByModelName(String modelName);

	public BikeServiceDto updateBikeServiceEntity(Long id, BikeServiceDto bikeServiceDto);

	public void deleteBikeServiceEntity(Long id);
}