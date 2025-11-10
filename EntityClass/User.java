package EntityClass;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Domain user of the system.
 * One public class per file. ID is immutable; other fields are editable.
 */
public class User {

    public enum Role { STUDENT, COMPANY_REP, CAREER_STAFF, ADMIN }

    private final String id;     // immutable primary key
    private String name;
    private String email;
    private Role role;
    private boolean active;

    private static final Pattern EMAIL_RX =
            Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    // ---- Constructors / factories ----
    public User(String id, String name, String email, Role role, boolean active) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("id required");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name required");
        if (email == null || !EMAIL_RX.matcher(email).matches()) throw new IllegalArgumentException("invalid email");
        if (role == null) throw new IllegalArgumentException("role required");

        this.id = id.trim();
        this.name = name.trim();
        this.email = email.trim().toLowerCase();
        this.role = role;
        this.active = active;
    }

    /** Convenience factory: active by default. */
    public static User of(String id, String name, String email, Role role) {
        return new User(id, name, email, role, true);
    }

    // ---- Getters / setters ----
    public String getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name required");
        this.name = name.trim();
    }

    public String getEmail() { return email; }
    public void setEmail(String email) {
        if (email == null || !EMAIL_RX.matcher(email).matches()) throw new IllegalArgumentException("invalid email");
        this.email = email.trim().toLowerCase();
    }

    public Role getRole() { return role; }
    public void setRole(Role role) {
        if (role == null) throw new IllegalArgumentException("role required");
        this.role = role;
    }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    // ---- Value semantics (id as identity) ----
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User u)) return false;
        return id.equals(u.id);
    }
    @Override public int hashCode() { return Objects.hash(id); }

    @Override public String toString() {
        return "User{id='%s', name='%s', email='%s', role=%s, active=%s}"
                .formatted(id, name, email, role, active);
    }
}

