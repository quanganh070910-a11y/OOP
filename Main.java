//202418843
//Dương Quang Anh

public class Main {
    public static void main(String[] args) {
        System.out.println("=== BAT DAU KICH BAN KIEM THU ===\n");

        // 1. Tạo hai Employee bằng hai constructor khác nhau.
        System.out.println("--- Buoc 1: Tao 2 Employee ---");
        Employee emp1 = new Employee("E01", "Nguyen Van A");
        Employee emp2 = new Employee("E02", "Tran Thi B", 1000);
        emp1.displayInfo();
        emp2.displayInfo();

        // 2. Tạo hai SoftwareEngineer bằng hai constructor khác nhau.
        System.out.println("\n--- Buoc 2: Tao 2 SoftwareEngineer ---");
        SoftwareEngineer se1 = new SoftwareEngineer("SE01", "Le Van C", "Java");
        SoftwareEngineer se2 = new SoftwareEngineer("SE02", "Pham Van D", 1500, "C++", 300);
        se1.displayInfo();
        se2.displayInfo();

        // 3. Tăng lương một nhân sự bằng số tiền cố định.
        System.out.println("\n--- Buoc 3: Tang luong emp1 len 500 ---");
        emp1.increaseSalary(500);
        emp1.displayInfo();

        // 4. Tăng lương một nhân sự khác theo phần trăm.
        System.out.println("\n--- Buoc 4: Tang luong se1 them 10% ---");
        se2.increaseSalary(10, true);
        se2.displayInfo();

        // 5. Tạo nhóm dự án không có trưởng nhóm.
        System.out.println("\n--- Buoc 5: Tao du an khong co truong nhom ---");
        ProjectTeam team1 = new ProjectTeam("PRJ01", "He thong quan ly KTX");
        team1.displayTeam();

        // 6. Thêm một nhân sự vào nhóm bằng addMember(employee).
        System.out.println("\n--- Buoc 6: Them emp1 vao team1 ---");
        team1.addMember(emp1);

        // 7. Thêm một kỹ sư bằng addMember(employee, true) để đặt làm trưởng nhóm.
        System.out.println("\n--- Buoc 7: Them se2 vao team1 va dat lam truong nhom ---");
        team1.addMember(se2, true);

        // 8. Thử thêm lại một thành viên đã tồn tại (kiểm tra chống trùng).
        System.out.println("\n--- Buoc 8: Thu them lai emp1 vao team1 ---");
        team1.addMember(emp1);

        // 9. Hiển thị danh sách bằng lời gọi đa hình.
        System.out.println("\n--- Buoc 9: Hien thi thong tin nhom ---");
        team1.displayTeam();

        // 10. Tính tổng chi phí nhân sự hằng tháng.
        System.out.println("\n--- Buoc 10: Tong chi phi thang cua team1 ---");
        System.out.printf("Chi phi thang team1: %.2f\n", team1.calculateTotalMonthlyCost());

        // 11. Thử xóa trưởng nhóm hiện tại và kiểm tra thao tác bị từ chối.
        System.out.println("\n--- Buoc 11: Thu xoa truong nhom se2 ---");
        team1.removeMember(se2.getId());

        // 12. Đổi trưởng nhóm rồi xóa người từng là trưởng nhóm.
        System.out.println("\n--- Buoc 12: Doi truong nhom sang se1 roi xoa se2 ---");
        team1.changeLeader(se1);
        team1.removeMember(se2.getId());
        team1.displayTeam();

        // 13. Tạo một nhóm thứ hai và thêm một nhân sự đã có ở nhóm thứ nhất.
        System.out.println("\n--- Buoc 13: Tao team2 va them emp1 vao team2 ---");
        ProjectTeam team2 = new ProjectTeam("PRJ02", "Ung dung di dong", emp2);
        team2.addMember(emp1);
        team2.displayTeam();

        // 14. Hủy nhóm thứ hai bằng cách kết thúc một khối lệnh cục bộ.
        System.out.println("\n--- Buoc 14: Tao 3 nhom trong scope ---");
        {
            ProjectTeam team3 = new ProjectTeam("PRJ03", "Du an tam thoi");
            team3.addMember(se1);
            System.out.println("Da khoi tao team3 trong khoi lenh scope");
        } // team3 ra khỏi scope và sẽ bị Garbage Collector của Java thu hồi

        // 15. Chứng minh nhân sự của nhóm thứ hai/ba vẫn tồn tại sau khi nhóm bị hủy.
        System.out.println("\n--- Buoc 15: Kiem tra nhan su se1 van ton tai ---");
        System.out.print("Thong tin se1 van nguyen ven: ");
        se1.displayInfo();
    }
}