package com.user_example.user_Applcation_with_junit_mockito.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="User_Table")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String firstName;
    private String email;
    private String lastName;
    private Long password;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public int getPassword() {
//        return password;
//    }
//
//    public void setPassword(int password) {
//        this.password = password;
//    }
//
//    public UserModel() {
//    }
//
//    public UserModel(Long id, String firstName, String email, String lastName, int password) {
//        this.id = id;
//        this.firstName = firstName;
//        this.email = email;
//        this.lastName = lastName;
//        this.password = password;
//    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password=" + password +
                '}';
    }
}
