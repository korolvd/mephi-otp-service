package ru.korolvd.otp.api.common;

import ru.korolvd.otp.auth.Principal;

import java.util.Map;

public record Request(Map<String, Object> body,
                      Map<String, String> queryParams,
                      Map<String, String> pathVariables) {
}
