package com.core.domain.ports.input;

import com.core.domain.model.User;

public interface UserRegistrationPort {
    User registerUser(User user);
}
