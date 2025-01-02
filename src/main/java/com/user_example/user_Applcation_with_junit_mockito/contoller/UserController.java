package com.user_example.user_Applcation_with_junit_mockito.contoller;


import com.user_example.user_Applcation_with_junit_mockito.model.UserModel;
import com.user_example.user_Applcation_with_junit_mockito.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/usermodel")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/createuser")
    public ResponseEntity<UserModel> createUserInfo(@RequestBody UserModel userModel){

        return new ResponseEntity<>(userService.createUserInfo(userModel),HttpStatus.CREATED);
    }

    @PostMapping("/createlistusers")
    public ResponseEntity<List<UserModel>> createListUserInfo(@RequestBody List<UserModel> userModel){

        return new ResponseEntity<>(userService.createListUserInfo(userModel),HttpStatus.CREATED) ;
    }

     @GetMapping("/get/{id}")
    public ResponseEntity<UserModel> getUserInfo(@PathVariable Long id){

        return new ResponseEntity<>(userService.getUserInfo(id),HttpStatus.OK);
    }

    @GetMapping("/get/list")
    public ResponseEntity<List<UserModel>> getListUserInfo(){

        return new ResponseEntity<>(userService.getListUserInfo(),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserModel> updateUser(@PathVariable Long id, @RequestBody UserModel userModel) {
        UserModel updatedUser = userService.updateUser(id, userModel);

        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        boolean isDeleted = userService.deleteUser(id);

        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
