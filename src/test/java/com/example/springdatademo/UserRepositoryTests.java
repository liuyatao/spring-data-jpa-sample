package com.example.springdatademo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.springdatademo.domain.UserEntity;
import com.example.springdatademo.repository.UserRepository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


/**
 * UserRepositoryTests
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;


    private UserEntity newUser(){
        UserEntity userEntity =new UserEntity();
        LocalDate birthday = LocalDate.of(1992, 10, 25);
        userEntity.setBirthday(birthday);
        userEntity.setEmail("729697044@qq.com");
        userEntity.setNickname("lyt");
        userEntity.setUsername("liuyatao");
        return userEntity;
    }
    @Test
    @Transactional
    public void addUserTest() {
        userRepository.save(newUser());
        boolean present = userRepository.findUserByUsername("liuyatao").isPresent();
        Assert.assertEquals(true, present);
    }


    @Test
    @Transactional
    public void updateUserTest() {

        userRepository.save(newUser());
        boolean present = userRepository.findUserByUsername("liuyatao").isPresent();
        Assert.assertEquals(true, present);
    }

    /**
     * 分页查询
     */
    @Test
    @Transactional
    public void findAllByPage() {
        //准备要插入的数据
        List<UserEntity> userEntities =new ArrayList<UserEntity>();
        for (int i = 0; i < 6; i++) {
            userEntities.add(newUser());
        }
        userRepository.saveAll(userEntities);

        //创建分页查找的请求参数：每页3项，请求第一页，id 降序排列
        Pageable pageable = PageRequest.of(0, 3, Direction.DESC,"id");
        Page<UserEntity> page =userRepository.findAll(pageable);

        
        Assert.assertEquals(2, page.getTotalPages());
        Assert.assertEquals(6, page.getTotalElements());
        Assert.assertEquals(true, page.isFirst());
    }





   
}