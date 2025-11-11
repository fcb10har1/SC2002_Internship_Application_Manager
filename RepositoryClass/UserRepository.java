package RepositoryClass;

import EntityClass.User2;
import java.util.*;

/**
 * Repository for User entities — handles basic CRUD operations in memory.
 */
public class UserRepository {

    private final Map<String, User2> users = new HashMap<>();

    /** Adds a new user to the repository. */
    public void add(User2 u) {
        if (u == null) throw new IllegalArgumentException("User cannot be null");
        users.put(u.getUserId(), u);
    }

    /** Finds a user by ID. */
    public Optional<User2> findById(String id) {
        if (id == null) return Optional.empty();
        return Optional.ofNullable(users.get(id));
    }

    /** Updates an existing user. */
    public void update(User2 u) {
        if (u == null) return;
        users.put(u.getUserId(), u);
    }

    /** Returns all users. */
    public List<User2> all() {
        return new ArrayList<>(users.values());
    }
}

