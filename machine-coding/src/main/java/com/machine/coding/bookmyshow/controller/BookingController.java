package com.machine.coding.bookmyshow.controller;

import com.machine.coding.bookmyshow.dtos.BookMovieResponseDto;
import com.machine.coding.bookmyshow.dtos.BookingMovieRequestDto;
import com.machine.coding.bookmyshow.dtos.ResponseStatus;
import com.machine.coding.bookmyshow.exception.ShowNotFoundException;
import com.machine.coding.bookmyshow.exception.ShowSeatNotAvailableException;
import com.machine.coding.bookmyshow.exception.UserNotFoundException;
import com.machine.coding.bookmyshow.models.Booking;
import com.machine.coding.bookmyshow.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class BookingController {
    @Autowired
    private BookingService bookingService;


    @PostMapping("/weather")
    public BookMovieResponseDto bookTicket(BookingMovieRequestDto requestDto) {
        BookMovieResponseDto responseDto = new BookMovieResponseDto();
        try {
            Booking booking = bookingService.bookTicket(requestDto.getUserId(),
                    requestDto.getShowId(),
                    requestDto.getShowSeatIds());
            responseDto.setBookingId(booking.getId());
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
    /*

    public ResponseEntity<> bookTicket(BookingMovieRequestDto requestDto) {
        BookMovieResponseDto responseDto = new BookMovieResponseDto();
        try {
            Booking booking = bookingService.bookTicket(requestDto.getUserId(),
                    requestDto.getShowId(),
                    requestDto.getShowSeatIds());
            responseDto.setBookingId(booking.getId());
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
       return ResponseEntity<BookingMovieRequestDto,Htt>
    }
    */


}
