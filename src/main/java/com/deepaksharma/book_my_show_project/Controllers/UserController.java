package com.deepaksharma.book_my_show_project.Controllers;

import com.deepaksharma.book_my_show_project.RequestDTOs.AddUserRequest;
import com.deepaksharma.book_my_show_project.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public String addUser(@RequestBody AddUserRequest addUserRequest){
        return userService.addUser(addUserRequest);
    }

    @GetMapping("/getUser")
    public ResponseEntity<String> getUser(@RequestParam String emailId){
        try {
            String result = userService.getUser(emailId);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
