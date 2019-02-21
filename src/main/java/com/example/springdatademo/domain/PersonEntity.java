package com.example.springdatademo.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * PersonEntity
 */
@Entity
@Table(name="PERSON")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @OneToOne(cascade=CascadeType.ALL)
    private CarEntity car;


    @OneToMany(mappedBy="person",cascade=CascadeType.ALL)
    private Set<PetEntity> pets =new HashSet<>();

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the car
     */
    public CarEntity getCar() {
        return car;
    }

    /**
     * @param car the car to set
     */
    public void setCar(CarEntity car) {
        this.car = car;
    }

    /**
     * @return the pets
     */
    public Set<PetEntity> getPets() {
        return pets;
    }

    /**
     * @param pets the pets to set
     */
    public void setPets(Set<PetEntity> pets) {
        this.pets = pets;
    }
    
}