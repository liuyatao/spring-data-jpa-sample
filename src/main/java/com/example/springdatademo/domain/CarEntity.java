package com.example.springdatademo.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * CarEntity
 */
@Entity
@Table(name="CAR")
public class CarEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String brand;

    @OneToOne(mappedBy="car")
    @JoinColumn(name="person_id",referencedColumnName="id")
    private PersonEntity person;

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
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the person
     */
    public PersonEntity getPerson() {
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(PersonEntity person) {
        this.person = person;
    }


}