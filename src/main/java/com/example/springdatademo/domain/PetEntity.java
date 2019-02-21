package com.example.springdatademo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * PetEntity
 */
@Entity
@Table(name="PET")
public class PetEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column
    private String type;


    @ManyToOne
    @JoinColumn(referencedColumnName="id",name="Person_ID")
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
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
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