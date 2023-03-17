package com.matias.moto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matias.moto.dto.request.MotoRequest;
import com.matias.moto.dto.response.MotoResponse;
import com.matias.moto.exception.EntityNotFoundException;
import com.matias.moto.mapper.MotoMapper;
import com.matias.moto.model.MotoEntity;
import com.matias.moto.repository.IMotoRepository;
import com.matias.moto.service.abs.IMotoService;


@Service
public class MotoService implements IMotoService {

	@Autowired
	private IMotoRepository motoRepository;
	
	@Autowired
	private MotoMapper motoMapper;
	
	@Override
	public List<MotoResponse> getAll() {
		List<MotoEntity> entities = motoRepository.findAll();
		return motoMapper.toMotoResponses(entities);
	}

	@Override
	public MotoResponse getBy(Integer id) {
		return motoMapper.toMotoResponse(findBy(id));
	}
	
	private MotoEntity findBy(Integer id) {
	    Optional<MotoEntity> optionalEntity = motoRepository.findById(id);
	    if (optionalEntity.isEmpty()) {
	      throw new EntityNotFoundException("Moto not found.");
	    }
	    return optionalEntity.get();
	}

	@Override
	public MotoResponse register(MotoRequest request) {
		MotoEntity entity = motoRepository.save(motoMapper.toMotoEntity(request));
		return motoMapper.toMotoResponse(entity);
	}

	@Override
	public List<MotoResponse> getByUser(Integer id) {
		List<MotoEntity> entites = motoRepository.findByUserId(id);
		return motoMapper.toMotoResponses(entites);
	}
}
