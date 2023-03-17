package com.matias.moto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matias.moto.model.MotoEntity;

@Repository
public interface IMotoRepository extends JpaRepository<MotoEntity, Integer> {

	List<MotoEntity> findByUserId(Integer userId);
	
}
