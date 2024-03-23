package com.machine.coding.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "seats")
public class Seat extends BaseModel {
    private int rowVal ;
    private int colVal;
    private String number;
    @ManyToOne
    private SeatType seatType;

    @ManyToOne
    private Screen screen;
}
