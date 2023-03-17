package com.matias.userauth.service;

import com.matias.userauth.dto.requests.UserRequest;
import com.matias.userauth.dto.responses.UserResponse;
import com.matias.userauth.entity.UserEntity;
import com.matias.userauth.exception.EntityNotFoundException;
import com.matias.userauth.mapper.UserMapper;
import com.matias.userauth.model.CarModel;
import com.matias.userauth.model.MotoModel;
import com.matias.userauth.repository.IUserRepository;
import com.matias.userauth.service.abs.IUserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService implements IUserService {

  @Autowired
  private IUserRepository userRepository;

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<UserResponse> getAll() {
    List<UserEntity> entities = userRepository.findAll();
    return userMapper.toUserResponses(entities);
  }

  @Override
  public UserResponse getBy(Integer id) {
    return userMapper.toUserResponse(findBy(id));
  }

  private UserEntity findBy(Integer id) {
    Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
    if (optionalUserEntity.isEmpty()) {
      throw new EntityNotFoundException("User not found.");
    }
    return optionalUserEntity.get();
  }

  @Override
  public UserResponse register(UserRequest request) {
    UserEntity entity = userRepository.save(userMapper.toUserEntity(request));
    return userMapper.toUserResponse(entity);
  }

  @Override
  public List<CarModel> getCars(Integer id) {
    ResponseEntity<List<CarModel>> response = restTemplate.exchange(
        "http://localhost:8082/api/car/user/" + id,
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<CarModel>>() {
        }
    );
    return response.getBody();
  }

  @Override
  public List<MotoModel> getMotos(Integer id) {
    ResponseEntity<List<MotoModel>> response = restTemplate.exchange(
        "http://localhost:8083/api/moto/user/" + id,
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<MotoModel>>() {
        }
    );
    return response.getBody();
  }

}
