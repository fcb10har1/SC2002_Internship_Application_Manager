package EntityClass;
import java.util.ArrayList;
import java.util.List;

public class CompanyRep extends User2 {
    private String companyName;
    private String department;
    private String position;
    private List<InternshipOpportunity> opportunities;

    public CompanyRep(String userId, String name, String companyName, String department, String position) {
        super(userId, name);
        this.companyName = companyName;
        this.department = department;
        this.position = position;
        this.opportunities = new ArrayList<>();
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }

    public List<InternshipOpportunity> getOpportunities() {
        return opportunities;
    }

    public void addOpportunity(InternshipOpportunity opp) {
        if (opportunities.size() < 5) {
            opportunities.add(opp);
        } else {
            System.out.println("Maximum of 5 internship opportunities reached.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " | Company: " + companyName + " | Dept: " + department + " | Position: " + position;
    }
}
