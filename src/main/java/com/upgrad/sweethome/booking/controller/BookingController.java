package com.upgrad.sweethome.booking.controller;

import com.upgrad.sweethome.booking.dto.BookingDTO;
import com.upgrad.sweethome.booking.dto.ErrorModel;
import com.upgrad.sweethome.booking.exception.BookingException;
import com.upgrad.sweethome.booking.service.BookingService;
import com.upgrad.sweethome.booking.utility.BookingConstants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
//@RequestMapping(value = "/booking_app/v1")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    ModelMapper modelMapper;


    @PostMapping(value = "/booking" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookingDTO> createBooking(@Valid @RequestBody BookingDTO bookingDTO){

        return ResponseEntity.ok(bookingService.createBooking(bookingDTO));
    }

    @GetMapping ("/bookings/{aadhar}")
    public ResponseEntity <List <BookingDTO>> getBooking(@PathVariable String aadhar){

        System.out.println(" aadhar "+ aadhar);
        List <BookingDTO> bookingDTOs = bookingService.getBookings(aadhar);
        return ResponseEntity.ok(bookingDTOs);
    }

    @GetMapping ("/bookings")
    public ResponseEntity <List <BookingDTO>> getBooking(){

        List <BookingDTO> bookingDTOs = bookingService.getBookings();
        return ResponseEntity.ok(bookingDTOs);
    }


    @ExceptionHandler(BookingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorModel handleBookingException(BookingException e ){
        return e.getErrorModel();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorModel handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        ErrorModel errorModel = new ErrorModel();
        errorModel.setErrorCode(BookingConstants.ERR_PAYLOAD);
        errorModel.setErrorMsg("Invalid Booking Arguments");
        errorModel.setErrorList(e.getBindingResult().getFieldErrors().stream().map(fe -> fe.getDefaultMessage()).collect(Collectors.toList()));
        return errorModel ;
    }
}
