package com.deepaksharma.book_my_show_project.Controllers;

import com.deepaksharma.book_my_show_project.RequestDTOs.AddTheaterRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theater")
public class TheaterController {
    @PostMapping("/addTheater")
    public String addTheater(@RequestBody AddTheaterRequest addTheaterRequest){
        return "Theater added successfully";
    }
}
