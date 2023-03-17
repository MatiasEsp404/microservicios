package com.matias.userauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.matias.userauth.entity.UserEntity;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Integer> {

}
