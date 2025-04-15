package ru.korolvd.otp.api.common;

public enum Status {
    OK(200),
    CREATED(201),
    ACCEPTED(202),
    NO_CONTENT(204),

    BAD_REQUEST(400),
    METHOD_NOT_ALLOWED(405),
    INTERNAL_SERVER_ERROR(500);

    private int code;

    Status(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
