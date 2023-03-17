package com.matias.moto.repository;

import com.matias.moto.model.MotoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMotoRepository extends JpaRepository<MotoEntity, Integer> {

  List<MotoEntity> findByUserId(Integer userId);

}
