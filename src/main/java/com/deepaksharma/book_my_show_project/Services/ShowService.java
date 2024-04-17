package com.deepaksharma.book_my_show_project.Services;

import com.deepaksharma.book_my_show_project.CustomException.InvalidMovieException;
import com.deepaksharma.book_my_show_project.CustomException.InvalidTheaterException;
import com.deepaksharma.book_my_show_project.Entities.Movie;
import com.deepaksharma.book_my_show_project.Entities.Show;
import com.deepaksharma.book_my_show_project.Entities.Theater;
import com.deepaksharma.book_my_show_project.Repository.MovieRepository;
import com.deepaksharma.book_my_show_project.Repository.ShowRepository;
import com.deepaksharma.book_my_show_project.Repository.TheaterRepository;
import com.deepaksharma.book_my_show_project.RequestDTOs.AddShowRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return "Show added successfully";
    }
}
