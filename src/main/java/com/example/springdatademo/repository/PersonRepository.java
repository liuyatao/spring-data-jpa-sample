package com.example.springdatademo.repository;

import java.util.List;
import java.util.Optional;

import com.example.springdatademo.domain.PersonEntity;
import com.example.springdatademo.dto.PersonHasCatDTO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * PersonRepository
 */
public interface PersonRepository extends PagingAndSortingRepository<PersonEntity,Integer> {

    Optional<PersonEntity> findPersonEntityByName(String name);

    @Query("select new  com.example.springdatademo.dto.PersonHasCatDTO (persion.id,persion.name,pet.type) from PersonEntity persion left join persion.pets pet")
    List<PersonHasCatDTO> findPetOwners(@Param("type") String type);
    
}