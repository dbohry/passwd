package com.danielbohry.passwd.api.user;

import com.danielbohry.passwd.domain.User;
import com.danielbohry.passwd.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        var result = service.getAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable String id) {
        var result = service.getById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody UserCreateDto user) {
        var result = service.create(user.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

}
