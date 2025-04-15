//package ru.korolvd.otp.api;
//
//import ru.korolvd.otp.api.common.*;
//
//import java.util.Map;
//
//public class OtpController extends RequestHandler {
//
//    public OtpController(String path) {
//        super.controllerPath = path;
//        super.routes = Map.of(
//                Route.of("GET", ""), this::generate,
//                Route.of("POST", ""), this::validate
//        );
//    }
//
//    private Response<Void> generate(Request request) {
//        return Response.of(Status.OK);
//    }
//
//    private Response<Void> validate(Request request) {
//        return Response.of(Status.OK);
//    }
//}
