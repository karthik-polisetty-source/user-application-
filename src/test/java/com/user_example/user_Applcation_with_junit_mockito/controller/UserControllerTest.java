package com.user_example.user_Applcation_with_junit_mockito.controller;

//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.user_example.user_Applcation_with_junit_mockito.contoller.UserController;
//import com.user_example.user_Applcation_with_junit_mockito.model.UserModel;
//import com.user_example.user_Applcation_with_junit_mockito.service.UserService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//
//
//
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//
//@ExtendWith(MockitoExtension.class)
//public class UserControllerTest {
//
//    private MockMvc mockMvc;
//
//    @InjectMocks
//    private UserController userController;
//
//    @Mock
//    private UserService userService;
//
//    @BeforeEach
//    public void setUp() {
//
//        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
//    }
//
//    @Test
//    public void CreateUserInfoTest() throws Exception{
//
//       UserModel inputUser =new UserModel();
//       inputUser.setEmail("john.deo@gmail.com");
//       inputUser.setPassword(123645L);
//       inputUser.setFirstName("john");
//       inputUser.setLastName("deo");
//
//       when(userService.createUserInfo(any(UserModel.class))).thenReturn(inputUser);
//
//        mockMvc.perform(post("/user-model/create")
//
//                        .contentType(MediaType.APPLICATION_JSON)
//                .content((new ObjectMapper()).writeValueAsString(inputUser)))
//                .andExpect(status().isCreated());
//
//    }
//}


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.user_example.user_Applcation_with_junit_mockito.model.UserModel;
import com.user_example.user_Applcation_with_junit_mockito.repo.UserRepository;
import com.user_example.user_Applcation_with_junit_mockito.service.UserService;
import com.user_example.user_Applcation_with_junit_mockito.contoller.UserController;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.BDDAssumptions.given;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@ExtendWith(MockitoExtension.class)

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class UserControllerTest {
//
//    @InjectMocks
//    private UserController userController;
//
//    @Mock
//    private UserService userService;
//
//    private MockMvc mockMvc;
//
//
//    @BeforeEach
//    public void setUp(){
//        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
//    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @BeforeEach
    public void setUp(){

        UserModel testUser = new UserModel();
        testUser.setId(1L);
        testUser.setPassword(125485L);
        testUser.setEmail("mkie.swo@gmail.com");
        testUser.setFirstName("mkie");
        testUser.setLastName("swo");

    }

    @Test

    public void createUserInfoTest() throws Exception{

        UserModel inputUser = new UserModel();
        inputUser.setEmail("john.deo@gmail.com");
         inputUser.setPassword(123645L);
        inputUser.setFirstName("john");
         inputUser.setLastName("deo");

//        when(userService.createUserInfo(any(UserModel.class))).thenReturn(inputUser);

//        when(userService.createUserInfo(inputUser)).thenReturn(inputUser);

        mockMvc.perform(post("/usermodel/createuser")
                        .content(objectMapper.writeValueAsString(inputUser))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName").value("john"))
                .andExpect(jsonPath("$.lastName").value("deo"))
                .andExpect(jsonPath("$.password").value(123645L))
                .andExpect(jsonPath("$.email").value("john.deo@gmail.com"))
        ;



    }

    @Test

    public void createListUserInfoTest() throws Exception{

        UserModel user1 = new UserModel();
        user1.setEmail("momn.deo@gmail.com");
        user1.setPassword(123645L);
        user1.setFirstName("momn");
        user1.setLastName("deo");


        UserModel user2 = new UserModel();
        user2.setLastName("kio");
        user2.setFirstName("mone");
        user2.setEmail("mone.kio@gmail.com");
        user2.setPassword(154887L);

        UserModel user3 = new UserModel();
        user3.setPassword(169875L);
        user3.setFirstName("meow");
        user3.setLastName("sei");
        user3.setEmail("meow.sei@gmail.com");


        List<UserModel> createList = List.of(user1,user2,user3);

//        when(userService.createListUserInfo(anyList())).thenReturn(createList);

        mockMvc.perform(post("/usermodel/createlistusers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content((objectMapper).writeValueAsString(createList)))
                .andExpect(status().isCreated());


    }

    @Test
    public void getUserInfoTest() throws Exception{

        mockMvc.perform(get("/usermodel/get/{id}",1L))
//                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void getListUserInfoTest() throws Exception{

        mockMvc.perform(get("/usermodel/get/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void updateUserSuccessTest() throws Exception{

        UserModel updateUser = new UserModel();
        updateUser.setEmail("kiwr.wew@gmail.com");
        updateUser.setFirstName("kiwr");
        updateUser.setPassword(123645L);
        updateUser.setLastName("wew");
        updateUser.setId(1L);

//        when(userService.updateUser(userId, updateUser)).thenReturn(updateUser);

        mockMvc.perform(put("/usermodel/update/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content((new ObjectMapper()).writeValueAsString(updateUser)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("kiwr.wew@gmail.com"))
                .andExpect(jsonPath("$.firstName").value("kiwr"))
                .andExpect(jsonPath("$.lastName").value("wew"))
                .andExpect(jsonPath("$.password").value(123645L));

    }

    @Test
    public void updateUserNotFoundTest() throws Exception{

        UserModel updateUser = new UserModel();
        updateUser.setEmail("kiwr.wew@gmail.com");
        updateUser.setFirstName("kiwr");

//        when(userService.updateUser(userId, updateUser)).thenReturn(null);

        mockMvc.perform(put("/usermodel/update/{id}",5L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateUser)))
                .andExpect(status().isNotFound());

    }


    @Test
    public void deleteUserNoContentTest() throws Exception{


//        when(userService.deleteUser(userId)).thenReturn(true);

        mockMvc.perform(delete("/usermodel/delete/{id}",2L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }


    @Test
    public void deleteUserNotFound() throws Exception{

        Long userId =6L;

//        when(userService.deleteUser(userId)).thenReturn(false);

        mockMvc.perform(delete("/usermodel/delete/{id}",6L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}




