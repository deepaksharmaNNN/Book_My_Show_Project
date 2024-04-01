package com.deepaksharma.book_my_show_project.Services;

import com.deepaksharma.book_my_show_project.Entities.Movie;
import com.deepaksharma.book_my_show_project.RequestDTOs.AddMovieRequest;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    public String addMovie(AddMovieRequest addMovieRequest){
        Movie movie = Movie.builder()
                .movieName(addMovieRequest.getMovieName())
                .genre(addMovieRequest.getGenre())
                .language(addMovieRequest.getLanguage())
                .releaseDate(addMovieRequest.getReleaseDate())
                .duration(addMovieRequest.getDuration())
                .build();
    }
}
