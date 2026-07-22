package com.diacore.application.service;

import com.diacore.application.usecase.WithdrawUser;
import com.diacore.domain.common.usecase.Actor;
import com.diacore.domain.user.port.out.DeleteUserPort;
import com.diacore.exception.BusinessException;
import com.diacore.exception.ErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WithdrawUserCommand implements WithdrawUser {
    private final DeleteUserPort deleteUserPort;

    public WithdrawUserCommand(DeleteUserPort deleteUserPort) {
        this.deleteUserPort = deleteUserPort;
    }

    @Override
    @Transactional
    public Long execute(Actor actor, Request request) {
        if (actor.userId() == null) {
            throw new BusinessException(ErrorCode.UNAUTHORIZED_USER);
        }

        deleteUserPort.deleteById(actor.userId());
        return actor.userId();
    }
}
