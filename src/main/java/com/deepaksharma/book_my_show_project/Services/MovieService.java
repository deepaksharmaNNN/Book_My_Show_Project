package com.deepaksharma.book_my_show_project.Services;

import com.deepaksharma.book_my_show_project.RequestDTOs.AddMovieRequest;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    public String addMovie(AddMovieRequest addMovieRequest){
        return "Movie added successfully";
    }
}
