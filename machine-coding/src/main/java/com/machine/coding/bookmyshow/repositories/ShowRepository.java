package com.machine.coding.bookmyshow.repositories;

import com.machine.coding.bookmyshow.models.Show;
import com.machine.coding.bookmyshow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShowRepository extends JpaRepository<Show,Long> {

    @Override
    Optional<Show> findById(Long showId);
}
