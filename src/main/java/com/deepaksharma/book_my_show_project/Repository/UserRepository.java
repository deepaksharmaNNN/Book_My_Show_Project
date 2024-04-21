package com.deepaksharma.book_my_show_project.Repository;

import com.deepaksharma.book_my_show_project.Entities.User;
import com.deepaksharma.book_my_show_project.Response.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmailId(String emailId);

//    @Query(value = "select name, email_id from User where email_id := emailId;", nativeQuery = true)
//    UserResponse CustomMethodName(String emailId);
}
