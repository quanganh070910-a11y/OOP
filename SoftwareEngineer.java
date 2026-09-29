//202418843
//Dương Quang Anh

public class SoftwareEngineer extends Employee {
    private String primaryLanguage;
    private double technicalAllowance;

    // Constructors
    public SoftwareEngineer(String id, String fullName, String primaryLanguage) {
        this(id, fullName, 0, primaryLanguage, 0);
    }

    public SoftwareEngineer(String id, String fullName, double baseSalary, String primaryLanguage, double technicalAllowance) {
        super(id, fullName, baseSalary);
        if (primaryLanguage == null || primaryLanguage.trim().isEmpty()) {
            throw new IllegalArgumentException("Ngon ngu chinh khong duoc rong");
        }
        if (technicalAllowance < 0) {
            throw new IllegalArgumentException("Phu cap khong duoc am");
        }
        this.primaryLanguage = primaryLanguage;
        this.technicalAllowance = technicalAllowance;
    }

    // Getters
    public String getPrimaryLanguage() {
        return primaryLanguage;
    }

    public double getTechnicalAllowance() {
        return technicalAllowance;
    }

    @Override
    public double calculateMonthlyCost() {
        return this.baseSalary + this.technicalAllowance;
    }

    @Override
    public void displayInfo() {
        System.out.printf("SoftwareEngineer [ID: %s | Name: %s | Language: %s | Base Salary: %.2f | Allowance: %.2f | Total Cost: %.2f]\n",
                id, fullName, primaryLanguage, baseSalary, technicalAllowance, calculateMonthlyCost());
    }
}