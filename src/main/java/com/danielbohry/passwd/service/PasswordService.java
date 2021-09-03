package com.danielbohry.passwd.service;

import com.danielbohry.passwd.domain.Password;
import com.danielbohry.passwd.repository.PasswordRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

@Service
public class PasswordService {

    private final UserService userService;
    private final PasswordRepository repository;

    public PasswordService(UserService userService, PasswordRepository repository) {
        this.userService = userService;
        this.repository = repository;
    }

    public List<Password> getAll(String userId) {
        return repository.findByUserId(userId);
    }

    public Password create(String userId) {
        var user = userService.getById(userId);
        var newId = UUID.randomUUID().toString();
        var newPassword = createPassword();
        var password = new Password(newId, user.getId(), newPassword, "");

        return repository.save(password);
    }

    public void clean(String userId) {
        var user = userService.getById(userId);
        repository.deleteByUserId(user.getId());
    }

    private String createPassword() {
        String possibleChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();

        while (salt.length() < 24) { //
            if (salt.length() > 1 && salt.length() % 8 == 0) salt.append("-");
            int index = (int) (rnd.nextFloat() * possibleChars.length());
            String next = rnd.nextInt() % 2 == 0 ? possibleChars.toLowerCase(): possibleChars;
            salt.append(next.charAt(index));
        }

        return salt.toString();
    }

}
