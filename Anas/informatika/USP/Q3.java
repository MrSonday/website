public class Q3{
    public static void main(String[] args){
        EmployeeSalary emp1 = new EmployeeSalary();
        emp1.raiseSalary(5000);

        System.out.println(emp1);
    }
}

class EmployeeSalary{
    public String name;
    private int employeeID;
    private double salary;

    public static int numsES = 0;

    EmployeeSalary(){
        this("Unknown", 0.0);
    }

    EmployeeSalary(String name, double salary){
        this.name = name;
        this.salary = salary;

        numsES++;
        this.employeeID = numsES;
    }

    public String toString(){
        return "Name: " + this.name + ", ID: " + this.employeeID + ", Salary: $" + this.salary;
    }

    public void raiseSalary(double amount){
        if (amount > 0){
            this.salary += amount;
        }
    }

    public void deductSalary(double amount){
        if (amount > 0 && this.salary - amount > 0){
            this.salary -= amount;
        }
    }

    public static int getNumES(){
        return numsES;
    }
}
