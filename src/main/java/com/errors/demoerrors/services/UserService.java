package com.errors.demoerrors.services;

import com.errors.demoerrors.models.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();
    Optional<User> findById(Long id);
}
