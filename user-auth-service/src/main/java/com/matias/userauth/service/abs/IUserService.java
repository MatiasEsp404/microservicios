package com.matias.userauth.service.abs;

import com.matias.userauth.dto.requests.UserRequest;
import com.matias.userauth.dto.responses.UserResponse;
import com.matias.userauth.model.CarModel;
import com.matias.userauth.model.MotoModel;
import java.util.List;

public interface IUserService {

  List<UserResponse> getAll();

  UserResponse getBy(Integer id);

  UserResponse register(UserRequest request);

  List<CarModel> getCars(Integer id);

  List<MotoModel> getMotos(Integer id);
}
