package com.deepaksharma.book_my_show_project.Repository;

import com.deepaksharma.book_my_show_project.Entities.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Integer> {
}
