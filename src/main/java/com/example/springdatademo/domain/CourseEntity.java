package com.example.springdatademo.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * CourseEntity
 */
@Entity
@Table(name="COURSE")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @ManyToMany(mappedBy="likeCourses")
    private Set<StudentEntity> likes= new HashSet<>();

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
     * @return the likes
     */
    public Set<StudentEntity> getLikes() {
        return likes;
    }

    /**
     * @param likes the likes to set
     */
    public void setLikes(Set<StudentEntity> likes) {
        this.likes = likes;
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
    
    
}