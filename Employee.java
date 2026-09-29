//202418843
//Dương Quang Anh

public class Employee {
    protected String id;
    protected String fullName;
    protected  double baseSalary;

    public Employee(){
        this("UNKNOW", "Unnamed employee", 0);
    }

    public Employee(String id, String fullName){
        this(id, fullName, 0);
    }

    public Employee(String id, String fullName, double baseSalary){
        if (id == null || id.trim().isEmpty()){
            throw new IllegalArgumentException ("Ma nhan su khong duoc rong.");
        }
        if (fullName == null || fullName.trim().isEmpty()){
            throw new IllegalArgumentException ("Ho ten khong duoc rong");
        }
        if (baseSalary < 0){
            throw new IllegalArgumentException ("Luong co ban khong duoc am");
        }
        this.id = id;
        this.fullName = fullName;
        this.baseSalary = baseSalary;
    }
    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    // Overloading increaseSalary
    public void increaseSalary(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Gia tri tang phai duong");
        }
        this.baseSalary += amount;
    }
    public void increaseSalary(double value, boolean byPercentage) {
        if (value <= 0) {
            throw new IllegalArgumentException("Gia tri tang phai duong");
        }
        if (byPercentage) {
            this.baseSalary += this.baseSalary * (value / 100.0);
        } else {
            this.baseSalary += value;
        }
    }

    // Polimorphic methods
    public double calculateMonthlyCost() {
        return this.baseSalary;
    }

    public void displayInfo() {
        System.out.printf("Employee [ID: %s | Name: %s | Base Salary: %.2f | Monthly Cost: %.2f]\n",
                id, fullName, baseSalary, calculateMonthlyCost());
    }
}