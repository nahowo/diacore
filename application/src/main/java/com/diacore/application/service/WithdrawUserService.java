package com.diacore.application.service;

import com.diacore.application.usecase.WithdrawUser;
import com.diacore.domain.common.usecase.Actor;
import com.diacore.domain.user.port.out.DeleteUserPort;
import org.springframework.stereotype.Service;

@Service
public class WithdrawUserService implements WithdrawUser {
    private final DeleteUserPort deleteUserPort;

    public WithdrawUserService(DeleteUserPort deleteUserPort) {
        this.deleteUserPort = deleteUserPort;
    }

    @Override
    public Long execute(Actor actor, Request request) {
        if (actor.userId() == null) {
            throw new IllegalArgumentException("User is not Authenticated. ");
        }

        deleteUserPort.deleteById(actor.userId());
        return actor.userId();
    }
}
