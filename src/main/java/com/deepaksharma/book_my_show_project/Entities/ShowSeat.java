package com.deepaksharma.book_my_show_project.Entities;

import com.deepaksharma.book_my_show_project.Enums.Availability;
import com.deepaksharma.book_my_show_project.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "show_seats")
public class ShowSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showSeatId;

    private Integer price;

    @Enumerated(value = EnumType.STRING)
    private Availability isAvailable;

    private Boolean foodIncluded;

    private String seatNumber;
    //will get these values from mappings;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    @JoinColumn
    @ManyToOne
    private Show show;
}
