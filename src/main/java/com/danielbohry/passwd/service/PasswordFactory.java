package com.danielbohry.passwd.service;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PasswordFactory {

    private static final String POSSIBLE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    public String createPassword() {
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();

        while (salt.length() < 24) { //
            if (salt.length() > 1 && salt.length() % 8 == 0) salt.append("-");
            int index = (int) (rnd.nextFloat() * POSSIBLE_CHARS.length());
            String next = rnd.nextInt() % 2 == 0 ? POSSIBLE_CHARS.toLowerCase(): POSSIBLE_CHARS;
            salt.append(next.charAt(index));
        }

        return salt.toString();
    }

}
