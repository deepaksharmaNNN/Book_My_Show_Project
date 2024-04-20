package com.deepaksharma.book_my_show_project.Services;

import com.deepaksharma.book_my_show_project.Entities.Show;
import com.deepaksharma.book_my_show_project.Entities.ShowSeat;
import com.deepaksharma.book_my_show_project.Entities.Ticket;
import com.deepaksharma.book_my_show_project.Entities.User;
import com.deepaksharma.book_my_show_project.Enums.Availability;
import com.deepaksharma.book_my_show_project.Repository.ShowRepository;
import com.deepaksharma.book_my_show_project.Repository.TicketRepository;
import com.deepaksharma.book_my_show_project.Repository.UserRepository;
import com.deepaksharma.book_my_show_project.RequestDTOs.BookTicketRequest;
import com.deepaksharma.book_my_show_project.Response.ShowTicketResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private UserRepository userRepository;

    int totalBookingAmount = 0;
    public String bookTicket(BookTicketRequest bookTicketRequest) throws Exception {
        Show show = showRepository.findById(bookTicketRequest.getShowId()).get();
        List<ShowSeat> showSeatList = show.getShowSeatsList();
        for(String seatNumberToBeBooked : bookTicketRequest.getSeatList()){
            for(ShowSeat showSeat : showSeatList){
                if(showSeat.getSeatNumber().equals(seatNumberToBeBooked) && showSeat.getSeatType().equals(bookTicketRequest.getSeatType())){
                    if(showSeat.getIsAvailable().equals(Availability.TRUE)){
                        showSeat.setIsAvailable(Availability.FALSE);
                        totalBookingAmount += showSeat.getPrice();
                    }else{
                        throw new Exception("Seat is already booked: " + showSeat.getSeatNumber());
                    }

                }
            }
        }
        User user = userRepository.findByEmailId(bookTicketRequest.getEmailId());
        //All the seats were available and now they are booked

        Ticket ticket = Ticket.builder()
                .seatNumbersBooked(generateBookedSeats(bookTicketRequest.getSeatList()))
                .totalAmountPaid(totalBookingAmount)
                .show(show)
                .user(user)
                .build();

        show.getTickets().add(ticket);
        user.getTicketList().add(ticket);
        ticketRepository.save(ticket);
        return "Ticket booked successfully: " + ticket.getTicketId();
    }
    private String generateBookedSeats(List<String> bookedSeats){
        return bookedSeats.toString();
    }
    public ShowTicketResponse viewTicket(Integer ticketId){
        Ticket ticket = ticketRepository.findById(ticketId).get();
        Show show = ticket.getShow();
        String movieName = show.getMovie().getMovieName();
        String theaterInfo = show.getTheater().getTheaterName() + " " + show.getTheater().getAddress();
        String seatNumbersBooked = ticket.getSeatNumbersBooked();
        LocalDate showDate = show.getShowDate();
        LocalTime showTime = show.getShowTime();
        int totalAmount = ticket.getTotalAmountPaid();
        ShowTicketResponse showTicketResponse=  ShowTicketResponse.builder()
                .movieName(movieName)
                .theaterInfo(theaterInfo)
                .seatNumber(seatNumbersBooked)
                .totalAmount(totalAmount)
                .build();
        String emailId = ticket.getUser().getEmailId();
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("email@email.com");
        simpleMailMessage.setTo(emailId);
        simpleMailMessage.setSubject("Ticket Details");
        simpleMailMessage.setText("Movie Name: "+movieName+"\n"+
                "Theater Info: "+theaterInfo+"\n"+
                "Seat Number: "+seatNumbersBooked+"\n"+
                "Show Date: "+showDate+"\n"+
                "Show Time: "+showTime+"\n"+
                "Total Amount: "+totalAmount);
        javaMailSender.send(simpleMailMessage);
        return showTicketResponse;
    }
}
