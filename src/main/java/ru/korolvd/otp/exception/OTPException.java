package ru.korolvd.otp.exception;

import ru.korolvd.otp.api.common.Status;

public class OTPException extends RuntimeException {

    private Status status;

    public OTPException(Status status, String message) {
        super(message);
        this.status = status;
    }

    public OTPException(Status status, Throwable throwable) {
        super(throwable);
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }
}
