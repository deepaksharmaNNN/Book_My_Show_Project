package com.deepaksharma.book_my_show_project.Transformers;

import com.deepaksharma.book_my_show_project.Entities.Movie;
import com.deepaksharma.book_my_show_project.RequestDTOs.AddMovieRequest;

public class MovieTransformer {
    public static Movie convertMovieRequestToMovieEntity(AddMovieRequest addMovieRequest){
        return Movie.builder()
                .movieName(addMovieRequest.getMovieName())
                .genre(addMovieRequest.getGenre())
                .rating(addMovieRequest.getRating())
                .language(addMovieRequest.getLanguage())
                .releaseDate(addMovieRequest.getReleaseDate())
                .duration(addMovieRequest.getDuration())
                .build();
    }
}
