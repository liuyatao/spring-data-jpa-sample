package com.example.springdatademo.repository;

import java.util.Optional;

import com.example.springdatademo.domain.UserEntity;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * UserRepository
 */
public interface UserRepository extends PagingAndSortingRepository<UserEntity,Integer> {

    Optional<UserEntity> findUserByUsername(String userName);
    
}