package com.diacore.domain.user.port.out;

import com.diacore.domain.user.model.User;
import java.util.Optional;

public interface LoadUserPort {
    Optional<User> findByEmail(String email);
}
