package com.example.springdatademo.repository;

import java.util.Optional;

import com.example.springdatademo.domain.PetEntity;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * PetRepository
 */
public interface PetRepository extends PagingAndSortingRepository<PetEntity,Integer> {

    Optional<PetEntity> findPetEntityByType(String type);
    
}