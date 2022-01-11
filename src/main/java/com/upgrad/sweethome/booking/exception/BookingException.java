package com.upgrad.sweethome.booking.exception;

import com.upgrad.sweethome.booking.dto.ErrorModel;

public class BookingException extends RuntimeException {

    ErrorModel errorModel;

    public BookingException(){

    }

    public BookingException(ErrorModel errorModel){
        this.errorModel = errorModel;
    }

    public ErrorModel getErrorModel() {
        return errorModel;
    }

    public void setErrorModel(ErrorModel errorModel) {
        this.errorModel = errorModel;
    }
}
