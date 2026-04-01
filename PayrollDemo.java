class InvalidSalaryException extends Exception {
    public InvalidSalaryException(String message) {
        super(message);
    }
}
abstract class Employee {
    protected String name;
    protected String id;

    public Employee(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public abstract double calculateMonthlySalary() throws InvalidSalaryException;

    public double printPaySlip() {
        try {
            double salary = calculateMonthlySalary();
            System.out.println(name + " (" + id + ") Salary: " + salary);
            return salary;
        } catch (InvalidSalaryException e) {
            System.out.println("Error for " + name + ": " + e.getMessage());
            return 0;
        }
    }
}
class FullTimeEmployee extends Employee {
    private double annualSalary;

    public FullTimeEmployee(String name, String id, double annualSalary) {
        super(name, id);
        this.annualSalary = annualSalary;
    }

    public double calculateMonthlySalary() throws InvalidSalaryException {
        if (annualSalary <= 0) {
            throw new InvalidSalaryException("Invalid annual salary");
        }
        return annualSalary / 12;
    }
}
class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(String name, String id, double hourlyRate, int hoursWorked) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double calculateMonthlySalary() throws InvalidSalaryException {
        if (hourlyRate <= 0 || hoursWorked < 0) {
            throw new InvalidSalaryException("Invalid hourly data");
        }
        return hourlyRate * hoursWorked;
    }
}
class CommissionEmployee extends Employee {
    private double baseSalary;
    private double salesAmount;
    private double commissionRate;

    public CommissionEmployee(String name, String id, double baseSalary, double salesAmount, double commissionRate) {
        super(name, id);
        this.baseSalary = baseSalary;
        this.salesAmount = salesAmount;
        this.commissionRate = commissionRate;
    }

    public double calculateMonthlySalary() throws InvalidSalaryException {
        if (baseSalary < 0 || salesAmount < 0 || commissionRate < 0 || commissionRate > 1) {
            throw new InvalidSalaryException("Invalid commission data");
        }
        return baseSalary + (salesAmount * commissionRate);
    }
}
public class PayrollDemo {
    public static void main(String[] args) {

        Employee[] employees = new Employee[3];

        employees[0] = new FullTimeEmployee("Ali", "E1", 12000);
        employees[1] = new PartTimeEmployee("John", "E2", 10, 80);
        employees[2] = new CommissionEmployee("Sara", "E3", 500, 2000, 0.1);

        double total = 0;

        for (int i = 0; i < employees.length; i++) {
            total = total + employees[i].printPaySlip();
        }

        System.out.println("Total payroll: " + total);
    }
}