package com.upgrad.sweethome.booking.dto;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.upgrad.sweethome.booking.utility.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class BookingDTO {

    /**
     * It refers to the "BookingId" of the user and is used to uniquely identify a booking.
     */
     private int bookingId;

    /**
     * It refers to the date from which the user is looking for the room
     */
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "From Date should be in yyyy-mm-dd format")
    //@JsonDeserialize(using = DateHandler.class)
    private String fromDate;

    /**
     * It refers to the date to which the user is looking for the room
     */
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "To Date should be in yyyy-mm-dd format")
    //@JsonDeserialize(using = DateHandler.class)
    private String toDate;

    /**
     * aadhar number of the user.
     */
    private String aadharNumber;

    /**
     * It refers to the number of rooms required by user
     */
    @Min(value = 0, message = "Rooms should be at least 1")
    @Max(value = 5, message = "Max 5 rooms can be booked")
    private int numOfRooms;

    /**
     * It represents the list of room numbers allocated to the user
     */

    private String roomNumbers;


    /**
     * It refers to the total price of the allocated rooms for the requested days.
     * Default value of a single room is Rs.1000,
     */

    private int roomPrice;

    /**
     * It refers to the transactionId which we get from the payment service.
     */
    private int transactionId;

    /**
     * It refers to the current date
     */
    //@JsonDeserialize(using = DateHandler.class)
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Booking Date should be in yyyy-mm-dd format")
    private String bookedOn;

    public BookingDTO() {
    }

    @Override
    public String toString() {
        return "BookingDTO{" +
                "bookingId=" + bookingId +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", aadharNumber='" + aadharNumber + '\'' +
                ", numOfRooms=" + numOfRooms +
                ", roomNumbers='" + roomNumbers + '\'' +
                ", roomPrice=" + roomPrice +
                ", transactionId=" + transactionId +
                ", bookedOn=" + bookedOn +
                '}';
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public int getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(int numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    public String getRoomNumbers() {
        return roomNumbers;
    }

    public void setRoomNumbers(String roomNumbers) {
        this.roomNumbers = roomNumbers;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getBookedOn() {
        return bookedOn;
    }

    public void setBookedOn(String bookedOn) {
        this.bookedOn = bookedOn;
    }
}
