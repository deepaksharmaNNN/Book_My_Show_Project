package com.deepaksharma.book_my_show_project.Controllers;

import com.deepaksharma.book_my_show_project.RequestDTOs.AddShowRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shows")
public class ShowController {
    @PostMapping("/addShow")
    public String addShow(@RequestBody AddShowRequest addShowRequest){
        return "Show added successfully";
    }
}
