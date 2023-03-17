package com.matias.userauth.service.abs;

import java.util.List;

import com.matias.userauth.dto.requests.UserRequest;
import com.matias.userauth.dto.responses.UserResponse;
import com.matias.userauth.model.CarModel;
import com.matias.userauth.model.MotoModel;

public interface IUserService {

	List<UserResponse> getAll();

	UserResponse getBy(Integer id);
	
	UserResponse register(UserRequest request);
	
	List<CarModel> getCars(Integer id);
	
	List<MotoModel> getMotos(Integer id);
}
