package com.core.application.usecases;

import com.core.application.mappers.UserMapper;
import com.core.domain.model.User;
import com.core.domain.ports.input.UserRegistrationPort;
import com.core.domain.ports.output.UserRepositoryPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserRegistrationCase implements UserRegistrationPort {

    private final UserRepositoryPort repository;
    private final UserMapper mapper;

    @Override
    public User registerUser(User user) {

        validateUserData(user);

        /*
        if (repository.existsByUsername(user.getUsername())) {
            throw new UserAlreadyExistsException("El usuario ya existe");
        }*/

        return repository.save(user);
    }

    private void validateUserData(User user) {
        // Lógica de validación específica del dominio
    }

}
