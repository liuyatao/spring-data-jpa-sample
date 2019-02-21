package com.example.springdatademo;

import java.util.HashSet;
import java.util.Set;

import com.example.springdatademo.domain.PersonEntity;
import com.example.springdatademo.domain.PetEntity;
import com.example.springdatademo.repository.PersonRepository;
import com.example.springdatademo.repository.PetRepository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


/**
 * OneTOManyTests
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OneTOManyTests {


    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PetRepository petRepository;

    @Transactional
    @Test
    public void addPersonWithPets() {
        Set<PetEntity> pets= new HashSet<>();

        PetEntity pet1 =new PetEntity();
        pet1.setType("CAT");
        PetEntity pet2 =new PetEntity();
        pet2.setType("DOG");
        pets.add(pet1);
        pets.add(pet2);

        PersonEntity person = new PersonEntity();
        person.setName("liuyatao");
        person.setPets(pets);

        personRepository.save(person);

        Assert.assertEquals(1, personRepository.count());
        Assert.assertEquals(2, petRepository.count());

        String type;
        type = petRepository.findPetEntityByType("DOG")
        .map(p->p.getType())
        .orElse("NOT FOUND");
        Assert.assertEquals("DOG", type);

        type = petRepository.findPetEntityByType("CAT")
        .map(p->p.getType())
        .orElse("NOT FOUND");
        Assert.assertEquals("CAT", type);

    }

    
}