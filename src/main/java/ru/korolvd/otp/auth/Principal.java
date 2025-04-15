package ru.korolvd.otp.auth;

import com.sun.net.httpserver.HttpPrincipal;
import ru.korolvd.otp.model.Role;

//todo delete
public class Principal extends HttpPrincipal {
    private final Role role;

    public Principal(String username, String authType, Role role) {
        super(username, authType);
        this.role = role;
    }

    public Role getRole() {
        return role;
    }
}
