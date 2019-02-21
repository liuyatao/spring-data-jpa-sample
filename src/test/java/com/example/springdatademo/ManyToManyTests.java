package com.example.springdatademo;

import java.util.HashSet;
import java.util.Set;

import com.example.springdatademo.domain.CourseEntity;
import com.example.springdatademo.domain.StudentEntity;
import com.example.springdatademo.repository.CourseRepository;
import com.example.springdatademo.repository.StudentRepository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * ManyToManyTests
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyToManyTests {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Transactional
    @Test
    public void addStudentTest() {
        // add a student
        Set<CourseEntity> courseList = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            CourseEntity courseEntity = new CourseEntity();
            courseEntity.setName("course" + i);
            courseList.add(courseEntity);
        }

        StudentEntity studentEntity1 = new StudentEntity();
        studentEntity1.setName("liuyatao1");
        studentEntity1.setLikeCourses(courseList);
        studentRepository.save(studentEntity1);

        StudentEntity studentEntity2 = new StudentEntity();
        studentEntity2.setName("liuyatao2");
        studentEntity2.setLikeCourses(courseList);
        studentRepository.save(studentEntity2);

        long studentSize = studentRepository.count();
        Assert.assertEquals(2, studentSize);

        long courseSize = courseRepository.count();
        Assert.assertEquals(5, courseSize);

        int studentCourseSize1= studentRepository.findById(1).get().getLikeCourses().size();
        int studentCourseSize2= studentRepository.findById(2).get().getLikeCourses().size();
        Assert.assertEquals(5, studentCourseSize1);
        Assert.assertEquals(5, studentCourseSize2);
    }
}