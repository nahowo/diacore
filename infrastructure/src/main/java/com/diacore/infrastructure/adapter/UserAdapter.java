package com.diacore.infrastructure.adapter;

import com.diacore.domain.user.model.User;
import com.diacore.domain.user.port.out.DeleteUserPort;
import com.diacore.domain.user.port.out.LoadUserPort;
import com.diacore.domain.user.port.out.SaveUserPort;
import com.diacore.infrastructure.adapter.repository.UserJpaRepository;
import com.diacore.infrastructure.entity.UserJpaEntity;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class UserAdapter implements SaveUserPort, LoadUserPort, DeleteUserPort {
    private final UserJpaRepository repository;

    public UserAdapter(UserJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User user) {
        UserJpaEntity entity = new UserJpaEntity(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getName()
        );

        UserJpaEntity savedEntity = repository.save(entity);

        return toDomain(savedEntity);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email)
                .map(this::toDomain);
    }

    @Override
    public Long deleteById(Long userId) {
        repository.deleteById(userId);
        return userId;
    }

    private User toDomain(UserJpaEntity entity) {
        return User.withId(
                entity.getId(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getName()
        );
    }
}
