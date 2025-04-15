package ru.korolvd.otp.auth;

import ru.korolvd.otp.model.Role;
import ru.korolvd.otp.repository.CrudRepository;
import ru.korolvd.otp.service.TokenService;

public class CommonAuthenticator extends AbstractAuthenticator {
    public CommonAuthenticator(TokenService tokenService, CrudRepository repository) {
        super(tokenService, repository);
    }

    @Override
    protected boolean validateRole(Role role) {
        return true;
    }
}
