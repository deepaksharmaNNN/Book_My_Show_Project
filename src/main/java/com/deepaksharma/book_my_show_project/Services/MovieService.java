package com.deepaksharma.book_my_show_project.Services;

import com.deepaksharma.book_my_show_project.Entities.Movie;
import com.deepaksharma.book_my_show_project.Repository.MovieRepository;
import com.deepaksharma.book_my_show_project.RequestDTOs.AddMovieRequest;
import com.deepaksharma.book_my_show_project.Transformers.MovieTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public String addMovie(AddMovieRequest addMovieRequest){
        Movie movie = MovieTransformer.convertMovieRequestToMovieEntity(addMovieRequest);
        movieRepository.save(movie);
        return "Movie added successfully With ID: "+movie.getMovieId();
    }
}
