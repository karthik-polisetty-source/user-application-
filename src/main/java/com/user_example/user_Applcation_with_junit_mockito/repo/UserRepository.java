package com.user_example.user_Applcation_with_junit_mockito.repo;

import com.user_example.user_Applcation_with_junit_mockito.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel,Long> {
}
