package org.example.IntegrationTesting;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private final Map<Long, User> database = new HashMap<>();

    public User save(User user) {
        database.put(user.getId(), user);
        return user;
    }

    public User findById(Long id) {
        return database.get(id);
    }
}