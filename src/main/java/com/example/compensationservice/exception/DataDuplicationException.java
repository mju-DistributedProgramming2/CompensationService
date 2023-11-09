package com.example.compensationservice.exception;

public class DataDuplicationException extends Exception{
    public DataDuplicationException(String message) {
        super(message);
    }
    @Override
    public String getMessage() {
        return super.getMessage();
    }

}
