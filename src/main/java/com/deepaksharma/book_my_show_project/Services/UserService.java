package com.deepaksharma.book_my_show_project.Services;

import com.deepaksharma.book_my_show_project.Entities.User;
import com.deepaksharma.book_my_show_project.Repository.UserRepository;
import com.deepaksharma.book_my_show_project.RequestDTOs.AddUserRequest;
import com.deepaksharma.book_my_show_project.Response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String addUser(AddUserRequest addUserRequest) {
        User user = User.builder()
                .name(addUserRequest.getName())
                .emailId(addUserRequest.getEmailId())
                .build();
        userRepository.save(user);
        return "User added with id: " + user.getUserId();
    }
    public String getUser(String emailId){
        String name = userRepository.findByEmailId(emailId).getName();
        int userId = userRepository.findByEmailId(emailId).getUserId();
        UserResponse userResponse = UserResponse.builder()
                .userId(userId)
                .name(name)
                .emailId(emailId)
                .build();
        return "User Id: " + userResponse.getUserId() + "\n" +
                "Name: " + userResponse.getName() + "\n" +
                "Email Id: " + userResponse.getEmailId();
    }
}
