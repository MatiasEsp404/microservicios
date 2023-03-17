package com.matias.car.controller;

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

import com.matias.car.dto.request.CarRequest;
import com.matias.car.dto.response.CarResponse;
import com.matias.car.service.abs.ICarService;

@RestController
@RequestMapping(path = "/api/car")
public class CarController {

  @Autowired
  private ICarService carService;

  @GetMapping
  public ResponseEntity<List<CarResponse>> getAll() {
    List<CarResponse> responses = carService.getAll();
    return ResponseEntity.ok(responses);
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<CarResponse> getBy(@PathVariable Integer id) {
    CarResponse response = carService.getBy(id);
    return ResponseEntity.ok(response);
  }

  @PostMapping
  public ResponseEntity<CarResponse> register(@RequestBody CarRequest request) {
    CarResponse response = carService.register(request);
    URI uri = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(response.getId())
        .toUri();
    return ResponseEntity.created(uri).body(response);
  }
  
  @GetMapping(path = "/user/{id}")
  public ResponseEntity<List<CarResponse>> getByUser(@PathVariable Integer id){
	  List<CarResponse> responses = carService.getByUser(id);
	  return ResponseEntity.ok(responses);
  }

}
