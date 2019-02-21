package com.example.springdatademo.repository;

import java.util.Optional;

import com.example.springdatademo.domain.PersonEntity;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * PersonRepository
 */
public interface PersonRepository extends PagingAndSortingRepository<PersonEntity,Integer> {

    Optional<PersonEntity> findPersonEntityByName(String name);
    
}