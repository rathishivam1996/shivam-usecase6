package com.shivamrathi.bikeservice.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.context.SpringBootTest;

import com.shivamrathi.bikeservice.dto.BikeServiceDto;
import com.shivamrathi.bikeservice.dto.BikeServiceMapper;
import com.shivamrathi.bikeservice.model.BikeServiceEntity;
import com.shivamrathi.bikeservice.repository.BikeServiceRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class BikeServiceTest {

	@Mock
	private BikeServiceRepository repository;

	@InjectMocks
	private BikeService service;

	private BikeServiceDto entity;

	@Mock
	BikeServiceMapper mapper;

	@BeforeEach
	public void setUp() {
		// repository = Mockito.mock(BikeServiceRepository.class);
		// bikeService = new BikeService(repository);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
		LocalDate date = LocalDate.parse("31/05/1996", formatter);

		mapper = Mappers.getMapper(BikeServiceMapper.class);

		System.out.println("@BeforeEach --->>>");

		entity = BikeServiceDto.builder().id((long) 1).address("goa").phoneNumber("0123456789").givenDate(date)
				.expectedDeliveryDate(date).bikeChassisNumber("cha1")
				.bikeRegistrationNumber("reg1").bikeMake("Honda").modelName("R15").knownIssues("issues1").cost(1000)
				.build();
	}

	@DisplayName("JUnit test for saveBikeServiceEntity method")
	@Test
	public void should_save_and_return_one_entity() {
		// given - precondition / setup
		given(repository.findById(entity.getId())).willReturn(Optional.empty());
		when(repository.save(any(BikeServiceEntity.class))).thenReturn(mapper.dtoToEntity(entity));

		// Act
		BikeServiceDto actual = service.saveBikeServiceEntity(entity);
		System.out.println("*********************************");
		System.out.println("should_save_and_return_one_entity ->> actual=" + actual);
		System.out.println("*********************************");

		// Assert
		assertThat(actual).usingRecursiveComparison().isEqualTo(entity);
		verify(repository, times(1)).save(any(BikeServiceEntity.class));
		verifyNoMoreInteractions(repository);
	}

	@Test
	@DisplayName("JUnit test for findById method")
	public void should_find_by_id_and_return_one_entity()
	{
		// Setup
		when(repository.findById(anyLong())).thenReturn(Optional.of(mapper.dtoToEntity(entity)));
		
		// Act
		BikeServiceDto actual = service.findById(getRandomLong());
		System.out.println("*********************************");
		System.out.println("should_find_by_id_and_return_one_entity ->> actual=" + actual);
		System.out.println("*********************************");
		
		// Assert
		assertThat(actual).usingRecursiveComparison().isEqualTo(entity);
		verify(repository, times(1)).findById(anyLong());
		verifyNoMoreInteractions(repository);
	}

	@Test
	@DisplayName("JUnit test for findByBikeChassisNumber method")
	public void should_find_by_bike_chassis_number_and_return_one_entity()
	{
		// Setup
		when(repository.findByBikeChassisNumber(anyString())).thenReturn(Optional.of(mapper.dtoToEntity(entity)));
		
		// Act
		BikeServiceDto actual = service.findByBikeChassisNumber("cha1");
		System.out.println("*********************************");
		System.out.println("should_find_by_bike_chassis_number_and_return_one_entity ->> actual=" + actual);
		System.out.println("*********************************");
		
		// Assert
		assertThat(actual).usingRecursiveComparison().isEqualTo(entity);
		verify(repository, times(1)).findByBikeChassisNumber(anyString());
		verifyNoMoreInteractions(repository);
	}

	@Test
	@DisplayName("JUnit test for findByBikeRegistrationNumber method")
	public void should_find_by_bike_registration_number_and_return_one_entity()
	{
		// Setup
		when(repository.findByBikeRegistrationNumber(anyString())).thenReturn(Optional.of(mapper.dtoToEntity(entity)));
		
		// Act
		BikeServiceDto actual = service.findByBikeRegistrationNumber("cha1");
		System.out.println("*********************************");
		System.out.println("should_find_by_bike_registration_number_and_return_one_entity ->> actual=" + actual);
		System.out.println("*********************************");
		
		// Assert
		assertThat(actual).usingRecursiveComparison().isEqualTo(entity);
		verify(repository, times(1)).findByBikeRegistrationNumber(anyString());
		verifyNoMoreInteractions(repository);
	}

	@Test
	@DisplayName("JUnit test for findById method")
    void should_not_found_a_entity_that_doesnt_exists() {
        // Arrange
        when(repository.findById(anyLong())).thenReturn(Optional.empty());

        // Act & Assert
        Assertions.assertThrows(NoSuchElementException.class, () -> service.findById(getRandomLong()));
        verify(repository, times(1)).findById(anyLong());
        verifyNoMoreInteractions(repository);
    }

	@Test
	@DisplayName("JUnit test for deleteById method")
	void should_delete_a_entity_that_exists() {
		// Setup
		// Long id = 1L;
		doNothing().when(repository).deleteById(anyLong());

		// Act
		service.deleteBikeServiceEntity(getRandomLong());
		verify(repository, times(1)).deleteById(anyLong());
		verifyNoMoreInteractions(repository);
	}

	@Test
	@DisplayName("JUnit test for update method")
	void givenEntityObject_whenUpdateEntity_thenReturnUpdatedEntity() {
		// given - precondition or setup
		when(repository.save(mapper.dtoToEntity(entity))).thenReturn(mapper.dtoToEntity(entity));
		when(repository.findById(anyLong())).thenReturn(Optional.of(mapper.dtoToEntity(entity)));
		entity.setCost(5);
		entity.setAddress("McLeod Ganj");
		// when - action or the behavior that we are going test
		BikeServiceDto updated = service.updateBikeServiceEntity(entity.getId(), entity);

		// then - verify the output
		assertThat(updated.getAddress()).isEqualTo("McLeod Ganj");
		assertThat(updated.getCost()).isEqualTo(5);
	}

	private long getRandomLong() {
		return (long) new Random().ints(1, 10).findFirst().getAsInt();
	}
}
