package com.example.springdatademo.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * StudentEntity
 */
@Entity
@Table(name="STUDENT")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
        name="COURSE_LIKE",
        joinColumns=@JoinColumn(name="student_id",referencedColumnName="Id"),
        inverseJoinColumns=@JoinColumn(name="course_id",referencedColumnName="Id")
    )
    private Set<CourseEntity> likeCourses= new HashSet<>();

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
     * @return the likeCourses
     */
    public Set<CourseEntity> getLikeCourses() {
        return likeCourses;
    }

    /**
     * @param likeCourses the likeCourses to set
     */
    public void setLikeCourses(Set<CourseEntity> likeCourses) {
        this.likeCourses = likeCourses;
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