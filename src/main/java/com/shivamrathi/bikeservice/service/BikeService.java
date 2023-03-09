package com.shivamrathi.bikeservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivamrathi.bikeservice.model.BikeServiceEntity;
import com.shivamrathi.bikeservice.repository.BikeServiceRepository;

@Service
public class BikeService implements IBikeService {

	@Autowired
	BikeServiceRepository bikeServiceRepository;

	@Override
	public BikeServiceEntity saveBikeServiceEntity(BikeServiceEntity bikeServiceEntity) {
		return bikeServiceRepository.save(bikeServiceEntity);
	}

	@Override
	public BikeServiceEntity findById(Long id) {
		return bikeServiceRepository.findById(id).get();
	}

	@Override
	public BikeServiceEntity findByPhoneNumber(String phoneNumber) {
		return bikeServiceRepository.findByPhoneNumber(phoneNumber).get();
	}

	@Override
	public BikeServiceEntity findByBikeChassisNumber(String bikeChassisNumber) {
		return bikeServiceRepository.findByBikeChassisNumber(bikeChassisNumber).get();
	}

	@Override
	public BikeServiceEntity findByBikeRegistrationNumber(String bikeRegisterationNumber) {
		return bikeServiceRepository.findByBikeRegistrationNumber(bikeRegisterationNumber).get();
	}

	@Override
	public List<BikeServiceEntity> findByBikeMake(String bikeMake) {
		return bikeServiceRepository.findByBikeMake(bikeMake).get();
	}

	@Override
	public List<BikeServiceEntity> findByModelName(String modelName) {
		return bikeServiceRepository.findByModelName(modelName).get();
	}

	@Override
	public BikeServiceEntity updateBikeServiceEntity(Long id, BikeServiceEntity bikeServiceEntity) {
		BikeServiceEntity savedEntity = findById(id);
		savedEntity.setAddress(bikeServiceEntity.getAddress());
		savedEntity.setPhoneNumber(bikeServiceEntity.getPhoneNumber());
		savedEntity.setGivenDate(bikeServiceEntity.getGivenDate());
		savedEntity.setExpectedDeliveryDate(bikeServiceEntity.getExpectedDeliveryDate());
		savedEntity.setCreatedDate(bikeServiceEntity.getCreatedDate());
		savedEntity.setUpdatedDate(bikeServiceEntity.getUpdatedDate());
		savedEntity.setBikeMake(bikeServiceEntity.getBikeMake());
		savedEntity.setModelName(bikeServiceEntity.getModelName());
		savedEntity.setBikeRegistrationNumber(bikeServiceEntity.getBikeRegistrationNumber());
		savedEntity.setBikeChassisNumber(bikeServiceEntity.getBikeChassisNumber());
		savedEntity.setKnownIssues(bikeServiceEntity.getKnownIssues());
		savedEntity.setCost(bikeServiceEntity.getCost());

		return bikeServiceRepository.save(savedEntity);
	}

	@Override
	public void deleteBikeServiceEntity(Long id) {
		bikeServiceRepository.deleteById(id);
	}

}
