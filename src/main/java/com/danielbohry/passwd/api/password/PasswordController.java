package com.danielbohry.passwd.api.password;

import com.danielbohry.passwd.domain.Password;
import com.danielbohry.passwd.service.PasswordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users/{userId}/passwords")
public class PasswordController {

    private final PasswordService service;

    public PasswordController(PasswordService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Password>> getAll(@PathVariable String userId) {
        var result = service.getAll(userId);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Password> save(@PathVariable String userId) {
        var result = service.create(userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @DeleteMapping
    public ResponseEntity<Void> clean(@PathVariable String userId) {
        service.clean(userId);
        return ResponseEntity.ok().build();
    }

}
