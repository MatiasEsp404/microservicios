package com.matias.car.repository;

import com.matias.car.model.CarEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarRepository extends JpaRepository<CarEntity, Integer> {

  List<CarEntity> findByUserId(Integer userId);

}
