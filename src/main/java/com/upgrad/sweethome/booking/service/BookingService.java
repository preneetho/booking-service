package com.upgrad.sweethome.booking.service;

import com.upgrad.sweethome.booking.dto.BookingDTO;
import com.upgrad.sweethome.booking.entities.Booking;

import java.util.List;

public interface BookingService {

    /**
     * Create a booking entry
     * @param booking
     * @return
     */
    BookingDTO createBooking(BookingDTO booking);

    /**
     * Get all bookings
     * @return List of all bookings
     */
    List <BookingDTO> getBookings ();

    /**
     * Get all bookings under a user.
     * @param aadharId
     * @return List of all bookings
     */
    List <BookingDTO> getBookings (String aadharId);


}
