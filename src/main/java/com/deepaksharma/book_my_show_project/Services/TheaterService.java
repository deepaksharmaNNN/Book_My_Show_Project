package com.deepaksharma.book_my_show_project.Services;

import com.deepaksharma.book_my_show_project.Entities.Theater;
import com.deepaksharma.book_my_show_project.Entities.TheaterSeat;
import com.deepaksharma.book_my_show_project.Enums.SeatType;
import com.deepaksharma.book_my_show_project.Repository.TheaterRepository;
import com.deepaksharma.book_my_show_project.RequestDTOs.AddTheaterRequest;
import com.deepaksharma.book_my_show_project.RequestDTOs.AddTheaterSeatsRequest;
import com.deepaksharma.book_my_show_project.Transformers.TheaterTransformer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {
    private final TheaterRepository theaterRepository;

    public TheaterService(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    public String addTheater(AddTheaterRequest addTheaterRequest){
        Theater theater = TheaterTransformer.convertTheaterRequestToTheaterEntity(addTheaterRequest);
        theaterRepository.save(theater);
        return "Theater added successfully With ID: "+theater.getTheaterId();
    }
    public String addTheaterSeats(AddTheaterSeatsRequest addTheaterSeatsReq){
        int noOfClassicSeats = addTheaterSeatsReq.getNoOfClassicSeats();
        int noOfPremiumSeats = addTheaterSeatsReq.getNoOfPremiumSeats();

        Theater theater = theaterRepository.findById(addTheaterSeatsReq.getTheaterId()).get();

        int quoClassic = noOfClassicSeats/5;
        int remClassic = noOfClassicSeats%5;

        List<TheaterSeat> theaterSeatList = new ArrayList<>();

        for(int row = 1; row<=quoClassic; row++){
            for(int col = 1; col<=5; col++){
                char ch = (char) ('A' + (col - 1));
                String seatNo = row+""+ch;

                TheaterSeat theaterSeatEntity = TheaterSeat.builder()
                        .seatNumber(seatNo)
                        .seatType(SeatType.CLASSIC)
                        .theater(theater)
                        .build();
                theaterSeatList.add(theaterSeatEntity);
            }
        }

        int rowNoForRemainder = quoClassic+1;

        for (int col = 1; col<=remClassic; col++){
            char ch = (char) ('A' + (col - 1));
            String seatNo = rowNoForRemainder+""+ch;

            TheaterSeat theaterSeatEntity = TheaterSeat.builder()
                    .seatNumber(seatNo)
                    .seatType(SeatType.CLASSIC)
                    .theater(theater)
                    .build();
            theaterSeatList.add(theaterSeatEntity);
        }

        int quoPremium = noOfPremiumSeats/5;
        int remPremium = noOfPremiumSeats%5;

        for(int row = 1; row<=quoPremium; row++){
            for(int col = 1; col<=5; col++){
                char ch = (char) ('A' + (col - 1));
                String seatNo = row+""+ch;

                TheaterSeat theaterSeatEntity = TheaterSeat.builder()
                        .seatNumber(seatNo)
                        .seatType(SeatType.PREMIUM)
                        .theater(theater)
                        .build();
                theaterSeatList.add(theaterSeatEntity);
            }
        }
        rowNoForRemainder = quoPremium+1;

        for (int col = 1; col<=remPremium; col++){
            char ch = (char) ('A' + (col - 1));
            String seatNo = rowNoForRemainder+""+ch;

            TheaterSeat theaterSeatEntity = TheaterSeat.builder()
                    .seatNumber(seatNo)
                    .seatType(SeatType.PREMIUM)
                    .theater(theater)
                    .build();
            theaterSeatList.add(theaterSeatEntity);
        }
        return "Seats added successfully";
    }

}
