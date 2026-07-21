package com.diacore.domain.user.port.out;

import com.diacore.domain.user.model.User;

public interface SaveUserPort {
    User save(User user);
}
