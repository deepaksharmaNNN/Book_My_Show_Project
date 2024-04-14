package com.deepaksharma.book_my_show_project.RequestDTOs;


import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data

public class AddShowRequest {
    private LocalDate showDate;

    private LocalTime showTime;

    private String movieName;

   private int theaterId;
}
