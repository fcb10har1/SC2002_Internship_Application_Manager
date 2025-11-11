package EntityClass;
public class CareerStaff extends User2 {
    private String staffDepartment;

    public CareerStaff(String staffId, String name, String dept) {
        super(staffId, name);
        this.staffDepartment = dept;
    }

    public String getStaffDepartment() {
        return staffDepartment;
    }

    @Override
    public String toString() {
        return super.toString() + " | Department: " + staffDepartment;
    }
}
