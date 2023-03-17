package com.matias.moto.mapper;

import com.matias.moto.dto.request.MotoRequest;
import com.matias.moto.dto.response.MotoResponse;
import com.matias.moto.model.MotoEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class MotoMapper {

  public List<MotoResponse> toMotoResponses(List<MotoEntity> entities) {
    List<MotoResponse> response = new ArrayList<>();
    for (MotoEntity entity : entities) {
      response.add(toMotoResponse(entity));
    }
    return response;
  }

  public MotoResponse toMotoResponse(MotoEntity entity) {
    return MotoResponse.builder()
        .id(entity.getId())
        .brand(entity.getBrand())
        .model(entity.getModel())
        .userId(entity.getUserId())
        .build();
  }

  public MotoEntity toMotoEntity(MotoRequest request) {
    return MotoEntity.builder()
        .brand(request.getBrand())
        .model(request.getModel())
        .userId(request.getUserId())
        .build();
  }

}
