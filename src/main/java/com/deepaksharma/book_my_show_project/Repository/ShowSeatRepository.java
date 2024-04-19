package com.deepaksharma.book_my_show_project.Repository;

import com.deepaksharma.book_my_show_project.Entities.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer> {
}
