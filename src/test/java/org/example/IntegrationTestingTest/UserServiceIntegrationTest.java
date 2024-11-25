package org.example.IntegrationTestingTest;

import org.example.IntegrationTesting.User;
import org.example.IntegrationTesting.UserRepository;
import org.example.IntegrationTesting.UserService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceIntegrationTest {
    private UserService userService;

    @Before
    public void setUp() {
        userService = new UserService(new UserRepository());
    }

    @Test
    public void testCreateUser_ValidParameters() {
        // Arrange
        Long userId = 1L;
        String userName = "John Doe";

        // Act
        User createdUser = userService.createUser(userId, userName);

        // Assert
        assertNotNull("Created user should not be null", createdUser);
        assertEquals("User ID should match", userId, createdUser.getId());
        assertEquals("User name should match", userName, createdUser.getName());
    }

    @Test
    public void testCreateUser_NullId() {
        // Arrange
        String userName = "John Doe";

        // Act & Assert
        try {
            userService.createUser(null, userName);
            fail("Expected IllegalArgumentException for null ID");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid input", e.getMessage());
        }
    }

    @Test
    public void testCreateUser_NullName() {
        // Arrange
        Long userId = 1L;

        // Act & Assert
        try {
            userService.createUser(userId, null);
            fail("Expected IllegalArgumentException for null name");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid input", e.getMessage());
        }
    }

    @Test
    public void testCreateUser_BlankName() {
        // Arrange
        Long userId = 1L;

        // Act & Assert
        try {
            userService.createUser(userId, "");
            fail("Expected IllegalArgumentException for blank name");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid input", e.getMessage());
        }
    }

    @Test
    public void testCreateUser_MutatedParameter() {
        // Arrange
        Long userId = 2L;
        String userName = "Jane Doe";

        // Simulate a mutation where the `userId` is replaced with null in the User object
        User createdUser = null;
        try {
            createdUser = userService.createUser(null, userName);
            fail("Expected IllegalArgumentException for null ID due to mutation");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid input", e.getMessage());
        }

        // Ensure the user was not added to the repository
        assertNull("User should not be created if ID is null", createdUser);
    }

    @Test
    public void testGetUserById_ValidParameters() {
        // Arrange
        Long userId = 3L;
        String userName = "Alice";

        // Act
        userService.createUser(userId, userName);
        User retrievedUser = userService.getUserById(userId);

        // Assert
        assertNotNull("Retrieved user should not be null", retrievedUser);
        assertEquals("User ID should match", userId, retrievedUser.getId());
        assertEquals("User name should match", userName, retrievedUser.getName());
    }

    @Test
    public void testGetUserById_NonExistentId() {
        // Arrange
        Long userId = 4L;

        // Act
        User retrievedUser = userService.getUserById(userId);

        // Assert
        assertNull("Retrieved user should be null for a non-existent ID", retrievedUser);
    }
}