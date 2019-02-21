package com.example.springdatademo.repository;

import com.example.springdatademo.domain.CourseEntity;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * CourseRepository
 */
public interface CourseRepository extends PagingAndSortingRepository<CourseEntity,Integer> {

    
}