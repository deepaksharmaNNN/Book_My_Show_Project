package com.deepaksharma.book_my_show_project.Controllers;

import com.deepaksharma.book_my_show_project.RequestDTOs.BookTicketRequest;
import com.deepaksharma.book_my_show_project.Response.ShowTicketResponse;
import com.deepaksharma.book_my_show_project.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping("/bookTicket")
    public ResponseEntity<String> bookTicket(@RequestBody BookTicketRequest bookTicketRequest){
        try {
            String result = ticketService.bookTicket(bookTicketRequest);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/viewTicket")
    public ShowTicketResponse viewTicket(@RequestParam Integer ticketId){
        return ticketService.viewTicket(ticketId);
    }
}
