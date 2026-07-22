package com.diacore.application.service;

import com.diacore.application.usecase.AuthenticateUser;
import com.diacore.domain.common.usecase.Actor;
import com.diacore.domain.user.model.User;
import com.diacore.domain.user.port.out.LoadUserPort;
import com.diacore.domain.user.port.out.TokenGeneratorPort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthenticateUserService implements AuthenticateUser {
    private final LoadUserPort loadUserPort;
    private final PasswordEncoder passwordEncoder;
    private final TokenGeneratorPort tokenGeneratorPort;

    public AuthenticateUserService(LoadUserPort loadUserPort, PasswordEncoder passwordEncoder,
                                   TokenGeneratorPort tokenGeneratorPort) {
        this.loadUserPort = loadUserPort;
        this.passwordEncoder = passwordEncoder;
        this.tokenGeneratorPort = tokenGeneratorPort;
    }

    @Override
    @Transactional(readOnly = true)
    public String execute(Actor actor, Request request) {
        User user = loadUserPort.findByEmail(request.email())
                .orElseThrow(() -> new IllegalArgumentException("Unknown email. "));

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new IllegalArgumentException("Password is not matching. ");
        }

        return tokenGeneratorPort.generateToken(user.getId());
    }
}
