package com.deepaksharma.book_my_show_project.Services;

import com.deepaksharma.book_my_show_project.Entities.Show;
import com.deepaksharma.book_my_show_project.Entities.ShowSeat;
import com.deepaksharma.book_my_show_project.Entities.Ticket;
import com.deepaksharma.book_my_show_project.Repository.ShowRepository;
import com.deepaksharma.book_my_show_project.Repository.TicketRepository;
import com.deepaksharma.book_my_show_project.RequestDTOs.BookTicketRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ShowRepository showRepository;


    int totalBookingAmount = 0;
    public String bookTicket(BookTicketRequest bookTicketRequest) throws Exception {
        Show show = showRepository.findById(bookTicketRequest.getShowId()).get();
        List<ShowSeat> showSeatList = show.getShowSeatsList();
        for(String seatNumberToBeBooked : bookTicketRequest.getSeatList()){
            for(ShowSeat showSeat : showSeatList){
                if(showSeat.getSeatNumber().equals(seatNumberToBeBooked) && showSeat.getSeatType().equals(bookTicketRequest.getSeatType())){
                    if(showSeat.getIsAvailable()){
                        showSeat.setIsAvailable(Boolean.FALSE);
                        totalBookingAmount += showSeat.getPrice();
                    }else {
                        throw new Exception("Seat is already booked" + showSeat.getSeatNumber());
                    }

                }
            }
        }
        //All the seats were available and now they are booked

        Ticket ticket = Ticket.builder()
                .seatNumbersBooked(generateBookedSeats(bookTicketRequest.getSeatList()))
                .totalAmountPaid(totalBookingAmount)
                .show(show)
                .build();

        show.getTickets().add(ticket);
        ticketRepository.save(ticket);
        return "Ticket booked successfully: " + ticket.getTicketId();
    }
    private String generateBookedSeats(List<String> bookedSeats){
        return bookedSeats.toString();
    }
}
