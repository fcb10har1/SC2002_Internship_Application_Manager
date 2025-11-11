package EntityClass;

public class Application {
    private Student student;
    private InternshipOpportunity target;
    private ApplicationStatus status = ApplicationStatus.PENDING;
    private boolean acceptedByStudent = false;

    public Application(Student student, InternshipOpportunity target) {
        this.student = student;
        this.target = target;
    }

    public void setStatus(ApplicationStatus s) {
        this.status = s;
    }

    public void studentAccept() {
        if (status == ApplicationStatus.SUCCESSFUL) {
            acceptedByStudent = true;
            System.out.println(student.getUserId() + " has accepted the internship placement: " + target.getTitle());
        } else {
            System.out.println("Cannot accept. Application not successful yet.");
        }
    }

    public boolean isConfirmed() {
        return acceptedByStudent;
    }

    public Student getStudent() {
        return student;
    }

    public InternshipOpportunity getTarget() {
        return target;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Application: " + student.getUserId() + " → " + target.getTitle() + " [" + status + "]";
    }
}

