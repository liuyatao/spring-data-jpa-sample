package com.example.springdatademo.repository;

import com.example.springdatademo.domain.StudentEntity;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * StudentRepository
 */
public interface StudentRepository extends PagingAndSortingRepository<StudentEntity,Integer> {

    
}