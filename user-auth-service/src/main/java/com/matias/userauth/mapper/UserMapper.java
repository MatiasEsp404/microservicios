package com.matias.userauth.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.matias.userauth.dto.requests.UserRequest;
import com.matias.userauth.dto.responses.UserResponse;
import com.matias.userauth.entity.UserEntity;

@Component
public class UserMapper {

	public List<UserResponse> toUserResponses(List<UserEntity> entities) {
		List<UserResponse> responses = new ArrayList<>();
		for(UserEntity entity : entities) {
			responses.add(toUserResponse(entity));
		}
		return responses;
	}

	public UserResponse toUserResponse(UserEntity entity) {
		return UserResponse.builder()
				.Id(entity.getId())
				.name(entity.getName())
				.email(entity.getEmail())
				.build();
	}

	public UserEntity toUserEntity(UserRequest request) {
		return UserEntity.builder()
				.name(request.getName())
				.email(request.getEmail())
				.build();
	}

}
