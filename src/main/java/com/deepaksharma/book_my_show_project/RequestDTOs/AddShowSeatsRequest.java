package com.deepaksharma.book_my_show_project.RequestDTOs;

import lombok.Data;

@Data
public class AddShowSeatsRequest {
    private int priceOfPremiumSeats;
    private int priceOfClassicSeats;
    private int showId;

}
