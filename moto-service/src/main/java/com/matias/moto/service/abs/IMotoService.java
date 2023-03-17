package com.matias.moto.service.abs;

import com.matias.moto.dto.request.MotoRequest;
import com.matias.moto.dto.response.MotoResponse;
import java.util.List;


public interface IMotoService {

  List<MotoResponse> getAll();

  MotoResponse getBy(Integer id);

  MotoResponse register(MotoRequest request);

  List<MotoResponse> getByUser(Integer id);
}
