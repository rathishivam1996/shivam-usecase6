package com.shivamrathi.bikeservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivamrathi.bikeservice.model.BikeServiceEntity;

public interface BikeServiceRepository extends JpaRepository<BikeServiceEntity, Long> {
	Optional<BikeServiceEntity> findById(Long id);

	Optional<BikeServiceEntity> findByPhoneNumber(String phoneNumber);

	Optional<BikeServiceEntity> findByBikeRegistrationNumber(String bikeRegistrationNumber);

	Optional<BikeServiceEntity> findByBikeChassisNumber(String bikeChassisNumber);

	Optional<List<BikeServiceEntity>> findByBikeMake(String bikeMake);

	Optional<List<BikeServiceEntity>> findByModelName(String modelName);

}