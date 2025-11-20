package EntityClass;

import java.util.Objects;

public class User {

    private final String userId;     // immutable primary key
    private String name;
    private String password;

    // ---- Constructors / factories ----
    public User(String userId, String name, String password) {
        if (userId == null || userId.isBlank()) throw new IllegalArgumentException("userId required");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name required");
        if (password == null || password.isBlank()) throw new IllegalArgumentException("password required");
        this.userId = userId.trim();
        this.name = name.trim();
        this.password = password;
    }

    /** Convenience factory: active by default. */
    public static User of(String userId, String name) {
        return new User(userId, name, "password");
    }

    // ---- Getters / setters ----
    public String getUserId() { return userId; }

    public String login(String userId, String password)
    {   
        if (this.userId.equals(userId) && this.password.equals(password)) {
            return "Login successful";
        } else {
            return "Invalid userId or password";
        }

    }

    public void logout()
    {
        // In a real application, you would handle session termination here.
        System.out.println("User " + userId + " logged out.");
    }

    public void changePassword(String oldPassword, String newPassword)
    {
        if (!this.password.equals(oldPassword)) {
            throw new IllegalArgumentException("Old password is incorrect");
        }
        if (newPassword == null || newPassword.isBlank()) {
            throw new IllegalArgumentException("New password cannot be empty");
        }
        this.password = newPassword;
    }
    
    }



