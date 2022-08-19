package com.rvalessandro.springmicroserviceboilerplate.infrastructure.repositories;

import com.rvalessandro.springmicroserviceboilerplate.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}