package com.deepaksharma.book_my_show_project.Services;

import com.deepaksharma.book_my_show_project.CustomException.InvalidMovieException;
import com.deepaksharma.book_my_show_project.CustomException.InvalidTheaterException;
import com.deepaksharma.book_my_show_project.Entities.*;
import com.deepaksharma.book_my_show_project.Enums.SeatType;
import com.deepaksharma.book_my_show_project.Repository.MovieRepository;
import com.deepaksharma.book_my_show_project.Repository.ShowRepository;
import com.deepaksharma.book_my_show_project.Repository.TheaterRepository;
import com.deepaksharma.book_my_show_project.RequestDTOs.AddShowRequest;
import com.deepaksharma.book_my_show_project.RequestDTOs.AddShowSeatsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    public String addShow(AddShowRequest addShowRequest) throws Exception {
        Movie movie = movieRepository.findByMovieName(addShowRequest.getMovieName());
        if(movie == null){
            throw new InvalidMovieException("Movie not found in the database");
        }
        Optional<Theater> theaterOptional = theaterRepository.findById(addShowRequest.getTheaterId());
        if(theaterOptional.isEmpty()){
            throw new InvalidTheaterException("Theater not found in the database");
        }
        Theater theater = theaterOptional.get();
        Show showEntity = new Show(addShowRequest.getShowDate(), addShowRequest.getShowTime());
        showEntity.setMovie(movie);
        showEntity.setTheater(theater);

        //For Bidirectional Mapping
        movie.getShowList().add(showEntity);
        theater.getShowList().add(showEntity);
        showEntity = showRepository.save(showEntity);
        return "Show added successfully with showId: "+showEntity.getShowId();
    }

    public String addShowSeats(AddShowSeatsRequest addShowSeatsRequest) {
        Show show = showRepository.findById(addShowSeatsRequest.getShowId()).get();
        Theater theater = show.getTheater();
        List<TheaterSeat> theaterSeatsList = theater.getTheaterSeatsList();
        List<ShowSeat> showSeatsList = new ArrayList<>();
        for(TheaterSeat theaterSeat : theaterSeatsList){
            String seatNumber = theaterSeat.getSeatNumber();
            SeatType seatType = theaterSeat.getSeatType();

            ShowSeat showSeat = ShowSeat.builder()
                    .foodIncluded(false)
                    .isAvailable(false)
                    .show(show)
                    .seatNumber(seatNumber)
                    .seatType(seatType)
                    .build();
            if(seatType.equals(SeatType.CLASSIC)){
                showSeat.setPrice(addShowSeatsRequest.getPriceOfClassicSeats());
            }else {
                showSeat.setPrice(addShowSeatsRequest.getPriceOfPremiumSeats());
            }
            showSeatsList.add(showSeat);
        }
        show.setShowSeatsList(showSeatsList);
        showRepository.save(show);
        return "Show Seats added successfully for showId: "+show.getShowId();
    }
}
