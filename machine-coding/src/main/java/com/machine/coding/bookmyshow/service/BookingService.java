package com.machine.coding.bookmyshow.service;

import com.machine.coding.bookmyshow.exception.ShowNotFoundException;
import com.machine.coding.bookmyshow.exception.ShowSeatNotAvailableException;
import com.machine.coding.bookmyshow.exception.UserNotFoundException;
import com.machine.coding.bookmyshow.models.*;
import com.machine.coding.bookmyshow.repositories.BookingRepository;
import com.machine.coding.bookmyshow.repositories.ShowRepository;
import com.machine.coding.bookmyshow.repositories.ShowSeatRepository;
import com.machine.coding.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
     private ShowSeatRepository showSeatRepository;

    @Autowired
    private PriceCalculatorService priceCalculatorService;

    @Autowired
    private BookingRepository bookingRepository;




    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookTicket(Long userId, Long showId, List<Long> showSeatIds) throws UserNotFoundException, ShowNotFoundException, ShowSeatNotAvailableException {

        /*
        -------TODAY WE'LL HAVE LOCK ON THE COMPLETE METHOD (TAKE A LOCK)---------
        1. Get the user with the given userId.
        2. Get the show with the given showId.
        3. Get the list of showSeats with the given showSeatIds.
        4. Check the status of all the showSeat objects.
        5. If NOT available, throw an Exception.
        6. If YES, then block the seats.
        ------------TAKE A LOCK-----------------
        7. Check the status of the showSeats again.
        8. Save the status in the DB.
        ------------RELEASE THE LOCK-----------------
        9. Create the Booking the object.
        10. Return the Booking Object.
        -------TODAY WE'LL HAVE LOCK ON THE COMPLETE METHOD (RELEASE THE LOCK)---------
         */

        Optional<User> optionalUser = userRepository.findById(userId);
        if(!optionalUser.isPresent()){
            throw new UserNotFoundException("Invalid userId");
        }

        User user = optionalUser.get();
        Optional<Show> optionalShow = showRepository.findById(showId);
        if(!optionalShow.isPresent()){
            throw new ShowNotFoundException("Invalid show");
        }

        Show show = optionalShow.get();

        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);

        for(ShowSeat showSeat : showSeats){
            if(!ShowSeatStatus.AVAILABLE.equals(showSeat.getShowSeatStatus())){
             throw new ShowSeatNotAvailableException("Show seat not found");
            }
        }
        //5.  If YES, then block the seats.
        //6. Save the status in the DB.
        List<ShowSeat> savedShowSeats = new ArrayList<>();
        for (ShowSeat showSeat : showSeats) {
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            savedShowSeats.add(showSeatRepository.save(showSeat)); //update
        }

        //7. Create the Booking the object.
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setShowSeats(savedShowSeats);
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setAmount(priceCalculatorService.calculatePrice(showSeats, show));
        Booking savedBooking = bookingRepository.save(booking);


        //Payment workflow will start after this.
        //1. If payment is success, change the booking to CONFIRMED.
        //2. If payment fails or time out, release the seats.
        return savedBooking;

    }
}
