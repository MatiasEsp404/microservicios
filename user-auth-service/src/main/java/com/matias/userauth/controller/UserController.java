package com.matias.userauth.controller;

import com.matias.userauth.dto.requests.UserRequest;
import com.matias.userauth.dto.responses.UserResponse;
import com.matias.userauth.model.CarModel;
import com.matias.userauth.model.MotoModel;
import com.matias.userauth.service.abs.IUserService;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {

  @Autowired
  private IUserService userService;

  @GetMapping
  public ResponseEntity<List<UserResponse>> getAll() {
    List<UserResponse> responses = userService.getAll();
    return ResponseEntity.ok(responses);
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<UserResponse> getBy(@PathVariable Integer id) {
    UserResponse response = userService.getBy(id);
    return ResponseEntity.ok(response);
  }

  @PostMapping
  public ResponseEntity<UserResponse> register(@RequestBody UserRequest request) {
    UserResponse response = userService.register(request);
    URI uri = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(response.getId())
        .toUri();
    return ResponseEntity.created(uri).body(response);
  }
  
  @GetMapping(path = "/cars/{id}")
  public ResponseEntity<List<CarModel>> getCars(@PathVariable Integer id){
    List<CarModel> cars = userService.getCars(id);
    return ResponseEntity.ok(cars);
  }
  
  @GetMapping(path = "/motos/{id}")
  public ResponseEntity<List<MotoModel>> getMotos(@PathVariable Integer id){
    List<MotoModel> motos = userService.getMotos(id);
    return ResponseEntity.ok(motos);
  }

}
