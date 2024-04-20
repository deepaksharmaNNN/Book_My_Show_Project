package com.deepaksharma.book_my_show_project.Controllers;

import com.deepaksharma.book_my_show_project.RequestDTOs.AddUserRequest;
import com.deepaksharma.book_my_show_project.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public String addUser(@RequestBody AddUserRequest addUserRequest){
        return userService.addUser(addUserRequest);
    }
}
