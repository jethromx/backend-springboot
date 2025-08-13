package com.core.domain.ports.output;

import com.core.domain.model.User;

import java.util.List;

public interface UserRepositoryPort
{
    User save(User user);
    User findById(Long id);
    void deleteById(Long id);
    User update(User user);
    List<User> findAll();
}
