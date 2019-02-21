package com.example.springdatademo;

import java.util.Optional;

import javax.transaction.Transactional;

import com.example.springdatademo.domain.CarEntity;
import com.example.springdatademo.domain.PersonEntity;
import com.example.springdatademo.repository.CarRepository;
import com.example.springdatademo.repository.PersonRepository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * OneToOneTests
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OneToOneTests {


    @Autowired
    private CarRepository carRepository;

    @Autowired
    private PersonRepository personRepository;

    @Test
    @Transactional
    public void addPerson() {
        CarEntity car = new CarEntity();
        car.setBrand("BMW");
        PersonEntity person =new PersonEntity();
        person.setName("liuyatao");
        person.setCar(car);
        personRepository.save(person);

        Optional<PersonEntity> personEntityOptional = personRepository.findPersonEntityByName("liuyatao");
        
        Optional<CarEntity> carEntityOptional = carRepository.findCarEntityByBrand("BMW");

        String personName = personEntityOptional.map(p->{
           return p.getName();
        }).orElse("Not Found");

        String carBrand = carEntityOptional.map(c->{
            return c.getBrand();
         }).orElse("Not Found");

         Assert.assertEquals("liuyatao", personName);
         Assert.assertEquals("BMW", carBrand);
         Assert.assertEquals(1, carRepository.count());
         Assert.assertEquals(1, personRepository.count());

    }

}