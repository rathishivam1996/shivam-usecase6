package com.shivamrathi.bikeservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shivamrathi.bikeservice.dto.BikeServiceDto;
import com.shivamrathi.bikeservice.dto.RequestDto;
import com.shivamrathi.bikeservice.dto.ResponseDto;

@Service
public interface IBikeService {

	public ResponseDto saveBikeServiceEntity(RequestDto requestDto);

	public ResponseDto findById(Long id);

	public ResponseDto findByPhoneNumber(String phoneNumber);

	public ResponseDto findByBikeChassisNumber(String bikeChassisNumber);

	public ResponseDto findByBikeRegistrationNumber(String bikeRegisterationNumber);

	public List<ResponseDto> findByBikeMake(String bikeMake);

	public List<ResponseDto> findByModelName(String modelName);

	public ResponseDto updateBikeServiceEntity(Long id, RequestDto reqDto);

	public void deleteBikeServiceEntity(Long id);
}