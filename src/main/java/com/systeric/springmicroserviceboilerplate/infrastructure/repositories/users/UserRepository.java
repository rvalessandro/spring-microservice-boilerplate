package com.systeric.springmicroserviceboilerplate.infrastructure.repositories.users;

import com.systeric.springmicroserviceboilerplate.infrastructure.entities.users.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID>, JpaSpecificationExecutor<UserEntity>, PagingAndSortingRepository<UserEntity, UUID> {
}