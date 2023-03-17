package com.matias.car.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matias.car.dto.request.CarRequest;
import com.matias.car.dto.response.CarResponse;
import com.matias.car.exception.EntityNotFoundException;
import com.matias.car.mapper.CarMapper;
import com.matias.car.model.CarEntity;
import com.matias.car.repository.ICarRepository;
import com.matias.car.service.abs.ICarService;

@Service
public class CarService implements ICarService {

	@Autowired
	private ICarRepository carRepository;
	
	@Autowired
	private CarMapper carMapper;
	
	@Override
	public List<CarResponse> getAll() {
		List<CarEntity> entities = carRepository.findAll();
		return carMapper.toCarResponses(entities);
	}

	@Override
	public CarResponse getBy(Integer id) {
		return carMapper.toCarResponse(findBy(id));
	}
	
	private CarEntity findBy(Integer id) {
	    Optional<CarEntity> optionalEntity = carRepository.findById(id);
	    if (optionalEntity.isEmpty()) {
	      throw new EntityNotFoundException("Car not found.");
	    }
	    return optionalEntity.get();
	}

	@Override
	public CarResponse register(CarRequest request) {
		CarEntity entity = carRepository.save(carMapper.toCarEntity(request));
		return carMapper.toCarResponse(entity);
	}

	@Override
	public List<CarResponse> getByUser(Integer id) {
		List<CarEntity> entites = carRepository.findByUserId(id);
		return carMapper.toCarResponses(entites);
	}
}
