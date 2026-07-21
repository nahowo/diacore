package com.diacore.domain.user.model;

public class User {
    private final Long id;
    private final String email;
    private final String password; // 암호화된 비밀번호
    private final String name;

    private User(Long id, String email, String password, String name) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public static User create(String email, String encodedPassword, String name) {
        return new User(null, email, encodedPassword, name);
    }

    public static User withId(Long id, String email, String password, String name) {
        return new User(id, email, password, name);
    }

    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getName() { return name; }
}
