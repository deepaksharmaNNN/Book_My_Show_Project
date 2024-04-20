package com.deepaksharma.book_my_show_project.Response;

import com.deepaksharma.book_my_show_project.Enums.SeatType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShowTicketResponse {
    private String movieName;
    private String theaterInfo;
    private LocalDate showDate;
    private LocalTime showTime;
    private int totalAmount;
    private String seatNumber;
    private SeatType seatType;
}
