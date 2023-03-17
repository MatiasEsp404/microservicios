package com.matias.car.service.abs;

import com.matias.car.dto.request.CarRequest;
import com.matias.car.dto.response.CarResponse;
import java.util.List;

public interface ICarService {

  List<CarResponse> getAll();

  CarResponse getBy(Integer id);

  CarResponse register(CarRequest request);

  List<CarResponse> getByUser(Integer id);
}
