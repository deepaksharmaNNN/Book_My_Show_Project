package com.deepaksharma.book_my_show_project.Services;

import com.deepaksharma.book_my_show_project.Entities.Theater;
import com.deepaksharma.book_my_show_project.Repository.TheaterRepository;
import com.deepaksharma.book_my_show_project.RequestDTOs.AddTheaterRequest;
import com.deepaksharma.book_my_show_project.Transformers.TheaterTransformer;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;

    public String addTheater(AddTheaterRequest addTheaterRequest){
        Theater theater = TheaterTransformer.convertTheaterRequestToTheaterEntity(addTheaterRequest);
        theaterRepository.save(theater);
        return "Theater added successfully With ID: "+theater.getTheaterId();
    }
}
