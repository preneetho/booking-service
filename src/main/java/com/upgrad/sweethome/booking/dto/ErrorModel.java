package com.upgrad.sweethome.booking.dto;

import java.util.ArrayList;
import java.util.List;

public class ErrorModel {

    private String errorCode;
    private String errorMsg;
    private List <String> errorList;

    public ErrorModel() {
    }

    public ErrorModel(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public List getErrorList() {
        return errorList;
    }

    public void setErrorList(List errorList) {
        this.errorList = errorList;
    }
}
