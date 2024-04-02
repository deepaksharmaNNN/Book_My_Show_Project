package com.deepaksharma.book_my_show_project.Repository;

import com.deepaksharma.book_my_show_project.Entities.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, Integer> {
}
