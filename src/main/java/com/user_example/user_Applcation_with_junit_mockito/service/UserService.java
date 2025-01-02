package com.user_example.user_Applcation_with_junit_mockito.service;

import com.user_example.user_Applcation_with_junit_mockito.repo.UserRepository;
import com.user_example.user_Applcation_with_junit_mockito.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public UserModel createUserInfo(UserModel userModel) {

        return userRepository.save(userModel);
    }

    public List<UserModel> createListUserInfo(List<UserModel> userModel) {

        return userRepository.saveAll(userModel);
    }

    public UserModel getUserInfo(Long id) {
        return userRepository.findById(id).get();
    }

    public List<UserModel> getListUserInfo() {

        return userRepository.findAll();
    }


    public UserModel updateUser(Long id, UserModel userModel) {

        UserModel existingUserUpdate = userRepository.findById(id).orElse(null);

        if (existingUserUpdate!=null) {

            existingUserUpdate.setFirstName(userModel.getFirstName());
            existingUserUpdate.setLastName(userModel.getLastName());
            existingUserUpdate.setEmail(userModel.getEmail());
            existingUserUpdate.setPassword(userModel.getPassword());

            return userRepository.save(existingUserUpdate);
        } else {
            return null;
        }
    }


    public boolean deleteUser(Long id) {
        UserModel existingUserDelete = userRepository.findById(id).orElse(null);

            if (existingUserDelete != null) {
                userRepository.delete(existingUserDelete);
                return true;
            }
            else {

                return false;
            }
        }
}


