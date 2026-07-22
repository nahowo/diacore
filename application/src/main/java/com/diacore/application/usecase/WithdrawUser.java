package com.diacore.application.usecase;

import com.diacore.domain.common.usecase.UseCase;

public interface WithdrawUser extends UseCase<WithdrawUser.Request, Long> {
    record Request () {}
}
