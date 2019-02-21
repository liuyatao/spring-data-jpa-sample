package com.example.springdatademo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.springdatademo.domain.PersonEntity;
import com.example.springdatademo.domain.PetEntity;
import com.example.springdatademo.dto.PersonHasCatDTO;
import com.example.springdatademo.repository.PersonRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LeftJoinTests {

    @Autowired
    private PersonRepository personRepository;

    @Transactional
    @Test
    public void getOwnersTest(){
        Set<PetEntity> pets =new HashSet<>();
        PetEntity pet1 = new PetEntity();
        pet1.setType("CAT");
        pets.add(pet1);

        PetEntity pet2 = new PetEntity();
        pet2.setType("DOG");
        pets.add(pet2);

        PersonEntity person =new PersonEntity();
        person.setName("liuyatao");
        person.setPets(pets);

        personRepository.save(person);

        List<PersonHasCatDTO> owners=personRepository.findPetOwners("CAT");
        Assert.assertEquals("liuyatao",owners.get(0).getName());
    }
}
