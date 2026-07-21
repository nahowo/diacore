package com.diacore.infrastructure.adapter;

import com.diacore.domain.user.port.out.TokenGeneratorPort;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenAdapter implements TokenGeneratorPort {
    private final SecretKey secretKey;
    private final long expirationTimeInMs;

    public JwtTokenAdapter(
            @Value("${jwt.secret}") String secret,
            @Value("${jwt.expiration}") long expirationTimeInMs
    ) {
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.expirationTimeInMs = expirationTimeInMs;
    }

    @Override
    public String generateToken(Long userId) {
        long now = System.currentTimeMillis();
        Date issuedAt = new Date(now);
        Date expiration = new Date(now + expirationTimeInMs);

        return Jwts.builder()
                // Payload (Claims)
                .subject(String.valueOf(userId))
                .issuedAt(issuedAt)
                .expiration(expiration)
                // Signature
                .signWith(secretKey)
                .compact();
    }
}
