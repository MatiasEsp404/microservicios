package com.matias.moto.controller;

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

import com.matias.moto.dto.request.MotoRequest;
import com.matias.moto.dto.response.MotoResponse;
import com.matias.moto.service.abs.IMotoService;

@RestController
@RequestMapping(path = "/api/moto")
public class MotoController {

  @Autowired
  private IMotoService motoService;

  @GetMapping
  public ResponseEntity<List<MotoResponse>> getAll() {
    List<MotoResponse> responses = motoService.getAll();
    return ResponseEntity.ok(responses);
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<MotoResponse> getBy(@PathVariable Integer id) {
    MotoResponse response = motoService.getBy(id);
    return ResponseEntity.ok(response);
  }

  @PostMapping
  public ResponseEntity<MotoResponse> register(@RequestBody MotoRequest request) {
    MotoResponse response = motoService.register(request);
    URI uri = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(response.getId())
        .toUri();
    return ResponseEntity.created(uri).body(response);
  }
  
  @GetMapping(path = "/user/{id}")
  public ResponseEntity<List<MotoResponse>> getByUser(@PathVariable Integer id){
	  List<MotoResponse> responses = motoService.getByUser(id);
	  return ResponseEntity.ok(responses);
  }

}
