package com.machine.coding.bookmyshow.service;

import com.machine.coding.bookmyshow.models.Show;
import com.machine.coding.bookmyshow.models.ShowSeat;
import com.machine.coding.bookmyshow.models.ShowSeatType;
import com.machine.coding.bookmyshow.repositories.ShowSeatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculatorService  {

    @Autowired
    private ShowSeatTypeRepository showSeatTypeRepository;
    public int calculatePrice(List<ShowSeat> showSeats, Show show) {
        List<ShowSeatType>  showSeatTypes = showSeatTypeRepository.findAllByShow(show);
        int amount = 0;
        for (ShowSeat showSeat : showSeats) { // 10
            for (ShowSeatType showSeatType : showSeatTypes) { // 4
                if (showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())) {
                    amount += showSeatType.getPrice();
                    break;
                }
            }
        }

        return amount;

    }
}
