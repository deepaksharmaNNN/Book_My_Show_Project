package com.deepaksharma.book_my_show_project.Services;

import com.deepaksharma.book_my_show_project.Entities.User;
import com.deepaksharma.book_my_show_project.Repository.UserRepository;
import com.deepaksharma.book_my_show_project.RequestDTOs.AddUserRequest;
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
}
