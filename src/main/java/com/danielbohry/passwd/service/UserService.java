package com.danielbohry.passwd.service;

import com.danielbohry.passwd.domain.User;
import com.danielbohry.passwd.exception.NotFoundException;
import com.danielbohry.passwd.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public User getById(String id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("User not found."));
    }

    public User create(String name) {
        var newId = UUID.randomUUID().toString();
        return repository.save(new User(newId, name));
    }

}
