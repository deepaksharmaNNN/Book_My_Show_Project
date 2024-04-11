package com.deepaksharma.book_my_show_project.Services;

import com.deepaksharma.book_my_show_project.Entities.Theater;
import com.deepaksharma.book_my_show_project.Repository.TheaterRepository;
import com.deepaksharma.book_my_show_project.RequestDTOs.AddTheaterRequest;
import com.deepaksharma.book_my_show_project.Transformers.TheaterTransformer;
import org.springframework.stereotype.Service;

@Service
public class TheaterService {
    private final TheaterRepository theaterRepository;

    public TheaterService(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    public String addTheater(AddTheaterRequest addTheaterRequest){
        Theater theater = TheaterTransformer.convertTheaterRequestToTheaterEntity(addTheaterRequest);
        theaterRepository.save(theater);
        return "Theater added successfully With ID: "+theater.getTheaterId();
    }

}
