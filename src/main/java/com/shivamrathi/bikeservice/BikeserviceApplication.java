package com.shivamrathi.bikeservice;

import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.shivamrathi.bikeservice.dto.BikeServiceDto;
import com.shivamrathi.bikeservice.dto.BikeServiceMapper;
import com.shivamrathi.bikeservice.model.BikeServiceEntity;
import com.shivamrathi.bikeservice.service.BikeService;

@SpringBootApplication
public class BikeserviceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BikeserviceApplication.class, args);

		BikeService bikeService = context.getBean(BikeService.class);
//		BikeServiceMapper mapper = Mappers.getMapper(BikeServiceMapper.class);
//
//		BikeServiceDto dto = new BikeServiceDto();
//		dto.setId((long) 1);
//		dto.setAddress("123");
//		dto.setPhoneNumber("0123456789");
//		dto.setGivenDate("31/05/1996");
//		dto.setExpectedDeliveryDate("31/05/1996");
//		dto.setCreatedDate("31/05/1996");
//		dto.setUpdatedDate("31/05/1996");
//		dto.setBikeMake("Honda");
//		dto.setModelName("HRV");
//		dto.setBikeRegistrationNumber("reg 1");
//		dto.setBikeChassisNumber("cha 1");
//		dto.setKnownIssues("issue 1");
//		dto.setCost(10);
//
//		BikeServiceEntity entity = mapper.bikeServiceDtoToBikeServiceEntity(dto);
//
//		BikeServiceEntity saved = bikeService.saveBikeServiceEntity(entity);
//
//		System.out.println("saved= " + saved);
//
//		BikeServiceDto dto1 = new BikeServiceDto();
//		dto1.setId((long) 2);
//		dto1.setAddress("Delhi");
//		dto1.setPhoneNumber("0123456780");
//		dto1.setGivenDate("31/05/1996");
//		dto1.setExpectedDeliveryDate("31/05/1996");
//		dto1.setCreatedDate("31/05/1996");
//		dto1.setUpdatedDate("31/05/1996");
//		dto1.setBikeMake("Apache");
//		dto1.setModelName("R15");
//		dto1.setBikeRegisterationNumber("reg 2");
//		dto1.setBikeChassisNumber("cha 2");
//		dto1.setKnownIssues("issue 1");
//		dto1.setCost(10);
//
//		BikeServiceEntity entity1 = mapper.bikeServiceDtoToBikeServiceEntity(dto1);
//
//		BikeServiceEntity saved1 = bikeService.saveBikeServiceEntity(entity1);
//		System.out.println("saved= " + saved1);
//
//		BikeServiceDto dto2 = new BikeServiceDto();
//		dto2.setId((long) 3);
//		dto2.setAddress("Delhi");
//		dto2.setPhoneNumber("0123456700");
//		dto2.setGivenDate("31/05/1996");
//		dto2.setExpectedDeliveryDate("31/05/1996");
//		dto2.setCreatedDate("31/05/1996");
//		dto2.setUpdatedDate("31/05/1996");
//		dto2.setBikeMake("Apache");
//		dto2.setModelName("R15");
//		dto2.setBikeRegisterationNumber("reg 3");
//		dto2.setBikeChassisNumber("cha 3");
//		dto2.setKnownIssues("issue 3");
//		dto2.setCost(10);
//
//		BikeServiceEntity entity2 = mapper.bikeServiceDtoToBikeServiceEntity(dto2);
//
//		BikeServiceEntity saved2 = bikeService.saveBikeServiceEntity(entity2);
//		System.out.println("saved= " + saved2);
//
//		System.out.println("find by id = " + bikeService.findById((long) 1));
//		System.out.println("find by phone= " + bikeService.findByPhoneNumber("0123456700"));
//		System.out.println("find by cassis = " + bikeService.findByBikeChassisNumber("cha 3"));
//		System.out.println("find by reg = " + bikeService.findByBikeRegistrationNumber("reg 3"));
//		System.out.println("find by make = " + bikeService.findByBikeMake("Apache"));
//		System.out.println("find by mode = " + bikeService.findByModelName("R15"));
	}
}
