package com.example.springdatademo.controller;

import javax.validation.Valid;

import com.example.springdatademo.domain.UserEntity;
import com.example.springdatademo.service.UserService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

/**
 * UserController
 */
@RestController
@RequestMapping(value="/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;    
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method=RequestMethod.POST)
    public void register(@RequestBody @Valid UserEntity userEntity) {
        userService.createUser(userEntity);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method=RequestMethod.GET,value="/{Id}")
    public UserEntity getUserById(@PathVariable(name="Id") Integer id){
        return userService.getUserById(id);
    }
}