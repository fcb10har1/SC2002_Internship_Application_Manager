import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InternshipOpportunity {
    private String id;
    private String title;
    private String description;
    private String preferredMajor;
    private InternshipLevel level;
    private LocalDate openDate;
    private LocalDate closeDate;
    private OpportunityStatus status = OpportunityStatus.PENDING;
    private boolean visible = false;
    private String companyName;
    private CompanyRep owner;
    private int slotCap;
    private List<Application> applications;

    public InternshipOpportunity(String id, CompanyRep owner, String companyName, int slotCap) {
        this.id = id;
        this.owner = owner;
        this.companyName = companyName;
        this.slotCap = slotCap;
        this.applications = new ArrayList<>();
    }

    public void setBasics(String title, String desc, InternshipLevel lvl, String prefMajor) {
        this.title = title;
        this.description = desc;
        this.level = lvl;
        this.preferredMajor = prefMajor;
    }

    public void setWindowOpen(LocalDate openDate, LocalDate closeDate) {
        this.openDate = openDate;
        this.closeDate = closeDate;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setStatus(OpportunityStatus status) {
        this.status = status;
    }

    public int confirmedCount() {
        int count = 0;
        for (Application a : applications) {
            if (a.isConfirmed()) count++;
        }
        return count;
    }

    public boolean slotsFilled() {
        return confirmedCount() >= slotCap;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public String getTitle() {
        return title;
    }

    public OpportunityStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + title + " (" + level + ", " + preferredMajor + ", " + status + ")";
    }
}

