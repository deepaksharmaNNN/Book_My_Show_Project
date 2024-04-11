package com.deepaksharma.book_my_show_project.RequestDTOs;

import lombok.Data;

@Data
public class AddTheaterSeatsRequest {
    private int noOfClassicSeats;
    private int noOfPremiumSeats;
    private int theaterId;
}
