package com.deepaksharma.book_my_show_project.Controllers;

import com.deepaksharma.book_my_show_project.RequestDTOs.AddTheaterRequest;
import com.deepaksharma.book_my_show_project.RequestDTOs.AddTheaterSeatsRequest;
import com.deepaksharma.book_my_show_project.Services.TheaterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theater")
public class TheaterController {
    private final TheaterService theaterService;

    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @PostMapping("/addTheater")
    public ResponseEntity<String> addTheater(@RequestBody AddTheaterRequest addTheaterRequest){
        String result = theaterService.addTheater(addTheaterRequest);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

//    @PostMapping("/addTheaterSeats")
//    public ResponseEntity<String> addTheaterSeats(@RequestBody AddTheaterSeatsRequest addTheaterSeatsRequest){
//        String result = theaterService.addTheaterSeats(addTheaterRequest);
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }
}
