package com.deepaksharma.book_my_show_project.Services;

import com.deepaksharma.book_my_show_project.Repository.TicketRepository;
import com.deepaksharma.book_my_show_project.RequestDTOs.BookTicketRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public String bookTicket(BookTicketRequest bookTicketRequest){
        return null;
    }
}
