package com.machine.coding.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookMovieResponseDto {
    private Long bookingId;
    private ResponseStatus responseStatus;

}
