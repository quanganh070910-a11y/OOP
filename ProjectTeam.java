//202418843
//Dương Quang Anh

import java.util.ArrayList;
import java.util.List;

public class ProjectTeam {
    private String projectCode;
    private String projectName;
    private Employee leader; // Trưởng nhóm (không sở hữu độc quyền đối tượng)
    private List<Employee> members; // Danh sách thành viên

    // Constructors
    public ProjectTeam(String projectCode, String projectName) {
        this.projectCode = projectCode;
        this.projectName = projectName;
        this.members = new ArrayList<>();
        this.leader = null;
    }

    public ProjectTeam(String projectCode, String projectName, Employee leader) {
        this(projectCode, projectName);
        if (leader != null) {
            this.leader = leader;
            addMember(leader);
        }
    }

    public String getProjectCode() {
        return projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public Employee getLeader() {
        return leader;
    }

    public boolean contains(String employeeId) {
        for (Employee emp : members) {
            if (emp.getId().equals(employeeId)) {
                return true;
            }
        }
        return false;
    }

    // Overloading addMember
    public boolean addMember(Employee employee) {
        return addMember(employee, false);
    }

    public boolean addMember(Employee employee, boolean makeLeader) {
        if (employee == null) return false;

        // Ràng buộc: Không thêm trùng nhân sự trong cùng nhóm
        if (!contains(employee.getId())) {
            members.add(employee);
        }

        if (makeLeader) {
            this.leader = employee;
        }

        return true;
    }

    public boolean removeMember(String employeeId) {
        // Ràng buộc: Không được xóa trưởng nhóm khi chưa chọn trưởng nhóm thay thế
        if (leader != null && leader.getId().equals(employeeId)) {
            System.out.println("LOI: Khong the xoa truong nhom hien tai khi chua chon duoc nguoi thay the");
            return false;
        }

        return members.removeIf(emp -> emp.getId().equals(employeeId));
    }

    public void changeLeader(Employee newLeader) {
        if (newLeader == null) return;
        
        // Trưởng nhóm mới phải được thêm vào nhóm nếu chưa phải thành viên
        if (!contains(newLeader.getId())) {
            addMember(newLeader);
        }
        this.leader = newLeader;
    }

    public double calculateTotalMonthlyCost() {
        double total = 0;
        for (Employee emp : members) {
            total += emp.calculateMonthlyCost();
        }
        return total;
    }

    public void displayTeam() {
        System.out.println("==========================================");
        System.out.println("DU AN: " + projectName + " [" + projectCode + "]");
        System.out.println("Truong nhom: " + (leader != null ? leader.getFullName() + " (" + leader.getId() + ")" : "Chưa có"));
        System.out.println("Danh sach thanh vien (" + members.size() + " nguoi):");
        for (Employee emp : members) {
            System.out.print("  - ");
            emp.displayInfo();
        }
        System.out.printf("THONG KE LUONG: Tong chi phi thang = %.2f\n", calculateTotalMonthlyCost());
        System.out.println("==========================================");
    }
}