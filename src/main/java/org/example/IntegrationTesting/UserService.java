package org.example.IntegrationTesting;

public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User createUser(Long id, String name) {
        if (id == null || name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid input");
        }
        // Use the correct id and name
        User user = new User(id, name);
        return repository.save(user);
    }

    public User getUserById(Long id) {
        return repository.findById(id);
    }
}