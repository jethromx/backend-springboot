package com.core.infraestructure.adapters;



import com.core.domain.model.User;
import com.core.domain.ports.output.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {
    private final UserJpaRepository userJpaRepository;
    private final UserJpaMapper userMapper;



    @Override
    public User save(User user) {
        UserJpaEntity userJpa= userJpaRepository.save(userMapper.toJpaEntity(user));

        return userMapper.toEntity(userJpa);
    }

    @Override
    public User findById(Long id) {
        return userJpaRepository.findById(id)
                .map(userMapper::toEntity)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
    }

    @Override
    public void deleteById(Long id) {
        userJpaRepository.deleteById(id);
    }

    @Override
    public User update(User user) {
        // Verificar primero que el usuario exista
        if (!userJpaRepository.existsById(user.getId())) {
            throw new RuntimeException("No se puede actualizar. Usuario no encontrado con id: " + user.getId());
        }

        UserJpaEntity userJpa = userJpaRepository.save(userMapper.toJpaEntity(user));
        return userMapper.toEntity(userJpa);
    }

    @Override
    public List<User> findAll() {
        return userJpaRepository.findAll().stream()
                .map(userMapper::toEntity)
                .collect(Collectors.toList());
    }
}

