package com.diacore.application.service.user;

import com.diacore.application.usecase.user.RegisterUser;
import com.diacore.domain.common.usecase.Actor;
import com.diacore.domain.user.model.User;
import com.diacore.domain.user.port.out.LoadUserPort;
import com.diacore.domain.user.port.out.SaveUserPort;
import com.diacore.exception.BusinessException;
import com.diacore.exception.ErrorCode;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegisterUserCommand implements RegisterUser {
    private final SaveUserPort saveUserPort;
    private final LoadUserPort loadUserPort;
    private final PasswordEncoder passwordEncoder;

    public RegisterUserCommand(SaveUserPort saveUserPort, LoadUserPort loadUserPort, PasswordEncoder passwordEncoder) {
        this.saveUserPort = saveUserPort;
        this.loadUserPort = loadUserPort;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Long execute(Actor actor, Request request) {
        if (loadUserPort.findByEmail(request.email()).isPresent()) {
            throw new BusinessException(ErrorCode.DUPLICATE_EMAIL);
        }
        String encodedPassword = passwordEncoder.encode(request.password());

        User user = User.create(
                request.email(),
                encodedPassword,
                request.name()
        );

        User savedUser = saveUserPort.save(user);
        return savedUser.getId();
    }
}
