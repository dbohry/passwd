package com.danielbohry.passwd.domain;

public class Password {

    private final String id;
    private final String userId;
    private final String password;
    private final String description;

    public Password(String id, String userId, String password, String description) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getDescription() {
        return description;
    }
}
