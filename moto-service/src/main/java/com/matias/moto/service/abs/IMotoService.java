package com.matias.moto.service.abs;

import java.util.List;

import com.matias.moto.dto.request.MotoRequest;
import com.matias.moto.dto.response.MotoResponse;


public interface IMotoService {

	List<MotoResponse> getAll();

	MotoResponse getBy(Integer id);

	MotoResponse register(MotoRequest request);

	List<MotoResponse> getByUser(Integer id);
}
