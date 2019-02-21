package com.example.springdatademo.repository;

import java.util.Optional;

import com.example.springdatademo.domain.CarEntity;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * CarRepository
 */
public interface CarRepository extends PagingAndSortingRepository<CarEntity,Integer> {
    
    Optional<CarEntity> findCarEntityByBrand(String brand);

}