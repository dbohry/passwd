package com.danielbohry.passwd.service;

import com.danielbohry.passwd.domain.Password;
import com.danielbohry.passwd.repository.PasswordRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PasswordService {

    private final UserService userService;
    private final PasswordFactory factory;
    private final PasswordRepository repository;

    public PasswordService(UserService userService, PasswordFactory factory, PasswordRepository repository) {
        this.userService = userService;
        this.factory = factory;
        this.repository = repository;
    }

    public List<Password> getAll(String userId) {
        return repository.findByUserId(userId);
    }

    public Password create(String userId) {
        var user = userService.getById(userId);
        var newId = UUID.randomUUID().toString();
        var newPassword = factory.createPassword();
        var password = new Password(newId, user.getId(), newPassword, "");

        return repository.save(password);
    }

    public void clean(String userId) {
        var user = userService.getById(userId);
        repository.deleteByUserId(user.getId());
    }

}
