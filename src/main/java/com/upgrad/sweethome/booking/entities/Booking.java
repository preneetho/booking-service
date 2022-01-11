package com.upgrad.sweethome.booking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * This class represents the Booking Table in the database.
 * It holds the booking details of a user.
 */

@Entity (name="booking")
public class Booking {


    /**
     * It refers to the "BookingId" of the user and is used to uniquely identify a booking.
     */
    @Id
    @GeneratedValue
    private int bookingId;

    /**
     * It refers to the date from which the user is looking for the room
     */
    private Date fromDate;

    /**
     * It refers to the date to which the user is looking for the room
     */
    private Date toDate;

    /**
     * aadhar number of the user.
     */
    private String aadharNumber;

    /**
     * It refers to the number of rooms required by user
     */
    private int numOfRooms;

    /**
     * It represents the list of room numbers allocated to the user
     */
    private String roomNumbers;


    /**
     * It refers to the total price of the allocated rooms for the requested days.
     * Default value of a single room is Rs.1000,
     */
    @Column (nullable = false)
    private int roomPrice;

    /**
     * It refers to the transactionId which we get from the payment service.
     */
    private int transactionId;

    /**
     * It refers to the current date
     */
    private Date bookedOn;


    public Booking() {
    }

    public Booking(int bookingId, Date fromDate, Date toDate, String aadharNumber, int numOfRooms, String roomNumbers, int roomPrice, int transactionId, Date bookedOn) {
        this.bookingId = bookingId;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.aadharNumber = aadharNumber;
        this.numOfRooms = numOfRooms;
        this.roomNumbers = roomNumbers;
        this.roomPrice = roomPrice;
        this.transactionId = transactionId;
        this.bookedOn = bookedOn;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
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

    public Date getBookedOn() {
        return bookedOn;
    }

    public void setBookedOn(Date bookedOn) {
        this.bookedOn = bookedOn;
    }

    @Override
    public String toString() {
        return "Booking{" +
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
}
