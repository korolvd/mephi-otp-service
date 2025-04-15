//package ru.korolvd.otp.api;
//
//import ru.korolvd.otp.api.common.*;
//
//import java.util.Map;
//
//public class AdminController extends RequestHandler {
//
//    public AdminController(String path) {
//        super.controllerPath = path;
//        super.routes = Map.of(
//                Route.of("GET", "/users"), this::getUsers,
//                Route.of("DELETE", "/users/{id}"), this::deleteUser,
//                Route.of("PUT", "/otp"), this::updateOtp,
//                Route.of("DELETE", "/otp/{id}"), this::deleteOtp
//        );
//    }
//
//    private Response<Void> getUsers(Request request) {
//        return Response.of(Status.OK);
//    }
//
//    private Response<Void> deleteUser(Request request) {
//        return Response.of(Status.OK);
//    }
//
//    private Response<Void> updateOtp(Request request) {
//        return Response.of(Status.OK);
//    }
//
//    private Response<Void> deleteOtp(Request request) {
//        return Response.of(Status.OK);
//    }
//
//}
