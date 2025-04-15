package ru.korolvd.otp.api;

import ru.korolvd.otp.api.common.*;
import ru.korolvd.otp.api.common.annotation.Controller;
import ru.korolvd.otp.api.common.annotation.RouteMapping;
import ru.korolvd.otp.exception.OTPException;
import ru.korolvd.otp.model.User;
import ru.korolvd.otp.service.AuthService;

import java.util.Map;

@Controller("/auth")
public class AuthController extends RequestHandler {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @RouteMapping(method = "GET")
    public Response<Map<String, String>> test(Request request) {
        System.out.println();
        return Response.of(Status.OK);
    }
//    @RouteMapping(method = "POST")
//    public Response<Map<String, String>> login(Request request) {
//        String token = authService.login((String) request.body().get("login"), (String) request.body().get("password"));
//        return Response.of(Status.OK, Map.of("token", token));
//    }
//
//    @RouteMapping(method = "POST", path = "/new")
//    public Response<Void> create(Request request) {
//        User user = mapper.convertValue(request.body(), User.class);
//        if (!authService.create(user)) {
//            throw new OTPException(Status.INTERNAL_SERVER_ERROR, "Ошибка при создании пользователя");
//        }
//        return Response.of(Status.NO_CONTENT);
//    }
    //todo JWT+,
    // reg+,
    // auth+,
    // role+,
    // exceptions,
    // crudService
    //todo hikari, migration, integrations, шедуллер,
    //todo logging-inerceprins, logging, mvn-build
}
