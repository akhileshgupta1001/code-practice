package com.machine.coding.bookmyshow.repositories;

import com.machine.coding.bookmyshow.models.Show;
import com.machine.coding.bookmyshow.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType,Long> {

    List<ShowSeatType> findAllByShow(Show show);


}
