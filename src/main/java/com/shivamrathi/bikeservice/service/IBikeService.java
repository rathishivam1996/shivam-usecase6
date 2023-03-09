package com.shivamrathi.bikeservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shivamrathi.bikeservice.model.BikeServiceEntity;

@Service
public interface IBikeService {

	public BikeServiceEntity saveBikeServiceEntity(BikeServiceEntity bikeServiceEntity);

	public BikeServiceEntity findById(Long id);

	public BikeServiceEntity findByPhoneNumber(String phoneNumber);

	public BikeServiceEntity findByBikeChassisNumber(String bikeChassisNumber);

	public BikeServiceEntity findByBikeRegistrationNumber(String bikeRegisterationNumber);

	public List<BikeServiceEntity> findByBikeMake(String bikeMake);

	public List<BikeServiceEntity> findByModelName(String modelName);

	public BikeServiceEntity updateBikeServiceEntity(Long id, BikeServiceEntity bikeServiceEntity);

	public void deleteBikeServiceEntity(Long id);
}