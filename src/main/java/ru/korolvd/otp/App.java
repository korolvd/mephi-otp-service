package ru.korolvd.otp;

import com.sun.net.httpserver.*;

import ru.korolvd.otp.api.AuthController;

import ru.korolvd.otp.api.common.ExceptionHandler;
import ru.korolvd.otp.auth.AdminAuthenticator;
import ru.korolvd.otp.auth.CommonAuthenticator;
import ru.korolvd.otp.repository.CrudRepository;
import ru.korolvd.otp.repository.SqlCrudRepository;
import ru.korolvd.otp.service.AuthService;
import ru.korolvd.otp.service.TokenService;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.util.Properties;
import java.util.concurrent.Executors;

public class App {
    public final static Properties config = loadConfig();

    public static void main(String[] args) throws IOException {
        int port = Integer.parseInt(config.getProperty("server.port"));
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        String secret = config.getProperty("token.secret");
        long hours = Long.parseLong(config.getProperty("token.expiration.min"));
        TokenService tokenService = new TokenService(secret, hours);

        ExceptionHandler exceptionHandler = new ExceptionHandler();

        String path = config.getProperty("server.path");

        CrudRepository repository = new SqlCrudRepository();

        AuthController authController = new AuthController(new AuthService(tokenService, repository));
        HttpContext authContext = server.createContext(authController.getRestPath(), authController);
        authContext.getFilters().add(exceptionHandler);

//        OtpController otpController = new OtpController(path + "/otp");
//        HttpContext otpContext = server.createContext(path + "/otp", otpController);
//        otpContext.getFilters().add(exceptionHandler);
//        otpContext.setAuthenticator(new CommonAuthenticator(tokenService, repository));
//
//        AdminController adminController = new AdminController(path + "/admin");
//        HttpContext adminContext = server.createContext(path + "/admin", adminController);
//        adminContext.getFilters().add(exceptionHandler);
//        adminContext.setAuthenticator(new AdminAuthenticator(tokenService, repository));

        server.setExecutor(Executors.newFixedThreadPool(Integer.parseInt(config.getProperty("server.connections"))));

        server.start();

        System.out.println("Server started on http://localhost:" + port + path);
    }

    private static Properties loadConfig() {
        Properties properties = new Properties();
        String name = "app.properties";
        try (InputStream in = new FileInputStream(name)) {
            properties.load(in);
        } catch (Exception e) {
            try (InputStream in = App.class.getClassLoader().getResourceAsStream(name)) {
                properties.load(in);
            } catch (Exception ex) {
                throw new RuntimeException("Ошибка загрузки параметров: " + ex.getMessage(), ex);
            }
        }
        return properties;
    }
}
