package com.example.bank.exception;

public class BankException extends RuntimeException {

    private int errorCode;
    private String errorMessage;

    public BankException(Throwable throwable) {
        super(throwable);
    }

    public BankException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public BankException(String msg) {
        super(msg);
    }

    public BankException(String message, int errorCode) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = message;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return this.errorCode + " : " + this.getErrorMessage();
    }
}
