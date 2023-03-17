package com.matias.car.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.matias.car.dto.request.CarRequest;
import com.matias.car.dto.response.CarResponse;
import com.matias.car.model.CarEntity;

@Component
public class CarMapper {

	public List<CarResponse> toCarResponses(List<CarEntity> entities) {
		List<CarResponse> response = new ArrayList<>();
		for(CarEntity entity : entities) {
			response.add(toCarResponse(entity));
		}
		return response;
	}

	public CarResponse toCarResponse(CarEntity entity) {
		return CarResponse.builder()
				.id(entity.getId())
				.brand(entity.getBrand())
				.model(entity.getModel())
				.userId(entity.getUserId())
				.build();
	}

	public CarEntity toCarEntity(CarRequest request) {
		return CarEntity.builder()
				.brand(request.getBrand())
				.model(request.getModel())
				.userId(request.getUserId())
				.build();
	}

}
