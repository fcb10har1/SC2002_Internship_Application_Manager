package EntityClass;

public class Student extends 
User {
    private int yearOfStudy;
    private String major;
    private List<Application> applications;

    public Student(String userId, String name, String password, String major, int yearOfStudy) {
        super(userId, name, password);
        if (major == null || major.isBlank()) throw new IllegalArgumentException("major required");
        this.major = major.trim();
        this.yearOfStudy = yearOfStudy;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public String getMajor() {
        return major;
    }

    public List<Application> getApplications() {
        return applications;
    }

}
