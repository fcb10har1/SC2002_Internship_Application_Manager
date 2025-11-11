package EntityClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student extends User {

    public static final int MAX_APPLICATIONS = 5;

    private int yearOfStudy;
    private String major;
    private final List<Application> applications;

    public Student(String userId, String name, String password, String major, int yearOfStudy) {
        super(userId, name, password);
        setMajor(major);
        setYearOfStudy(yearOfStudy);
        this.applications = new ArrayList<>();
    }

    // --- Getters ---
    public int getYearOfStudy() { return yearOfStudy; }
    public String getMajor() { return major; }

    /** Unmodifiable view to protect internal list. */
    public List<Application> getApplications() {
        return Collections.unmodifiableList(applications);
    }

    public int getApplicationsCount() { return applications.size(); }
    public int remainingApplicationSlots() { return MAX_APPLICATIONS - applications.size(); }
    public boolean canApplyMore() { return applications.size() < MAX_APPLICATIONS; }

    // --- Mutators with validation ---
    public void setYearOfStudy(int yearOfStudy) {
        if (yearOfStudy < 1 || yearOfStudy > 6) {
            throw new IllegalArgumentException("yearOfStudy must be between 1 and 6, got " + yearOfStudy);
        }
        this.yearOfStudy = yearOfStudy;
    }

    public void setMajor(String major) {
        if (major == null || major.isBlank()) {
            throw new IllegalArgumentException("major required");
        }
        this.major = major.trim();
    }

    // --- Aggregate helpers (package-private): called by ApplicationManager ---
    /** Attach an application while enforcing the max-5 invariant. */
    void _attachApplication(Application app) {
        if (app == null) throw new IllegalArgumentException("application required");
        if (applications.size() >= MAX_APPLICATIONS) {
            throw new IllegalStateException("Maximum of " + MAX_APPLICATIONS + " applications reached");
        }
        applications.add(app);
    }

    /** Detach an application (no-op if not present). */
    boolean _detachApplication(Application app) {
        return applications.remove(app);
    }

    @Override
    public String toString() {
        return "Student{userId='" + getUserId() + "', name='" + getName()
                + "', major='" + major + "', yearOfStudy=" + yearOfStudy
                + ", applications=" + applications.size() + "}";
    }
}
