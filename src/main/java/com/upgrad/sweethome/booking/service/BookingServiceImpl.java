package com.upgrad.sweethome.booking.service;

import com.upgrad.sweethome.booking.dao.BookingDao;
import com.upgrad.sweethome.booking.dto.BookingDTO;
import com.upgrad.sweethome.booking.dto.ErrorModel;
import com.upgrad.sweethome.booking.entities.Booking;
import com.upgrad.sweethome.booking.exception.BookingException;
import com.upgrad.sweethome.booking.utility.BookingConstants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingDao bookingDao;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public BookingDTO createBooking(BookingDTO booking) {

        Booking bookingObj = modelMapper.map(booking, Booking.class);

        //Check if ToDate is greater than Fromdate else throw error.
        if (bookingObj.getToDate().getTime() < bookingObj.getFromDate().getTime()) {
            throw new BookingException(new ErrorModel(BookingConstants.ERR_PAYLOAD, "To date is less than From Date"));
        }

        //Calculate Room price
        bookingObj.setRoomPrice(bookingObj.getNumOfRooms() * getRoomPrice(bookingObj.getFromDate(), bookingObj.getToDate()));
        //Get Room numbers
        bookingObj.setRoomNumbers("" + getRoomNumbers(bookingObj.getNumOfRooms()));
        //Set Booked date as today's date.
        bookingObj.setBookedOn(new Date());

        System.out.println("createBooking " + bookingObj);

        try {

            Booking savedObj = bookingDao.save(bookingObj);
            return modelMapper.map(savedObj, BookingDTO.class);
        } catch (Exception exp) {

            throw new BookingException(new ErrorModel(BookingConstants.ERR_DATABASE_SAVE, "Error saving Bookings Data"));

        }

    }

    @Override
    public List<BookingDTO> getBookings() {

        ArrayList savedDTOs = new ArrayList<>();
        List<Booking> savedObjects = bookingDao.findAll();

        for (Booking booking : savedObjects) {
            savedDTOs.add(modelMapper.map(booking, BookingDTO.class));
        }
        return savedDTOs;
    }

    @Override
    public List<BookingDTO> getBookings(String aadharId) {
        ArrayList savedDTOs = new ArrayList<>();
        List<Booking> savedObjects = bookingDao.findByAadharNumber(aadharId);

        for (Booking booking : savedObjects) {
            savedDTOs.add(modelMapper.map(booking, BookingDTO.class));
        }
        return savedDTOs;
    }

    /**
     * Get the price of the hotel for the booked period.
     *
     * @param fromDate
     * @param toDate
     * @return
     */
    private static int getRoomPrice(Date fromDate, Date toDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fromDate);
        LocalDate fromDateTemp = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        calendar.setTime(toDate);
        LocalDate toDateTemp = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        long noOfDaysBetween = ChronoUnit.DAYS.between(fromDateTemp, toDateTemp);
        return (int) (noOfDaysBetween * 1000);
    }

    /**
     * Dummy method to generate room numbers
     *
     * @param count
     * @return
     */
    private static ArrayList<String> getRoomNumbers(int count) {
        Random rand = new Random();
        int upperBound = 100;
        ArrayList<String> numberList = new ArrayList<String>();

        for (int i = 0; i < count; i++) {
            numberList.add("R#" + String.valueOf(rand.nextInt(upperBound)));
        }

        return numberList;
    }

}
