package com.deepaksharma.book_my_show_project.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "shows")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showId;

    private LocalDate showDate;

    private LocalTime showTime;

    @JoinColumn
    @ManyToOne
    @JsonIgnore
    private Movie movie;

    @JoinColumn
    @ManyToOne
    @JsonIgnore
    private Theater theater;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<ShowSeat> showSeatsList = new ArrayList<>();

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<Ticket> tickets = new ArrayList<>();

    public Show(LocalDate showDate, LocalTime showTime) {
        this.showDate = showDate;
        this.showTime = showTime;
    }
}
