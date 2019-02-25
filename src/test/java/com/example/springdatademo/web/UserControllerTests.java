package com.example.springdatademo.web;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import com.example.springdatademo.controller.UserController;
import com.example.springdatademo.domain.UserEntity;
import com.example.springdatademo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * UserControllerTests
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTests {

    @Autowired
    private HttpMessageConverter<?>[] httpMessageConverters;

    @Mock
    private UserService mockUserService;

    private MockMvc restMockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        UserController userMockResource = new UserController(mockUserService);
        this.restMockMvc = MockMvcBuilders.standaloneSetup(userMockResource).setMessageConverters(httpMessageConverters)
                .build();
    }

    /**
     * 使用非法的参数
     * 
     * @throws Exception
     */
    @Test
    public void registerWithInvalidParamTest() throws Exception {
        UserEntity invalidUser = new UserEntity();
        invalidUser.setUsername("liuyatao");
        // invalidUser.setNickname("lyt");  
        ObjectMapper mapper =new ObjectMapper();
        restMockMvc.perform(
            post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsBytes(invalidUser)))
            .andExpect(status().isBadRequest());

    }

    @Test
    public void registerWithValidParamTest() throws Exception {
        UserEntity invalidUser = new UserEntity();
        invalidUser.setUsername("liuyatao");
        invalidUser.setNickname("lyt");
        ObjectMapper mapper =new ObjectMapper();
        restMockMvc.perform(
            post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsBytes(invalidUser)))
            .andDo(print())
            .andExpect(status().isCreated());
    }

    @Test
    public void getUserByIdTest() throws Exception {
        UserEntity user =new UserEntity();
        user.setUsername("liuyatao");
        user.setNickname("lyt");
        //调用mockUserService的 getUserById方法，不管任何参数都返回user对象
        when(mockUserService.getUserById(anyInt())).thenReturn(user);
        restMockMvc.perform(
            get("/user/1")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.username").value("liuyatao"));
        
    }
}