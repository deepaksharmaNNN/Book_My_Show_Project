package com.deepaksharma.book_my_show_project.Entities;

import com.deepaksharma.book_my_show_project.Enums.Genre;
import com.deepaksharma.book_my_show_project.Enums.Language;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String movieId;


    @Column(unique = true, nullable = false, length = 100)
    private String movieName;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @Enumerated(value = EnumType.STRING)
    private Language language;

    private LocalDate releaseDate;

    private Double duration;


}
