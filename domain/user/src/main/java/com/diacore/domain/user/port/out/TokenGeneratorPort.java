package com.diacore.domain.user.port.out;

public interface TokenGeneratorPort {
    String generateToken(Long userId);
}
