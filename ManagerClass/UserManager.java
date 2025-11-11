package ManagerClass;

import EntityClass.Student;
import EntityClass.CompanyRep;
import EntityClass.CareerStaff;
import RepositoryClass.UserRepository;

/**
 * Handles user-related operations such as approvals and password changes.
 * Methods follow UML signatures exactly.
 */
public class UserManager {

    private final UserRepository userRepository;

    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Approves a company representative.
     * Since UML does not specify approval logic, returns true if inputs are valid.
     */
    public boolean approveCompanyRep(CareerStaff approver, CompanyRep rep) {
        if (approver == null || rep == null) return false;
        // Approval logic unspecified in UML — just return success flag.
        return true;
    }

    /**
     * Changes password for any user identified by their ID.
     */
    public void changePassword(String userId, String newPwd) {
        userRepository.findById(userId).ifPresent(u -> {
            u.changePassword(newPwd);
            userRepository.update(u);
        });
    }

    /**
     * Changes password for a specific student.
     */
    public void changeStudentPassword(Student s, String newPwd) {
        if (s == null || newPwd == null || newPwd.isBlank()) return;
        s.changePassword(newPwd);
        userRepository.update(s);
    }
}
