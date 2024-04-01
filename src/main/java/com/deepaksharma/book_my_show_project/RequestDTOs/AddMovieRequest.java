package com.deepaksharma.book_my_show_project.RequestDTOs;

import com.deepaksharma.book_my_show_project.Enums.Genre;
import com.deepaksharma.book_my_show_project.Enums.Language;
import lombok.Data;


import java.time.LocalDate;
@Data
public class AddMovieRequest {
    private String movieName;

    private Genre genre;

    private Language language;

    private LocalDate releaseDate;

    private Double duration;
}
