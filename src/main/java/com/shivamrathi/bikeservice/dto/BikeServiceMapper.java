package com.shivamrathi.bikeservice.dto;

import org.mapstruct.Mapper;

import com.shivamrathi.bikeservice.model.BikeServiceEntity;

@Mapper(componentModel = "spring")
public interface BikeServiceMapper {
	BikeServiceEntity reqToEntity(RequestDto requestDto);

	ResponseDto entityToResp(BikeServiceEntity bikeServiceEntity);
}
